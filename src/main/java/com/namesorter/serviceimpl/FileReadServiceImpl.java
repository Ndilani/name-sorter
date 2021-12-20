package main.java.com.namesorter.serviceimpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import main.java.com.namesorter.model.Name;
import main.java.com.namesorter.service.FileReadService;
import main.java.com.namesorter.util.NameSorterConstants;

/**
 * Implementation of the {@code FileReadService} interface.
 * 
 * @author Dilani Alvis
 *
 */
public class FileReadServiceImpl implements FileReadService {

	private static volatile FileReadService instance = null;

	private FileReadServiceImpl() {
	}

	/**
	 * 
	 * @return {@code FileReadService} instance
	 */
	public static FileReadService getInstance() {
		if (Objects.isNull(instance)) {
			synchronized (FileReadServiceImpl.class) {
				if (Objects.isNull(instance)) {
					instance = new FileReadServiceImpl();
				}
			}
		}
		return instance;
	}

	/**
	 * In here read the given file and return the read file content as the list of
	 * names.
	 * @return nameList
	 */
	@Override
	public List<Name> readFile(String fileName) throws IOException, Exception {

		String line;
		List<Name> nameList = new ArrayList<>();
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while ((line = bufferedReader.readLine()) != null) {

			// validate the given name must have at least one given name and may have up to
			// three given names
			if (line.split(" ").length > 1 && line.split(" ").length < 5) {

				String lastName = line.substring(line.lastIndexOf(" ") + 1);
				String givenName = line.substring(0, line.lastIndexOf(" "));
				nameList.add(new Name(lastName, givenName));
			} else {
				bufferedReader.close();
				throw new Exception(NameSorterConstants.WRONG_NAME_FORMAT_FOUND);
			}
		}
		bufferedReader.close();

		return nameList;
	}

}

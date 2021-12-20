package main.java.com.namesorter.serviceimpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import main.java.com.namesorter.model.Name;
import main.java.com.namesorter.service.FileWriteService;

/**
 * Implementation of the {@code FileWriteService} interface.
 * 
 * @author Dilani ALvis
 *
 */
public class FileWriteServiceImpl implements FileWriteService{
	
private static volatile FileWriteService instance = null;
	
	private FileWriteServiceImpl() {}
	
	/**
	 * 
	 * @return {@code FileWriteService} instanace.
	 */
	public static FileWriteService getInstance() {
		if(Objects.isNull(instance)) {
			synchronized (FileWriteServiceImpl.class) {
				if(Objects.isNull(instance)) {
					instance = new FileWriteServiceImpl();
				}
			}
		}
		return instance;
	}
	/**
	 * In here written the given name list into given text file
	 */
	@Override
	public void fileWrite(String outputFileName, List<Name> names) throws IOException {
		
		FileWriter fileWriter = new FileWriter("./"+ outputFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Name item : names) {
            bufferedWriter.write(item.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        for (Name name : names) {
            System.out.println(name.toString());
        }
	}

}

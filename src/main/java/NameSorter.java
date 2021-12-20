package main.java;

import java.io.IOException;
import java.util.List;

import main.java.com.namesorter.model.Name;
import main.java.com.namesorter.service.FileReadService;
import main.java.com.namesorter.service.FileWriteService;
import main.java.com.namesorter.service.NameSorterService;
import main.java.com.namesorter.serviceimpl.FileReadServiceImpl;
import main.java.com.namesorter.serviceimpl.FileWriteServiceImpl;
import main.java.com.namesorter.serviceimpl.NameSorterServiceImpl;
import main.java.com.namesorter.util.NameSorterConstants;

/**
 * {@code NameSorter} main class that run the process of name sorting.
 * 
 *
 * @author Dilani Alvis
 *
 */
public class NameSorter {

	private static final String SORTED_TEXT_FILE_NAME = "sorted-names-list.txt";

	private static FileReadService fileReadService;

	private static FileWriteService fileWriteService;

	private static NameSorterService nameSorterService;

	public static void main(String[] args) {

		fileReadService = FileReadServiceImpl.getInstance();
		fileWriteService = FileWriteServiceImpl.getInstance();
		nameSorterService = NameSorterServiceImpl.getInstance();

		if (!(args.length == 0) && args.length < 2) {
			String fileName = args[0];
			processNameSort(fileName);
		} else {
			System.out.println(NameSorterConstants.INVALID_ARGUMENT_FOUND);
		}
	}

	/**
	 * Get the file name as the parameter and process the name sort.
	 * 
	 * @param fileName
	 */
	public static void processNameSort(String fileName) {

		List<Name> nameList;

		try {
			nameList = fileReadService.readFile(fileName);
			List<Name> sortedNameList = nameSorterService.sortNameList(nameList);
			fileWriteService.fileWrite(SORTED_TEXT_FILE_NAME, sortedNameList);

		} catch (IOException e) {
			System.out.println(NameSorterConstants.IO_EXCEPTION_OCCURED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

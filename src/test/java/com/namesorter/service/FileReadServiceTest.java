package test.java.com.namesorter.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Test;

import main.java.com.namesorter.service.FileReadService;
import main.java.com.namesorter.serviceimpl.FileReadServiceImpl;

/**
 * Test class for {@code FileReadService}
 * 
 * @author Dilani Alvis
 *
 */
public class FileReadServiceTest {

	private static final String LONG_NAME = "Hunter Uriah Mathew Clarke Micheal";
	private static final String VALID_NAME = "Mathew Clarke Micheal";

	Path path = null;

	@After
	public void afterTest() {
		if (path != null) {
			path.toFile().deleteOnExit();
		}
	}

	@Test(expected = Exception.class)
	public void testReadFileWhenInputMoreThanThreeNamesForGivenNameShouldThrowException()
			throws FileNotFoundException, IOException, Exception {

		String fileName = null;
		try {
			path = Files.createTempFile(Paths.get(".\\"), "testfile", ".txt");
			Files.write(path, LONG_NAME.getBytes(StandardCharsets.UTF_8));
			File file = path.getFileName().toFile();
			fileName = file.getName();
		} catch (IOException ioe) {
			System.err.println("error creating temporary test file in " + this.getClass().getSimpleName());
		}

		FileReadService fileReadService = FileReadServiceImpl.getInstance();
		fileReadService.readFile(fileName);
	}

	@Test(expected = Exception.class)
	public void testReadFileWithoutAnyGivenNameShouldThrowException()
			throws FileNotFoundException, IOException, Exception {

		String fileName = null;
		try {

			path = Files.createTempFile(Paths.get(".\\"), "testfile", ".txt");
			Files.write(path, "Clarke".getBytes(StandardCharsets.UTF_8));
			File file = path.getFileName().toFile();
			fileName = file.getName();

		} catch (IOException ioe) {
			System.err.println("error creating temporary test file in " + this.getClass().getSimpleName());
		}

		FileReadService fileReadService = FileReadServiceImpl.getInstance();
		fileReadService.readFile(fileName);
	}

	@Test(expected = IOException.class)
	public void testReadFileWhenHavingInvalidPathShouldThrowException()
			throws FileNotFoundException, IOException, Exception {

		String fileName = null;
		try {

			path = Files.createTempFile(Paths.get("src\\"), "testfile", ".txt");
			Files.write(path, VALID_NAME.getBytes(StandardCharsets.UTF_8));
			File file = path.getFileName().toFile();
			fileName = file.getName();

		} catch (IOException ioe) {
			System.err.println("error creating temporary test file in " + this.getClass().getSimpleName());
		}

		FileReadService fileReadService = FileReadServiceImpl.getInstance();
		fileReadService.readFile(fileName);
	}
}

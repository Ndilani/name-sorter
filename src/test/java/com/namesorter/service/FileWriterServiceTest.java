package test.java.com.namesorter.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import main.java.com.namesorter.model.Name;
import main.java.com.namesorter.service.FileReadService;
import main.java.com.namesorter.service.FileWriteService;
import main.java.com.namesorter.serviceimpl.FileReadServiceImpl;
import main.java.com.namesorter.serviceimpl.FileWriteServiceImpl;

/**
 * Test class for {@code FileWriteService}
 * 
 * @author Dilani Alvis
 *
 */
public class FileWriterServiceTest {

	String fileName = ".\\test-file.txt";
	Path path = null;

	@After
	public void afterTest() {
		if (path != null)
			path.toFile().deleteOnExit();
	}

	@Test
	public void testFileWriteWhenHavingValidNameListShouldSuccess() throws Exception {

		path = Paths.get(fileName);

		List<Name> nameList = getExpectedSortedNameList();

		FileWriteService fileWriteService = FileWriteServiceImpl.getInstance();
		fileWriteService.fileWrite(fileName, nameList);

		FileReadService fileReadService = FileReadServiceImpl.getInstance();
		List<Name> savedNameList = fileReadService.readFile(fileName);

		assertTrue(nameList.size() == savedNameList.size());
		assertArrayEquals(nameList.toArray(), savedNameList.toArray());
	}

	private List<Name> getExpectedSortedNameList() {

		List<Name> nameList = new ArrayList<Name>();

		nameList.add(new Name("Alvarez", "Marin"));
		nameList.add(new Name("Archer", "Adonis Julius"));
		nameList.add(new Name("Bentley", "Beau Tristan"));
		nameList.add(new Name("Clarke", "Hunter Uriah Mathew"));
		nameList.add(new Name("Gardner", "Leo"));
		nameList.add(new Name("Lewis", "Vaughn"));
		nameList.add(new Name("Lindsey", "London"));
		nameList.add(new Name("Lopez", "Mikayla"));
		nameList.add(new Name("Parsons", "Janet"));
		nameList.add(new Name("Ritter", "Frankie Conner"));
		nameList.add(new Name("Yoder", "Shelby Nathan"));

		return nameList;
	}

}

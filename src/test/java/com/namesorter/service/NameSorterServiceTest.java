package test.java.com.namesorter.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.java.com.namesorter.model.Name;
import main.java.com.namesorter.service.NameSorterService;
import main.java.com.namesorter.serviceimpl.NameSorterServiceImpl;

/**
 * Test class for {@code NameSorterService}
 * 
 * @author Dilani Alvis
 *
 */
public class NameSorterServiceTest {

	@Test
	public void testSortNameListWhenInputValidNameList() {

		List<Name> unsortedNameList = getUnsortedNameList();

		NameSorterService nameSorterService = NameSorterServiceImpl.getInstance();

		List<Name> sortedNameList = nameSorterService.sortNameList(unsortedNameList);

		for (int i = 0; i < sortedNameList.size(); i++) {
			System.out.println(sortedNameList.get(i).getGivenName() + " " + sortedNameList.get(i).getLastName());
		}

		assertTrue(sortedNameList.size() == unsortedNameList.size());
		assertArrayEquals(getExpectedSortedNameList().toArray(), sortedNameList.toArray());
	}

	@Test
	public void testSortNameListWhenInputEmptyArrayList() {

		List<Name> unsortedNameList = new ArrayList<>();

		NameSorterService nameSorterService = NameSorterServiceImpl.getInstance();

		List<Name> sortedNameList = nameSorterService.sortNameList(unsortedNameList);

		assertTrue(sortedNameList.size() == 0);
	}

	@Test
	public void testSortNameListWhenInputNameListWithDuplicateLastNames() {

		List<Name> unsortedNameList = getUnsortedNameListWithDuplicateLastNames();

		NameSorterService nameSorterService = NameSorterServiceImpl.getInstance();

		List<Name> sortedNameList = nameSorterService.sortNameList(unsortedNameList);

		assertTrue(sortedNameList.size() == unsortedNameList.size());
		assertArrayEquals(getExpectedNameListWithDuplicates().toArray(), sortedNameList.toArray());
	}

	private List<Name> getUnsortedNameListWithDuplicateLastNames() {

		List<Name> nameList = new ArrayList<Name>();

		nameList.add(new Name("Parsons", "Janet"));
		nameList.add(new Name("Lewis", "Vaughn"));
		nameList.add(new Name("Archer", "Adonis Julius"));
		nameList.add(new Name("Archer", "Shelby Nathan"));
		nameList.add(new Name("Alvarez", "Marin"));
		nameList.add(new Name("Lindsey", "London"));

		return nameList;
	}

	private List<Name> getExpectedNameListWithDuplicates() {

		List<Name> nameList = new ArrayList<Name>();

		nameList.add(new Name("Alvarez", "Marin"));
		nameList.add(new Name("Archer", "Adonis Julius"));
		nameList.add(new Name("Archer", "Shelby Nathan"));
		nameList.add(new Name("Lewis", "Vaughn"));
		nameList.add(new Name("Lindsey", "London"));
		nameList.add(new Name("Parsons", "Janet"));

		return nameList;
	}

	private List<Name> getUnsortedNameList() {

		List<Name> nameList = new ArrayList<Name>();

		nameList.add(new Name("Parsons", "Janet"));
		nameList.add(new Name("Lewis", "Vaughn"));
		nameList.add(new Name("Archer", "Adonis Julius"));
		nameList.add(new Name("Yoder", "Shelby Nathan"));
		nameList.add(new Name("Alvarez", "Marin"));
		nameList.add(new Name("Lindsey", "London"));
		nameList.add(new Name("Bentley", "Beau Tristan"));
		nameList.add(new Name("Gardner", "Leo"));
		nameList.add(new Name("Clarke", "Hunter Uriah Mathew"));
		nameList.add(new Name("Lopez", "Mikayla"));
		nameList.add(new Name("Ritter", "Frankie Conner"));

		return nameList;
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

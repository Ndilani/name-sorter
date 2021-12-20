package main.java.com.namesorter.serviceimpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import main.java.com.namesorter.model.Name;
import main.java.com.namesorter.service.NameSorterService;

/**
 * Implementation of the {@code NameSorterService} interface.
 * 
 * In here order that given name list first by last name, then by any given
 * names the person may have.
 * 
 * @author Dilani Alvis
 *
 */
public class NameSorterServiceImpl implements NameSorterService {

	private static volatile NameSorterService instance = null;

	private NameSorterServiceImpl() {
	}

	/**
	 * 
	 * @return {@code NameSorterService} instance.
	 */
	public static NameSorterService getInstance() {
		if (Objects.isNull(instance)) {
			synchronized (NameSorterServiceImpl.class) {
				if (Objects.isNull(instance)) {
					instance = new NameSorterServiceImpl();
				}
			}
		}
		return instance;
	}

	/**
	 * Here sort the given name list by using java collection and return sorted name
	 * list.
	 * @return names.
	 */
	@Override
	public List<Name> sortNameList(List<Name> names) {

		Collections.sort(names, Comparator.comparing(Name::getLastName).thenComparing(Name::getGivenName));

		return names;
	}

}

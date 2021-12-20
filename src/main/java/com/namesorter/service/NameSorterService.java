package main.java.com.namesorter.service;

import java.util.List;

import main.java.com.namesorter.model.Name;

/**
 * {@code NameSorterService} interface.
 * 
 * @author Dilani Alvis
 *
 */
public interface NameSorterService {
	
	public List<Name> sortNameList(List<Name> names);
}

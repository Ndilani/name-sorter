package main.java.com.namesorter.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import main.java.com.namesorter.model.Name;

/**
 * {@code FileReadService} interface.
 * 
 * @author Dilani Alvis
 *
 */
public interface FileReadService {
	
	public List<Name> readFile(String fileName) throws FileNotFoundException, IOException, Exception;
}

package main.java.com.namesorter.service;

import java.io.IOException;
import java.util.List;

import main.java.com.namesorter.model.Name;

/**
 * {@code FileWriteService} interface.
 * 
 * @author Dilani Alvis
 *
 */
public interface FileWriteService {
	
	public void fileWrite(String outputFileName, List<Name> names) throws IOException;
}

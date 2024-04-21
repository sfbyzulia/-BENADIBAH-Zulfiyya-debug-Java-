package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads symptom data from a specified file.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * Constructor for creating an object to read symptom data from a file.
	 * 
	 * @param filepath A full or partial path to file with symptom strings in it, one per line.
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Reads symptoms from a file and returns them as a list.
	 * 
	 * @return A list of strings, each representing a symptom read from the file.
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader (new FileReader(filepath))) {
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				System.err.println("Error reading from file:" +e.getMessage());
			}
		}
		
		return result;
	}

}

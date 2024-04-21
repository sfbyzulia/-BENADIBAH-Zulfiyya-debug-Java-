package com.hemebiotech.analytics;

import java.util.List;

/**
 * Represents a data source reader that provides symptom strings.
 * This interface abstracts the method of reading symptom data from various sources.
 */
public interface ISymptomReader {
	
	/**
	 * Reads symptoms from a data source and returns them as a list.
	 * Duplicates are possible if the data source contains multiple entries for the same symptom.
	 * 
	 * @return List of all symptom strings obtained from the data source.
	 */
	List<String> getSymptoms ();
}

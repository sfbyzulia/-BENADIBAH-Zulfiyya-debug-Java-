package com.hemebiotech.analytics;

import java.util.Map;

/**
 * This interface represents a class that can write symptoms with their occurences to an output.
 */
public interface ISymptomWriter {

   /**
    * Writes symptoms and their occurences to an output.

    * @param symptoms a map of symptoms and their occurences.
    */
   void writeSymptoms(Map<String, Integer> symptoms); 
}

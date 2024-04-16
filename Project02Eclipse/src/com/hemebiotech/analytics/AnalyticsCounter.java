package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

        // Reading symptoms from the file and counting them

public class AnalyticsCounter {
    
    public static void main(String[] args) {
        Map<String, Integer> symptomCounts = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {
            String line = reader.readLine();

            while (line != null) {
                symptomCounts.put(line, symptomCounts.getOrDefault(line, 0) + 1);
                line = reader.readLine(); // Read next line
            }
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

		// Using WriteSymptomDataToFile to write the results to a file
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptoms(symptomCounts);
    }
} 
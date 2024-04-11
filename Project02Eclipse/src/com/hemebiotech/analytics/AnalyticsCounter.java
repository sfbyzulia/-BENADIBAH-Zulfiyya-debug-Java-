package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Reads symptoms from a file, counts occurrences of each, and writes results to another file in alphabetical order.
 */
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

        try (FileWriter writer = new FileWriter("result.out")) {
            for (Map.Entry<String, Integer> entry : symptomCounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
} 
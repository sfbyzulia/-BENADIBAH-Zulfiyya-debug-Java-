package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes symptom data to a file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;

    /**
     * Constructs a new instance to write symptom data to the specified file.
     *
     * @param filepath The path of the file where symptoms and their occurrences will be written.
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Writes the symptoms and their occurrences to the file.
     *
     * @param symptoms A map of symptoms and their occurrences.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(filepath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * Main class for counting symptoms from a file and writing them to an output file.
 * This class encapsulates the functionality of reading, processing, and writing symptom data.
 */
public class AnalyticsCounter {
    private ISymptomReader reader;
    private ISymptomWriter writer;

    /**
     * Constructor for AnalyticsCounter.
     * 
     * @param reader An implementation of ISymptomReader for reading symptom data.
     * @param writer An implementation of ISymptomWriter for writing symptom data.
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Processes symptoms by reading, counting and writing them to the output.
     */
    public void processSymptoms () {
        List<String> symptoms = reader.getSymptoms();
        Map<String, Integer> symptomCounts = countSymptoms(symptoms);
        writer.writeSymptoms(symptomCounts);
    }

    /**
     * Counts the occurrences of symptoms.
     * 
     * @param symptoms A list of symptoms.
     * @return A sorted map of symptom counts.
     */
    private Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new TreeMap<>();
        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) +1);
        }
        return symptomCounts;
    }
}
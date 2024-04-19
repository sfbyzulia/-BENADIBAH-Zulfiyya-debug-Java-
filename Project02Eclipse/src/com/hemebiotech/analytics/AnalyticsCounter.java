package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
        // Reading symptoms from the file and counting them

public class AnalyticsCounter {
    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
    public void processSymptoms () {
        List<String> symptoms = reader.getSymptoms();
        Map<String, Integer> symptomCounts = countSymptoms(symptoms);
        writer.writeSymptoms(symptomCounts);
    }
    private Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new TreeMap<>();
        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) +1);
        }
        return symptomCounts;
    }
}
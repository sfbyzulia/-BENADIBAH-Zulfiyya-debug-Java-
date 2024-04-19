package com.hemebiotech.analytics;

public class Main {
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("results.out");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        analyticsCounter.processSymptoms();
    }
}

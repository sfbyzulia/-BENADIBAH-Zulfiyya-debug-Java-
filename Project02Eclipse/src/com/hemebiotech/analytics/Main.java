package com.hemebiotech.analytics;

/**
 * The main class launches the symptom analytics process.
 */
public class Main {

    /**
     * The main method which serves as th enetry point of the program.
     * 
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        analyticsCounter.processSymptoms();
    }
}

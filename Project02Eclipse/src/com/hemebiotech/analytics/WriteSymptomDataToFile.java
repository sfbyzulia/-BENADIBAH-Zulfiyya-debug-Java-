package com.hemebiotech.analytics;


import java.io FileWriter;
import java.io IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomReader {
    private String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath
    }
}

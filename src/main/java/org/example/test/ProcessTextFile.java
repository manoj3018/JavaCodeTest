package org.example.test;


import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ProcessTextFile {

    public static void main(String[] args) {
        // Specify the input and output file paths
        String inputFilePath = "/Users/manoj_k/Documents/Lorem.txt";

        String outputFilePath = "/Users/manoj_k/Documents/output.txt";

        try {
            // Read text from the input file
            String inputText = readTextFromFile(inputFilePath);

            // Process the text and write to the output file
            processAndWriteText(inputText, outputFilePath);

            System.out.println("Processing completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readTextFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        }
    }

    private static void processAndWriteText(String inputText, String outputFilePath) throws IOException {
        // Split the text into words
        String[] words = inputText.split("\\s+");

        // Filter words starting with 's', convert to uppercase, and collect them
        String result = Arrays.stream(words)
                .filter(word -> word.startsWith("s") || word.startsWith("S"))
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));

        // Write the result to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(result);
        }
    }
}


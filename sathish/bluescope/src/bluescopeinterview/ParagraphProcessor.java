package bluescopeinterview;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ParagraphProcessor {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try {
            String userInput = "sathish is good boy ,he is the good person";
            saveInputToFile(userInput, inputFile);

            processFile(inputFile, outputFile);
            System.out.println("Processing complete. Result saved to " + outputFile);

            // Print the content of the output file to the console
            printFileContents(outputFile);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void saveInputToFile(String userInput, String fileName) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(userInput);
        }
    }

    public static void processFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                processParagraph(line, writer);
            }
        }
    }

    private static void processParagraph(String paragraph, PrintWriter writer) {
        String[] words = paragraph.split("\\s+");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (currentLine.length() + word.length() <= 50) {
                currentLine.append(word).append(" ");
            } else {
                writer.println(currentLine.toString().trim());
                currentLine.setLength(0); // Reset the line
                currentLine.append(word).append(" ");
            }
        }

        if (currentLine.length() > 0) {
            writer.println(currentLine.toString().trim());
        }
    }

    private static void printFileContents(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}

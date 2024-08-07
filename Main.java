/**
 * MorseCodeDriver.java :
 *
 * @author winjolu
 * @version 1.0
 */


 import java.io.FileInputStream;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        MorseCodeTree morseCodeTree = new MorseCodeTree();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    morseCodeTree.morseCodeTable();
                    break;
                case 2:
                    System.out.println("Enter the input text file name with Morse code:");
                    String fileName = scanner.nextLine();
                    translateFile(morseCodeTree, fileName);
                    break;
                case 3:
                    System.out.println("Enter a line of Morse code to decode:");
                    String line = scanner.nextLine();
                    decodeLine(morseCodeTree, line);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    /**
     * Displays the user menu with instructions.
     */
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Display Morse code table");
        System.out.println("2. Translate Morse code from file");
        System.out.println("3. Translate Morse code from console input");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Translates a text file written in Morse code into the English alphabet. Calls
     * translateFromMorseCode() to translate the message.
     *
     * @param tree binary tree used for translating.
     */
    private static void translateFile(MorseCodeTree tree, String fileName) {
        try (Scanner fileScanner = new Scanner(new FileInputStream(fileName))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                try {
                    String decodedMessage = tree.translateFromMorseCode(line);
                    System.out.println("Decoded message: " + decodedMessage);
                } catch (Exception e) {
                    System.out.println("Error decoding line: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    /**
     * Reads a binary input from the user and translates it into the English alphabet.
     * Uses the binary tree to decode the message.
     *
     * @param tree MorseCode tree used to decode the message.
     */
    private static void decodeLine(MorseCodeTree tree, String line) {
        try {
            String decodedMessage = tree.translateFromMorseCode(line);
            System.out.println("Decoded message: " + decodedMessage);
        } catch (Exception e) {
            System.out.println("Error decoding line: " + e.getMessage());
        }
    }
}
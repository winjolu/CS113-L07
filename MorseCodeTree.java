
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * MorseCodeTree :
 *
 * @author
 * @version 1.0
 */
public class MorseCodeTree extends BinaryTree<Character> {

    
    // Build this class, which includes the parent BinaryTree implementation in addition to
    // the `translateFromMorseCode` and `readMorseCodeTree` methods. Documentation has been suggested for the former,
    // where said exceptional cases are to be handled according to the corresponding unit tests.



    /**
     * Default constructor creates the Morse code binary tree.
     */
    public MorseCodeTree() {
        readMorseCodeTree();

    }
    


    /**
     * Helper method that creates and populates the Morse code tree. Reads a text file and build the tree
     * based on the data and the codes in the text file. Method is called whenever the constructor is called.
     */
    private void readMorseCodeTree() {
        try (Scanner scanner = new Scanner(new FileInputStream("BinaryCodes.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                char letter = line.charAt(0);
                String code = line.substring(2);
                addToTree(letter, code);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a letter to the tree based on its Morse code.
     *
     * @param letter The letter to add.
     * @param code   The Morse code for the letter.
     */
    private void addToTree(char letter, String code) {
        Node<Character> current = root;
        for (char c : code.toCharArray()) {
            if (c == '*') {
                if (current.left == null) {
                    current.left = new Node<>(null);
                }
                current = current.left;
            } else if (c == '-') {
                if (current.right == null) {
                    current.right = new Node<>(null);
                }
                current = current.right;
            }
        }
        current.data = letter;
    }


    /**
     * Non-recursive method for translating a String comprised of morse code values through traversals
     * in the MorseCodeTree.
     *
     * The given input is expected to contain morse code values, with '*' for dots and '-' for dashes, representing
     * only letters in the English alphabet.
     *
     * This method will also handle exceptional cases, namely if a given token's length exceeds that of the tree's
     * number of possible traversals, or if the given token contains a character that is neither '*' nor '-'.
     *
     * @param morseCode The given input representing letters in Morse code
     * @return a String representing the decoded values from morseCode
     */
    public String translateFromMorseCode(String morseCode) throws Exception {
        StringBuilder decodedMessage = new StringBuilder();
        String[] tokens = morseCode.split(" ");
        for (String token : tokens) {
            if (token.length() > 4 || !token.matches("[*-]+")) {
                throw new Exception("Invalid Morse code token: " + token);
            }
            decodedMessage.append(decodeToken(token));
        }
        return decodedMessage.toString();
    }


    /**
     * Decodes a single Morse code token.
     *
     * @param token The Morse code token to decode.
     * @return The decoded letter.
     */
    private char decodeToken(String token) {
        Node<Character> current = root;
        for (char c : token.toCharArray()) {
            if (c == '*') {
                current = current.left;
            } else if (c == '-') {
                current = current.right;
            }
        }
        return current.data;
    }

    /**
     * Displays a formatted table of all the letters in the alphabet and there corresponding
     * morse code in this tree.
     */
    public void morseCodeTable() {
            System.out.println("Letter\tMorse Code");
            displayMorseCode(root, "");
        }
        
        
        // ! handled in `translateFromMorseCode` method 
    /**
     * Helper method checks if the Morse codes comply with the depth
     * 4, and binary characters "*" "-".
     *
     * @param morseCode strings being tested
     * @throws Exception if conditions are not met.
     */
    // private void validCodeCheck(String[] morseCode) throws Exception {


    // }

            /**
     * Recursively displays the Morse code for each letter in the tree.
     *
     * @param node The current node in the tree.
     * @param code The current Morse code.
     */
    private void displayMorseCode(Node<Character> node, String code) {
        if (node != null) {
            if (node.data != null) {
                System.out.println(node.data + "\t" + code);
            }
            displayMorseCode(node.left, code + "*");
            displayMorseCode(node.right, code + "-");
        }
    }


    // Node class definition
    protected static class Node<E> {
        E data;
        Node<E> left;
        Node<E> right;

        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Root node initialization
    private Node<Character> root = new Node<>(null);
}

// End of class MorseCodeTree
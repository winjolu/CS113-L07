
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * MorseCodeTree :
 *
 * @author
 * @version 1.0
 */
public class MorseCodeTree extends BinaryTree<Character> {

    // TODO:
    // Build this class, which includes the parent BinaryTree implementation in addition to
    // the `translateFromMorseCode` and `readMorseCodeTree` methods. Documentation has been suggested for the former,
    // where said exceptional cases are to be handled according to the corresponding unit tests.



    /**
     * Default constructor creates the Morse code binary tree.
     */


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
        return "";
    }


    /**
     * Helper method that creates and populates the Morse code tree. Reads a text file and build the tree
     * based on the data and the codes in the text file. Method is called whenever the constructor is called.
     */
    private void readMorseCodeTree() {

    }



    /**
     * Displays a formatted table of all the letters in the alphabet and there corresponding
     * morse code in this tree.
     */
    public void morseCodeTable() {


    }


    /**
     * Helper method checks if the Morse codes comply with the depth
     * 4, and binary characters "*" "-".
     *
     * @param morseCode strings being tested
     * @throws Exception if conditions are not met.
     */
    private void validCodeCheck(String[] morseCode) throws Exception {


    }

} // End of class MorseCodeTree
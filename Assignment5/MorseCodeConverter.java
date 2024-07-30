package Assignments.Assignment5;

import java.util.*;
import java.io.*;

import Assignments.Assignment5.*;

/**
 * This class is used to convert Morse code to English and vice versa
 * 
 * @author Youssef Ali Ahmed
 */
public class MorseCodeConverter {
    private static MorseCodeTree tree = new MorseCodeTree();

    /**
     * This method converts a string of English text to Morse code
     * 
     * @param code the English text to be converted
     * @return the Morse code of the English text
     */
    public static String convertToEnglish(String code) {
        String solution = "";
        String[] codeList = code.split(" ");
        for (String letter : codeList) {
            if (letter.equals("/")) {
                solution += " ";
            } else {
                solution += tree.fetch(letter);
            }
        }
        return solution;
    }

    /**
     * This method converts a file of English text to Morse code
     * 
     * @param codeFile the file containing the English text to be converted
     * @return the Morse code of the English text
     * @throws FileNotFoundException if the file is not found
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        String code = "";
        Scanner in = new Scanner(codeFile);
        while (in.hasNextLine()) {
            code += in.nextLine() + " ";
        }
        in.close();
        return convertToEnglish(code);
    }

    /**
     * prints out the binary tree in LNR traversal
     * 
     * @return String representation of the tree
     */
    public static String printTree() {
        String sol = "";
        ArrayList<String> arr = tree.toArrayList();
        for (String ele : arr) {
            if (ele == null) {
                continue;
            }
            sol += ele + " ";
        }
        return sol;
    }
}

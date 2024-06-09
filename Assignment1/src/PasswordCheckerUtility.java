package Assignments.Assignment1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Assignments.Assignment1.exceptions.*;

public class PasswordCheckerUtility {

    /**
     * Compares the values of 2 values, if they don't match throws
     * UnmatchedException.
     * 
     * @param password
     * @param passwordConfirm
     * @throws UnmatchedException
     */
    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (!password.equals(passwordConfirm)) {
            throw new UnmatchedException();
        } else {
            System.out.println("Passwords match");
        }

    }

    /**
     * Compares the values of 2 inputs.
     * 
     * @param password
     * @param passwordConfirm
     * @return true if they are equal, otherwise false.
     */
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        if (!password.equals(passwordConfirm)) {
            return false;
        } else
            return true;
    }

    /**
     * Checks a list of passwords for validation.
     * 
     * @param passwords
     * @return ArrayList of strings that contains all invalid passwords and the
     *         reasoning.
     */
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPasswords = new ArrayList<String>();

        for (String password : passwords) {
            try {
                isValidPassword(password);

            } catch (Exception e) {
                invalidPasswords.add(password + " " + e.getMessage());
            }

        }
        return invalidPasswords;
    }

    /**
     * Checks if password has between 6 and 9 characters.
     * 
     * @param password
     * @return True if between 6 and 9 characters inclusive, false otherwise.
     */
    public static boolean hasBetweenSixAndNineChars(String password) {

        return password.length() >= 6 && password.length() <= 9;
    }

    /**
     * Checks if password has Digit.
     * 
     * @param password
     * @return True if contains a digit, otherwise throws NoDigitException.
     * @throws NoDigitException
     */
    public static boolean hasDigit(String password) throws NoDigitException {
        if (!regexChecker("\\d", password)) {
            throw new NoDigitException();
        } else
            return true;
    }

    /**
     * Checks if password has lower case letter.
     * 
     * @param password
     * @return True if contains a lower case letter, otherwise throws
     *         NoLowerAlphaException.
     * @throws NoLowerAlphaException
     */
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        if (!regexChecker("[a-z]", password)) {
            throw new NoLowerAlphaException();
        } else
            return true;
    }

    /**
     * Checks if password has special character.
     * 
     * @param password
     * @return True if password contains a special character, otherwise throws
     *         NoSpecialCharacterException.
     * @throws NoSpecialCharacterException
     */
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        if (!regexChecker("[^a-zA-Z0-9\\s]", password)) {
            throw new NoSpecialCharacterException();
        } else
            return true;
    }

    /**
     * Checks if password has Upper case letter.
     * 
     * @param password
     * @return True if contains an upper case letter, otherwise throws
     *         NoUpperAlphaException.
     * @throws NoUpperAlphaException
     */
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        if (!regexChecker("[A-Z]", password)) {
            throw new NoUpperAlphaException();
        } else
            return true;

    }

    /**
     * Checks if password has valid length.
     * 
     * @param password
     * @return True if length >= 6, otherwise throws LengthException.
     * @throws LengthException
     */
    public static boolean isValidLength(String password) throws LengthException {
        boolean expression = (password.length() >= 6) ? true : false;
        if (!expression) {
            throw new LengthException();
        } else
            return true;

    }

    /**
     * Checks if password has no more than 2 of the same character in sequence.
     * 
     * @param password
     * @return True if no more than 2 of the same character in sequence, otherwise
     *         throws InvalidSequenceException.
     * @throws InvalidSequenceException
     */
    public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
        if (regexChecker("(.)\\1\\1", password)) {
            throw new InvalidSequenceException();
        } else
            return true;
    }

    /**
     * Checks passowrd against the regex parameter. Used for each test case in
     * password validation.
     * 
     * @param regex
     * @param password
     * @return True if password matches regex, otherwise false.
     */
    public static boolean regexChecker(String regex, String password) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    /**
     * Checks if password is valid.
     * 
     * @param password
     * @return True if password passes all validation tests, otherwise throws proper
     *         exception.
     * @throws LengthException
     * @throws NoUpperAlphaException
     * @throws NoLowerAlphaException
     * @throws NoDigitException
     * @throws NoSpecialCharacterException
     * @throws InvalidSequenceException
     */
    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
            NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {

        return (isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password)
                && hasDigit(password)
                && hasSpecialChar(password) && NoSameCharInSequence(password));
    }

    /**
     * Checks if a valid password is a weak password depending on it's characters.
     * 
     * @param password
     * @return True if password is weak, otherwise throws WeakPasswordException.
     * @throws WeakPasswordException
     * @throws LengthException
     * @throws NoUpperAlphaException
     * @throws NoLowerAlphaException
     * @throws NoDigitException
     * @throws NoSpecialCharacterException
     * @throws InvalidSequenceException
     */
    public static boolean isWeakPassword(String password)
            throws WeakPasswordException, LengthException, NoUpperAlphaException,
            NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        if (isValidPassword(password) && !hasBetweenSixAndNineChars(password)) {
            return false;
        } else
            throw new WeakPasswordException();

    }
}

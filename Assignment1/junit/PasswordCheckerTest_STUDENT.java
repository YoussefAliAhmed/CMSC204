package Assignments.Assignment1.junit;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Assignments.Assignment1.PasswordCheckerUtility;
import Assignments.Assignment1.exceptions.*;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @author
 *
 */
public class PasswordCheckerTest_STUDENT {

	String passwords;
	String regex;
	ArrayList<String> arr;

	@Before
	public void setUp() throws Exception {
		String[] p = { "AsW", "Hello@World", "helloword", "HelloWorld123", "HelloWorld123!", "HELLOWRLD123!",
				"A1B@cd", "HELLLLLo@World1" };
		arr = new ArrayList<String>();
		arr.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
		regex = null;
		arr = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
		try {
			assertTrue(PasswordCheckerUtility.isValidLength(arr.get(1)));
			assertFalse(PasswordCheckerUtility.isValidLength(arr.get(0)));
		} catch (LengthException e) {
			assertEquals("The password must be at least 6 characters long", e.getMessage());
		}
	}

	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(arr.get(4)));
			assertFalse(PasswordCheckerUtility.hasUpperAlpha(arr.get(2)));
		} catch (NoUpperAlphaException e) {
			assertEquals("The password must contain at least one uppercase alphabetic character", e.getMessage());
		}
	}

	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(arr.get(1)));
			assertFalse(PasswordCheckerUtility.hasLowerAlpha(arr.get(5)));
		} catch (NoLowerAlphaException e) {
			assertEquals("The password must contain at least one lowercase alphabetic character", e.getMessage());
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword() {
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(arr.get(6)));
		} catch (Exception e) {
			assertEquals("The password is OK but weak - it contains fewer than 10 characters", e.getMessage());
		}
	}

	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			assertTrue(PasswordCheckerUtility.NoSameCharInSequence(arr.get(3)));
			assertFalse(PasswordCheckerUtility.NoSameCharInSequence(arr.get(7)));
		} catch (InvalidSequenceException e) {
			assertEquals("The password cannot contain more than two of the same character in sequence", e.getMessage());
		}
	}

	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(arr.get(3)));
			assertFalse(PasswordCheckerUtility.hasDigit(arr.get(2)));
		} catch (NoDigitException e) {
			assertEquals("The password must contain at least one digit", e.getMessage());

		}
	}

	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(arr.get(4)));
		} catch (Exception e) {
			fail("This should not have thrown an exception");
		}

	}

	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords
	 * method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results = PasswordCheckerUtility.getInvalidPasswords(arr);
		assertEquals(results.get(0), "AsW The password must be at least 6 characters long");
		assertEquals(results.get(1), "Hello@World The password must contain at least one digit");
		assertEquals(results.get(2), "helloword The password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(3), "HelloWorld123 The password must contain at least one special character");
		assertEquals(results.get(4),
				"HELLOWRLD123! The password must contain at least one lowercase alphabetic character");
	}

	@Test
	public void regexCheckerTest() {
		assertTrue(PasswordCheckerUtility.regexChecker("\\d", "isthereanydigits1231"));
		assertFalse(PasswordCheckerUtility.regexChecker("\\d", "noDigitsHere"));
		assertTrue(PasswordCheckerUtility.regexChecker("[a-z]", "isthereanylowercaseletters"));
		assertFalse(PasswordCheckerUtility.regexChecker("[a-z]", "IT'SALLCAPS"));
		assertTrue(PasswordCheckerUtility.regexChecker("[^a-zA-Z0-9\\s]", "!@#$%^&*()"));
		assertFalse(PasswordCheckerUtility.regexChecker("[^a-zA-Z0-9\\s]", "noCoolCharacters"));
		assertTrue(PasswordCheckerUtility.regexChecker("(.)\\1\\1", "aaahh"));
		assertFalse(PasswordCheckerUtility.regexChecker("(.)\\1\\1", "noSequence"));

	}

}

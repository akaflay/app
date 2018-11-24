package code.better.com.interviews;

import static code.better.com.constants.Constants.EMPTY;
import static code.better.com.constants.Constants.REGULAR_EXPRESSION;

/**
 * 
 * One thing to note in this question is if there are different type of characters
 * Either Special characters, Spaces etc. And we need to ask if they too have to be
 * in palindrom sequence
 *
 */
public class Palindrom {

	

	/**
	 * 
	 * This is done in the Cracking the coding interview book
	 * 
	 * @param inputString
	 * @return boolean
	 * 
	 */
	public boolean checkIfPalindrom(String inputString) {
		if (inputString == null || inputString.length() <= 1)
			return true;
		String cleanedString=cleanString(inputString);
		char[] characters = cleanedString.toCharArray();
		int i = 0;
		int strLength = cleanedString.length();
		while (i < strLength / 2) {
			// check if two characters are not same
			if (characters[i] != characters[strLength - (1 + i)])
				return false;
			i++;
		}
		return true;

	}
	
	/**
	 * 
	 * This function is used to remove any characters other than a-z
	 * 
	 * @param inputString
	 * @return clean string
	 */
	public String cleanString(String inputString) {
		 return inputString.toLowerCase().replaceAll(REGULAR_EXPRESSION, EMPTY);
	}

	/**
	 * 
	 * This is done in the MIT Lecture
	 * 
	 * @param inputString
	 * @return boolean
	 * 
	 */
	public boolean checkIfPalindromRecursion(String inputString) {
		// base case
		if (inputString == null || inputString.length() <= 1)
			return true;
		String cleanedString=cleanString(inputString);
		int length = cleanedString.length();
		// check if two ends are same
		if (cleanedString.charAt(0) != cleanedString.charAt(length - 1))
			return false;
		// call in recursion
		return checkIfPalindromRecursion(cleanedString.substring(1, length - 1));

	}

}

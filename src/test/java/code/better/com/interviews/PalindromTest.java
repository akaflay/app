package code.better.com.interviews;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import code.better.com.interviews.Palindrom;

public class PalindromTest {

	private Palindrom unit;

	@Before
	public void setUp() {
		unit = new Palindrom();
	}

	@Test
	public void testPalindrom() {
		assertTrue(unit.checkIfPalindrom(null));
		assertTrue(unit.checkIfPalindrom(""));
		assertTrue(unit.checkIfPalindrom("a"));
		assertTrue(unit.checkIfPalindrom("aba"));
		long time=System.currentTimeMillis();
		System.out.println(String.format("Time started %s", time));
		assertTrue(unit.checkIfPalindrom("Eva, can I see bees in a cave"));
		System.out.println(String.format("Time ended %s", System.currentTimeMillis()-time));
	}

	@Test
	public void testPalindromRecursion() {
		assertTrue(unit.checkIfPalindromRecursion(null));
		assertTrue(unit.checkIfPalindromRecursion(""));
		assertTrue(unit.checkIfPalindromRecursion("a"));
		assertTrue(unit.checkIfPalindromRecursion("aba"));
		long time=System.currentTimeMillis();
		System.out.println(String.format("Time started %s", time));
		assertTrue(unit.checkIfPalindromRecursion("Eva, can I see bees in a cave"));
		System.out.println(String.format("Time ended %s", System.currentTimeMillis()-time));
	}

}

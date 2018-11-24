package code.better.com.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import code.better.com.interviews.RotatedArray;

public class RotatedArrayTest {

	private RotatedArray unit;

	@Before
	public void setUp() {
		unit = new RotatedArray();
	}

	@Test
	public void testFindNumber() {
		int[] testArray = null;
		assertEquals(-1, unit.findNumber(testArray, 1));
		testArray = new int[] {};
		assertEquals(-1, unit.findNumber(testArray, 1));
		testArray = new int[] { 1 };
		assertEquals(0, unit.findNumber(testArray, 1));
		testArray = new int[] { 1, 2, 3, 4 };
		assertEquals(0, unit.findNumber(testArray, 1));
		testArray = new int[] { 4, 1, 2, 3 };
		assertEquals(1, unit.findNumber(testArray, 1));
		testArray = new int[] { 3, 4, 1, 2 };
		assertEquals(2, unit.findNumber(testArray, 1));
		testArray = new int[] { 2, 3, 4, 1 };
		assertEquals(3, unit.findNumber(testArray, 1));

	}

	@Test
	public void testFindPivot() {
		int[] testArray = null;
		assertEquals(-1, unit.findPivot(testArray, 0, 0));
		testArray = new int[] {};
		assertEquals(-1, unit.findPivot(testArray, 0, 0));
		testArray = new int[] { 1 };
		assertEquals(-1, unit.findPivot(testArray, 0, 1));
		testArray = new int[] { 1, 2, 3, 4 };
		assertEquals(-1, unit.findPivot(testArray, 0, 4));
		testArray = new int[] { 4, 1, 2, 3 };
		assertEquals(0, unit.findPivot(testArray, 0, 4));
		testArray = new int[] { 3, 4, 1, 2 };
		assertEquals(1, unit.findPivot(testArray, 0, 4));
		testArray = new int[] { 2, 3, 4, 1 };
		assertEquals(2, unit.findPivot(testArray, 0, 4));

	}

}

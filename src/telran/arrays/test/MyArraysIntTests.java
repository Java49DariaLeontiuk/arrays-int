package telran.arrays.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static telran.arrays.MyArraysInt.*;

class MyArraysIntTests {

	@Test
	void testAddNumber() {
		int array[] = { 1, 2, 3 };
		int expected[] = { 1, 2, 3, -1 };
		int expected1[] = { 1, 2, 3, 5 };
		int num = -1;
		int num1 = 5;
		int array2[] = new int[0];
		int expected2[] = {7};
		int num2 = 7;
		assertArrayEquals(expected, addNumber(array,num));
		assertArrayEquals(expected1, addNumber(array,num1));
		assertArrayEquals(expected2, addNumber(array2,num2));
	}

	@Test
	void testRemoveNumber() {
		int array[] = { 1, 2, 3, 4, 5 };
		int array1[] = new int[0];
		int expected[] = {2,3,4,5};
		int index = 0;
		int index1 = -1;
		int index2 = 5;
		assertArrayEquals(expected, removeNumber(array, index));
		assertArrayEquals(array, removeNumber(array, index1));
		assertArrayEquals(array, removeNumber(array, index2));
		assertArrayEquals(array1, removeNumber(array1, index));
	}

	@Test
	void testInsertNumber() {
		int array[] = { 1, 2, 3, 4 };
		int array1[] = new int[0];
		int expected[] = {9,1,2,3,4};
		int expected1[] = {9};
		int index = 0;
		int num = 9;
		int index1 = -1;
		int index2 = 6;
		assertArrayEquals(expected, insertNumber(array, index, num));
		assertArrayEquals(array, insertNumber(array, index1, num));
		assertArrayEquals(array, insertNumber(array, index2, num));
		assertArrayEquals(expected1, insertNumber(array1, index, num));
		assertArrayEquals(array1, insertNumber(array1, index2, num));
	}

	@Test
	void testInsertNumberSorted() {
		int array[] = {1,3,5,7};
		int expected[] = {0,1,3,5,7};
		int expected1[] = {1,3,3,5,7};
		int expected2[] = {1,3,5,7,8};
		assertArrayEquals(expected, insertNumberSorted(array, 0));
		assertArrayEquals(expected1, insertNumberSorted(array, 3));
		assertArrayEquals(expected2, insertNumberSorted(array, 8));
		
	}
	@Test
	void testCopyOf() {
		int array[] = { 1, 2, 3 };
		int expected1[] = { 1, 2, 3 };
		int expected2[] = { 1 };
		int expected3[] = { 1, 2, 3, 0, 0, 0 };
		assertArrayEquals(expected1, Arrays.copyOf(array, array.length));
		assertArrayEquals(expected2, Arrays.copyOf(array, 1));
		assertArrayEquals(expected3, Arrays.copyOf(array, 6));
	}

	@Test
	void testArrayCopy() {
		int array[] = { 1, 2, 3 };
		int expected[] = { 5, 10, 1, 2, 20 };
		int arrayDest[] = new int[5];
		arrayDest[4] = 20;
		int array1[] = { 2, 5, 10 };
		System.arraycopy(array, 0, arrayDest, 2, 2);
		System.arraycopy(array1, 1, arrayDest, 0, 2);
		assertArrayEquals(expected, arrayDest);
	}
	
	@Test
	void testBinarySearchInt() {
		//Arrays.binarySearch(int[] array, int key)
		//Write test for standard method binarySearch of the class Arrays 
		//taking array of ints and int numbers
		int array[] = { 3, 4, 5, 6 };
		int array1[] = new int[0];
		int array2[] = { -2, -1, 5, 6 };
		assertEquals(-1, Arrays.binarySearch(array2, -3));
		assertEquals(-3, Arrays.binarySearch(array2, 0));
		assertEquals(1, Arrays.binarySearch(array2, -1));
		assertEquals(-1, Arrays.binarySearch(array1, 0));
		assertEquals(2, Arrays.binarySearch(array, 5));
		assertEquals(-1, Arrays.binarySearch(array, 2));
		assertEquals(-5, Arrays.binarySearch(array, 7));
		assertEquals(-1, Arrays.binarySearch(array1, 0));
		
	}
	@Test
	@Disabled
	void testBinarySearchIntNoSort() {
		int arrayInDuplicateValues[] = {3,3,3,5,8,9};
		int arrayNoSort[] = { 16,3,10,8,2 };
		assertEquals(2, Arrays.binarySearch(arrayInDuplicateValues, 3)); 
		//no guarantee which one will be found.
		assertEquals(-1, Arrays.binarySearch(arrayNoSort, 3));
		assertEquals(2, Arrays.binarySearch(arrayNoSort, 10));
		// if array is not sorted, the results are undefined
		assertEquals(-1, Arrays.binarySearch(arrayInDuplicateValues, 3, 0, 3));
		assertEquals(-1, Arrays.binarySearch(arrayInDuplicateValues, -2, 5, 3));
		assertEquals(-1, Arrays.binarySearch(arrayInDuplicateValues, 0, 15, 3));
	}
}

package telran.arrays;

import java.util.Arrays;

public class MyArraysInt {
	public static int[] addNumber(int[] array, int num) {
		// int arr[] = new int[10];
		// arr - reference to memory block with 10 int num equal 0
		// int arr1[] = {1,2,3}
		// arr1 - reference to memory block with 3 int num 1,2,3
		// arr1 [2] => 3, arr1 [3] => exception
		// adds num at the array's end
		// returns new array with added number
		// using standard method Arrays.copyOf
		int newArray[] = Arrays.copyOf(array, array.length + 1);
		newArray[newArray.length - 1] = num;
		return newArray;
	}

	public static int[] removeNumber(int[] array, int index) {
		// removes element at given index for right index value [0 - array.length -1]
		// - and returns new array with no the removed one
		// returns the source array if for a wrong index value
		// - (less than 0 or greater than array.length -1)
		// using the standard method System.arraycopy
		int[] newArray = array;
		if (index >= 0 && index <= array.length - 1) {
			newArray = new int[array.length - 1];
			System.arraycopy(array, 0, newArray, 0, index);
			System.arraycopy(array, index + 1, newArray, index, (array.length - 1) - index);
		}
		return newArray;
	}

	public static int[] insertNumber(int[] array, int index, int num) {
		// inserts a given num at a given index for right value of the index [0 -
		// array.length]
		// - and returns new array with the inserted num
		// returns the source array for a wrong index value
		// - (less than 0 or greater than array.length)
		// using the standard method System.arraycopy
		if (index >= 0 && index <= array.length) {
			int newArray[] = new int[array.length + 1];
			System.arraycopy(array, 0, newArray, 0, index);
			newArray[index] = num;
			System.arraycopy(array, index, newArray, index + 1, (array.length) - index);
			return newArray;
		} else {
			return array;
		}

	}
	public static int[] insertNumberSorted(int[] array, int num) {
		int index = Arrays.binarySearch(array,num);
		if (index < 0) {
			index = -index - 1;
		}
		return insertNumber(array, index, num);

	}
}

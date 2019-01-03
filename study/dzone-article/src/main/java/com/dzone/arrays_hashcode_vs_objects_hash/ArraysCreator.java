package com.dzone.arrays_hashcode_vs_objects_hash;

public class ArraysCreator {
	public static int[] createArrayOfInts() {
		final int[] ints = new int[3];
		ints[0] = 1;
		ints[1] = 2;
		ints[2] = 3;

		return ints;
	}

	public static Integer[] createArrayOfIntegers() {
		final Integer[] integers = new Integer[3];
		integers[0] = 1;
		integers[1] = 2;
		integers[2] = 3;

		return integers;
	}

	public static String[] createArrayOfStrings() {
		final String[] strings = new String[3];
		strings[0] = "1";
		strings[1] = "2";
		strings[2] = "3";

		return strings;
	}
}

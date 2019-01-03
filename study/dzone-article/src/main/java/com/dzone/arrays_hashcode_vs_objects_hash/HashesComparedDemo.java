package com.dzone.arrays_hashcode_vs_objects_hash;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.System.out;

/**
 * Demonstration that writes output to standard output with
 * hash codes generated for the same underlying array data by
 * both {@code Arrays.hashCode(Object[])} and by
 * {@code Objects.hash(Object...)}.
 */
public class HashesComparedDemo {
	public static void main(String[] args) {

		final int[] integers = ArraysCreator.createArrayOfInts();
		out.println("Arrays.hashCode(int[]) for int[]: " + Arrays.hashCode(integers));
		out.println("Objects.hash(Object...) for int[]:   " + Objects.hash(integers));
		out.println("Objects.hashCode(Object) for int[]:  " + Objects.hashCode(integers));
		final Integer[] refIntegers = ArraysCreator.createArrayOfIntegers();
		out.println("Arrays.hashCode(Object[]) for Integer[]: " + Arrays.hashCode(refIntegers));
		out.println("Objects.hash(Object...) for Integer[]:   " + Objects.hash(refIntegers));
		out.println("Objects.hashCode(Object) for Integer[]:  " + Objects.hashCode(refIntegers));
		final String[] strings = ArraysCreator.createArrayOfStrings();
		out.println("Arrays.hashCode(Object[]) for String[]: " + Arrays.hashCode(strings));
		out.println("Objects.hash(Object...) for String[]:   " + Objects.hash(strings));
		out.println("Objects.hashCode(Object) for String[]:  " + Objects.hashCode(strings));
	}
}

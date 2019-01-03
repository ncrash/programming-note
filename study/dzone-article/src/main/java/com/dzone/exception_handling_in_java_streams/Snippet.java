package com.dzone.exception_handling_in_java_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Snippet {
	public static void main(String[] args) {
		List<String> myList = new ArrayList<>();
		myList.add("A");
		myList.add("B");
		myList.add("C");

		myList.stream()
			.map(Snippet::trySomething)
			.forEach(System.out::println);
	}

	private static String trySomething(String item) {
		try {
			return doSomething(item);
		} catch (MyException e) {
			throw new RuntimeException(e);
		}
	}

	private static String doSomething(String item) {
		if (item.equalsIgnoreCase("c")) {
			throw new MyException();
		} else {
			return item;
		}
	}

	private static class MyException extends RuntimeException {
	}
}

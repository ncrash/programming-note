package com.dzone.exception_handling_in_java_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Snippet {
	public static void main(String[] args) {
		List<String> myList = new ArrayList<>();
		myList.add("A");
		myList.add("B");
		myList.add("C");

		myList.stream()
			.map(wrap(Snippet::doSomething))
			.forEach(System.out::println);
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

	public static <T,R> Function<T,R> wrap(CheckedFunction<T,R> checkedFunction) {
		return t -> {
			try {
				return checkedFunction.apply(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}

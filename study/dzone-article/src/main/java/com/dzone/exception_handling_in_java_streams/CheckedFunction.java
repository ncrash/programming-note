package com.dzone.exception_handling_in_java_streams;

@FunctionalInterface
public interface CheckedFunction<T,R> {
	R apply(T t) throws Exception;
}

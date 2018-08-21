package com.inflearn.oop.movie_asis;

public class Movie {
	public static int REGULAR = 0;
	public static int NEW_RELEASE = 1;
	private int priceCode;

	public Movie(int priceCode) {
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}
}

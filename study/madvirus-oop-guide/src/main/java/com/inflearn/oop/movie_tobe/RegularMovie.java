package com.inflearn.oop.movie_tobe;

public class RegularMovie extends Movie {
	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}

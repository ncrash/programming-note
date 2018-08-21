package com.inflearn.oop.movie_asis;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getFrequentRenterPoints() {
		if (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
			return 2;
		else

			return 1;
	}
}

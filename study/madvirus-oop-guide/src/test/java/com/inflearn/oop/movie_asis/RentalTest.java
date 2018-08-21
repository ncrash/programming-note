package com.inflearn.oop.movie_asis;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RentalTest {
	@Test
	public void test_신규출시_영화_3일_대여비() {
		Movie movie = new Movie(Movie.NEW_RELEASE);
		Rental rental = new Rental(movie, 3);

		assertThat(rental.getFrequentRenterPoints()).isEqualTo(2);
	}

	@Test
	public void test_신규출시_영화_1일_대여비() {
		Movie movie = new Movie(Movie.NEW_RELEASE);
		Rental rental = new Rental(movie, 1);

		assertThat(rental.getFrequentRenterPoints()).isEqualTo(1);
	}

	@Test
	public void test_기존영화_대여비() {
		Movie movie = new Movie(Movie.REGULAR);
		Rental rental = new Rental(movie, 3);

		assertThat(rental.getFrequentRenterPoints()).isEqualTo(1);
	}
}
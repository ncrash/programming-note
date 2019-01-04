package com.kakao.tech;

import org.junit.Test;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class FruitBasketTest {
	@Test
	public void testFruitBaskets() {
		final FruitInfo expected1 = new FruitInfo(
			Arrays.asList("kiwi", "orange", "lemon"),
			new LinkedHashMap<String, Long>() { {
				put("kiwi", 2L);
				put("orange", 2L);
				put("lemon", 2L);
			}}
		);
		final FruitInfo expected2 = new FruitInfo(
			Arrays.asList("banana", "lemon", "kiwi"),
			new LinkedHashMap<String, Long>() { {
				put("banana", 1L);
				put("lemon", 2L);
				put("kiwi", 1L);
			}}
		);
		final FruitInfo expected3 = new FruitInfo(
			Arrays.asList("strawberry", "orange", "lemon", "grape"),
			new LinkedHashMap<String, Long>() { {
				put("strawberry", 2L);
				put("orange", 1L);
				put("lemon", 1L);
				put("grape", 1L);
			}}
		);
		StepVerifier.create(FruitBasket.getFruitsFlux())
			.expectNext(expected1)
			.expectNext(expected2)
			.expectNext(expected3)
			.verifyComplete();
	}
}
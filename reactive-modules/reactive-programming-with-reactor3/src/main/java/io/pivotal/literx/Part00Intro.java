package io.pivotal.literx;

import reactor.core.publisher.Flux;

public class Part00Intro {
	public static void main(String[] args) {
		final Flux<String> flux = Flux.just("A");
		final Flux<String> flux1 = flux.map(s -> "foo" + s);
		flux1.subscribe(System.out::println);
	}
}

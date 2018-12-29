package io.pivotal.literx;

import org.junit.Test;
import reactor.test.StepVerifier;

public class Part01FluxTest {
	private Part01Flux part01Flux = new Part01Flux();

	@Test
	public void empty() {
		StepVerifier.create(part01Flux.emptyFlux()).verifyComplete();
	}

	@Test
	public void fromValues() {
		StepVerifier.create(part01Flux.fooBarFluxFromValues())
			.expectNext("foo", "bar")
			.verifyComplete();
	}

	@Test
	public void fromList() {
		StepVerifier.create(part01Flux.fooBarFluxFromList())
			.expectNext("foo", "bar")
			.verifyComplete();
	}

	@Test
	public void error() {
		StepVerifier.create(part01Flux.errorFlux())
			.verifyError(IllegalStateException.class);
	}

	@Test
	public void countEach100ms() {
		StepVerifier.create(part01Flux.counter())
			.expectNext(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)
			.verifyComplete();
	}
}
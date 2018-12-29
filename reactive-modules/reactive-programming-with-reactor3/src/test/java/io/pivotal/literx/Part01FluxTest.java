package io.pivotal.literx;

import org.junit.Test;
import reactor.test.StepVerifier;

public class Part01FluxTest {
	private Part01Flux workshop = new Part01Flux();

	@Test
	public void empty() {
		StepVerifier.create(workshop.emptyFlux()).verifyComplete();
	}

	@Test
	public void fromValues() {
		StepVerifier.create(workshop.fooBarFluxFromValues())
			.expectNext("foo", "bar")
			.verifyComplete();
	}

	@Test
	public void fromList() {
		StepVerifier.create(workshop.fooBarFluxFromList())
			.expectNext("foo", "bar")
			.verifyComplete();
	}

	@Test
	public void error() {
		StepVerifier.create(workshop.errorFlux())
			.verifyError(IllegalStateException.class);
	}

	@Test
	public void countEach100ms() {
		StepVerifier.create(workshop.counter())
			.expectNext(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)
			.verifyComplete();
	}
}
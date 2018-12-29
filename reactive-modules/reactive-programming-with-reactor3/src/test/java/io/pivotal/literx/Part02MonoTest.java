package io.pivotal.literx;

import org.junit.Test;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Part02MonoTest {
	private Part02Mono workshop = new Part02Mono();

	@Test
	public void empty() {
		StepVerifier.create(workshop.emptyMono())
			.verifyComplete();
	}

	@Test
	public void noSignal() {
		StepVerifier.create(workshop.monoWithNoSignal())
			.expectSubscription()
			.expectNoEvent(Duration.ofSeconds(1))
			.thenCancel()
			.verify();
	}

	@Test
	public void fromValue() {
		StepVerifier.create(workshop.fooMono())
			.expectNext("foo")
			.verifyComplete();
	}

	@Test
	public void error() {
		StepVerifier.create(workshop.errorMono())
			.verifyError(IllegalStateException.class);
	}
}
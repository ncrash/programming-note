package io.pivotal.literx;

import org.junit.Test;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Part02MonoTest {
	final Part02Mono part02Mono = new Part02Mono();

	@Test
	public void empty() {
		StepVerifier.create(part02Mono.emptyMono())
			.verifyComplete();
	}

	@Test
	public void noSignal() {
		StepVerifier.create(part02Mono.monoWithNoSignal())
			.expectSubscription()
			.expectNoEvent(Duration.ofSeconds(1))
			.thenCancel()
			.verify();
	}

	@Test
	public void fromValue() {
		StepVerifier.create(part02Mono.fooMono())
			.expectNext("foo")
			.verifyComplete();
	}

	@Test
	public void error() {
		StepVerifier.create(part02Mono.errorMono())
			.verifyError(IllegalStateException.class);
	}
}
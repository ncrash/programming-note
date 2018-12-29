/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.pivotal.literx;

//generic imports to help with simpler IDEs (ie tech.io)

import io.pivotal.literx.domain.User;
import org.junit.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Learn how to use StepVerifier to test Mono, Flux or any other kind of Reactive Streams Publisher.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://projectreactor.io/docs/test/release/api/reactor/test/StepVerifier.html">StepVerifier Javadoc</a>
 */
public class Part03StepVerifierTest {
	@Test
	public void expectFooBarComplete() {
		final Flux<String> flux = Flux.just("foo", "bar");

		// Use StepVerifier to check that the flux parameter emits "foo" and "bar" elements then completes successfully.
		StepVerifier.create(flux)
			.expectNext("foo")
			.expectNext("bar")
			.verifyComplete();
	}

	@Test
	public void expectFooBarError() {
		final Flux<String> flux = Flux.just("foo", "bar").concatWith(Mono.error(new RuntimeException()));

		// Use StepVerifier to check that the flux parameter emits "foo" and "bar" elements then a RuntimeException error.
		StepVerifier.create(flux)
			.expectNext("foo")
			.expectNext("bar")
			.verifyError(RuntimeException.class);
	}

	@Test
	public void expectSkylerJesseComplete() {
		final Flux<User> flux = Flux.just(new User("swhite", null, null), new User("jpinkman", null, null));

		// Use StepVerifier to check that the flux parameter emits a User with "swhite"username
		// and another one with "jpinkman" then completes successfully.
		StepVerifier.create(flux)
			.assertNext(user -> assertThat(user.getUsername()).isEqualTo("swhite"))
			.assertNext(user -> assertThat(user.getUsername()).isEqualTo("jpinkman"))
			.verifyComplete();
	}

	@Test
	public void expect10Elements() {
		final Flux<Long> flux = Flux.interval(Duration.ofMillis(100)).take(10);

		// Expect 10 elements then complete and notice how long the test takes.
		StepVerifier.create(flux)
			.expectNextCount(10)
			.verifyComplete();
	}

	@Test
	public void expect3600Elements() {
		Supplier<Flux<Long>> supplier = () -> Flux.interval(Duration.ofSeconds(1)).take(3600);

		// Expect 3600 elements at intervals of 1 second, and verify quicker than 3600s
		// by manipulating virtual time thanks to StepVerifier#withVirtualTime, notice how long the test takes
		StepVerifier.withVirtualTime(supplier).thenAwait(Duration.ofHours(1)).expectNextCount(3600).verifyComplete();
	}
}
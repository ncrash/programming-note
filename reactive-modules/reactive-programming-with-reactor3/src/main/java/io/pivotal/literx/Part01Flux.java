package io.pivotal.literx;

//generic imports to help with simpler IDEs (ie tech.io)
import java.util.*;
import java.util.function.*;
import java.time.*;

import reactor.core.publisher.Flux;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {

	//========================================================================================

	// Return an empty Flux
	Flux<String> emptyFlux() {
		return Flux.empty();
	}

	//========================================================================================

	/**
	 * Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
	 *
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#just-T...-">Flux Javadoc</a>
	 */
	Flux<String> fooBarFluxFromValues() {
		return Flux.just("foo", "bar");
	}

	//========================================================================================

	/**
	 * Create a Flux from a List that contains 2 values "foo" and "bar"
	 *
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#fromIterable-java.lang.Iterable-">Flux Javadoc</a>
	 */
	Flux<String> fooBarFluxFromList() {
		return Flux.fromIterable(Arrays.asList("foo", "bar"));
	}

	//========================================================================================

	/**
	 * Create a Flux that emits an IllegalStateException
	 *
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#error-java.util.function.Supplier-">Flux Javadoc</a>
	 */
	Flux<String> errorFlux() {
		return Flux.error(new IllegalStateException());
	}

	//========================================================================================

	/**
	 * Create a Flux that emits increasing values from 0 to 9 each 100ms
	 *
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#interval-java.time.Duration-">Flux Javadoc</a>
	 */
	Flux<Long> counter() {
		return Flux.interval(Duration.ofMillis(100)).take(10);
	}

}
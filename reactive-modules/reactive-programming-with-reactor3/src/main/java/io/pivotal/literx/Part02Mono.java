package io.pivotal.literx;

//generic imports to help with simpler IDEs (ie tech.io)
import java.util.*;
import java.util.function.*;
import java.time.*;

import reactor.core.publisher.Mono;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html#or-reactor.core.publisher.Mono-">Mono.or - Javadoc</a>
 */
public class Part02Mono {

	//========================================================================================

	/**
	 * Return an empty Mono
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html#empty--">Mono Javadoc</a>
	 */
	Mono<String> emptyMono() {
		return Mono.empty();
	}

	//========================================================================================

	/**
	 * Return a Mono that never emits any signal
	 *
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html#never--">Mono Javadoc</a>
	 */
	Mono<String> monoWithNoSignal() {
		return Mono.never();
	}

	//========================================================================================

	/**
	 * Return a Mono that contains a "foo" value
	 *
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html#just-T-">Mono Javadoc</a>
	 */
	Mono<String> fooMono() {
		return Mono.just("foo");
	}

	//========================================================================================

	/**
	 * Create a Mono that emits an IllegalStateException
	 *
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html#error-java.lang.Throwable-">Mono Javadoc</a>
	 */
	Mono<String> errorMono() {
		return Mono.error(new IllegalStateException());
	}
}
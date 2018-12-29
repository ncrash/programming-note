package io.pivotal.literx;

//generic imports to help with simpler IDEs (ie tech.io)
import java.util.*;
import java.util.function.*;
import java.time.*;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to merge flux.
 *
 * @author Sebastien Deleuze
 */
public class Part05Merge {

//========================================================================================

	/**
	 * Merge flux1 and flux2 values with interleave
	 *
	 * @param flux1
	 * @param flux2
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#mergeWith-org.reactivestreams.Publisher-">Flux Javadoc</a>
	 */
	Flux<User> mergeFluxWithInterleave(Flux<User> flux1, Flux<User> flux2) {
		return flux1.mergeWith(flux2);
	}

//========================================================================================

	/**
	 * Merge flux1 and flux2 values with no interleave (flux1 values and then flux2 values)
	 *
	 * @param flux1
	 * @param flux2
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#concatWith-org.reactivestreams.Publisher-">Flux Javadoc</a>
	 */
	Flux<User> mergeFluxWithNoInterleave(Flux<User> flux1, Flux<User> flux2) {
		return flux1.concatWith(flux2);
	}

//========================================================================================

	/**
	 * Create a Flux containing the value of mono1 then the value of mono2
	 *
	 * @param mono1
	 * @param mono2
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#concat-org.reactivestreams.Publisher-">Flux Javadoc</a>
	 */
	Flux<User> createFluxFromMultipleMono(Mono<User> mono1, Mono<User> mono2) {
		return Flux.concat(mono1, mono2);
	}
}
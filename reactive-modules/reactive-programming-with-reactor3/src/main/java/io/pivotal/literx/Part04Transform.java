package io.pivotal.literx;

//generic imports to help with simpler IDEs (ie tech.io)
import java.util.*;
import java.util.function.*;
import java.time.*;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://tech.io/playgrounds/929/reactive-programming-with-reactor-3/transform">Chapter</a>
 */
public class Part04Transform {

	/**
	 * Capitalize the user username, firstname and lastname
	 *
	 * @param mono
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html#map-java.util.function.Function-">Mono Javadoc</a>
	 */
	Mono<User> capitalizeOne(Mono<User> mono) {
		return mono.map(u -> new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase()));
	}

	/**
	 * Capitalize the users username, firstName and lastName
	 *
	 * @param flux
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#map-java.util.function.Function-">Flux Javadoc</a>
	 */
	Flux<User> capitalizeMany(Flux<User> flux) {
		return flux.map(u -> new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase()));
	}

//========================================================================================

	/**
	 * Capitalize the users username, firstName and lastName using #asyncCapitalizeUser
	 *
	 * @param flux
	 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html#flatMap-java.util.function.Function-">Flux Javadoc</a>
	 */
	Flux<User> asyncCapitalizeMany(Flux<User> flux) {
		return flux.flatMap(this::asyncCapitalizeUser);
	}

	Mono<User> asyncCapitalizeUser(User u) {
		return Mono.just(new User(u.getUsername().toUpperCase(), u.getFirstname().toUpperCase(), u.getLastname().toUpperCase()));
	}

}
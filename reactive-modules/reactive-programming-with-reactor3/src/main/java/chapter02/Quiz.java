package chapter02;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Quiz {
	public static void main(String[] args) {
		final Part01Flux part01Flux = new Part01Flux();

		part01Flux.emptyFlux();

		part01Flux.fooBarFluxFromValues();

		part01Flux.fooBarFluxFromList();

		part01Flux.errorFlux();

		part01Flux.counter();
	}
}

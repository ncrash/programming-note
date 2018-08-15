package toby.live;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TOBY TV 6회 - 스프링 리액티브 웹 개발 (2) - Operators
 *
 * Reactive Streams - Operators
 *
 * Publisher -> [Data1] -> Op1 -> [Data2] -> Op2 -> [Data3] -> Subscriber
 *
 * 1. map (d1 -> f -> d2)
 *
 * pub -> [Data1] -> mapPub -> [Data2] -> logSub
 *                <- subscribe(logSub)
 *                -> onSubscribe(s)
 *                -> onNext
 *                -> onNext
 *                -> onComplete
 */
@Slf4j
public class PubSub {
	public static void main(String[] args) {
		Publisher<Integer> pub = iterPub(Stream.iterate(1, a -> a + 1).limit(10).collect(Collectors.toList()));
		Publisher<Integer> mapPub = mapPub(pub, (Function<Integer, Integer>) s -> s * 10);
		mapPub.subscribe(logSub());
	}

	private static Publisher<Integer> mapPub(Publisher<Integer> pub, Function<Integer, Integer> f) {
		return new Publisher<Integer>() {
			@Override
			public void subscribe(Subscriber<? super Integer> sub) {
				pub.subscribe(sub);
			}
		};
	}

	private static Subscriber<Integer> logSub() {
		return new Subscriber<Integer>() {
			@Override
			public void onSubscribe(Subscription s) {
				log.debug("onSubscribe:");
				s.request(Long.MAX_VALUE);

			}

			@Override
			public void onNext(Integer i) {
				log.debug("onNext : {}", i);
			}

			@Override
			public void onError(Throwable t) {
				log.debug("onError : {}", t);
			}

			@Override
			public void onComplete() {
				log.debug("onComplete");
			}
		};
	}

	private static Publisher<Integer> iterPub(List<Integer> iter) {
		return new Publisher<Integer>() {
			@Override
			public void subscribe(Subscriber<? super Integer> sub) {
				sub.onSubscribe(new Subscription() {
					@Override
					public void request(long n) {
						try {
							iter.forEach(s->sub.onNext(s));
							sub.onComplete();
						} catch(Throwable t) {
							sub.onError(t);
						}
					}

					@Override
					public void cancel() {

					}
				});
			}
		};
	}
}

package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
//        ReactiveSources.intNumbersFlux().subscribe(
//                num -> System.out.println(num),
//                error -> System.out.println(error),
//                () -> System.out.println("Complete")
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(new OurSubscription<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class OurSubscription<T> extends BaseSubscriber<T> {
    public void hookOnSubscription(Subscription subscription) {
        System.out.println("Subscriber happened");
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + "received");
        request(3);
    }
}
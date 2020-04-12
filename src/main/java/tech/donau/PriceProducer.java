package tech.donau;

import io.reactivex.Flowable;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class PriceProducer {

    private Random random = new Random();

    @Outgoing("price")
    public Flowable<Integer> producePrice() {
        return Flowable.interval(1, TimeUnit.SECONDS)
                .map(it -> random.nextInt(6000));
    }
}

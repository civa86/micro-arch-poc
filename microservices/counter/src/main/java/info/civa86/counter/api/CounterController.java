package info.civa86.counter.api;

import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class CounterController {

    private static AtomicLong count = new AtomicLong(0);

    @GetMapping(path = "/count")
    public long getCount() {
        return count.getAndIncrement();
    }
}
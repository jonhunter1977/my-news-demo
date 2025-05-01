package newsdemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NewsScheduler {

    private static final Logger logger = LoggerFactory.getLogger(NewsScheduler.class);

    @Scheduled(fixedRate = 10000)
    public void retrieveNews() {
        logger.info("scheduled retrieveNews running");
    }

    public String randomMethod() {
        return "Hello";
    }
}

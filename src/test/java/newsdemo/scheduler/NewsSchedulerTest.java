package newsdemo.scheduler;

import newsdemo.scheduler.NewsScheduler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class NewsSchedulerTest {

    @Autowired
    private NewsScheduler scheduler;

    @Test
    void randomTest() {
//        NewsScheduler scheduler = new NewsScheduler();
        assertEquals("Hello", scheduler.randomMethod());
    }
}

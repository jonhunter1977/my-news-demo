package newsdemo.scheduler;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import newsdemo.repository.NewsRepository;
import newsdemo.retriever.NewsRetriever;


@ExtendWith(MockitoExtension.class)
public class NewsSchedulerTest {

    @Mock
    private NewsRepository newsRepository;

    @Mock
    private NewsRetriever newsRetriever;

    @InjectMocks
    private NewsScheduler newsScheduler;

    @Test
    void verifyfindLastNewsDateRetrievedIsCalled() { 
        // Call the method to be tested
        newsScheduler.retrieveNews();

        // Verify that findLastNewsDateRetrieved was called exactly once
         Mockito.verify(newsRepository, Mockito.times(1)).findLastNewsDateRetrieved();
    }

    @Test
    void verifyRetrieveLatestNewsIsCalled() { 
        // Mock the behavior of findLastNewsDateRetrieved
        when(newsRepository.findLastNewsDateRetrieved()).thenReturn(LocalDate.now());

        // Call the method to be tested
        newsScheduler.retrieveNews(); 
        
        // Verify that retrieveLatestNews was called with the expected argument
        Mockito.verify(newsRetriever, Mockito.times(1)).retrieveLatestNews(LocalDate.now());
    }
}

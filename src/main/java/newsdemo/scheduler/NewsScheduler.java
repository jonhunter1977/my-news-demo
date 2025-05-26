package newsdemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import newsdemo.repository.NewsRepository;
import newsdemo.retriever.NewsRetriever;

@Component
public class NewsScheduler {

    private static final Logger logger = LoggerFactory.getLogger(NewsScheduler.class);
    private final NewsRepository newsRepository;
    private NewsRetriever newsRetriever;

    // Constructor
    public NewsScheduler(NewsRepository newsRepository, NewsRetriever newsRetriever) {
        logger.info("NewsScheduler initialized");

        this.newsRepository = newsRepository; 
        this.newsRetriever = newsRetriever; 
    }

    @Scheduled(fixedRate = 10000)
    public void retrieveNews() {
        logger.info("scheduled retrieveNews running");
        LocalDate lastNewsRetrieved = newsRepository.findLastNewsDateRetrieved();
        newsRetriever.retrieveLatestNews(lastNewsRetrieved);
    }

}

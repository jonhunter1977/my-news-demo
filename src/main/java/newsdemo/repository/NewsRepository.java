package newsdemo.repository;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class NewsRepository {

    private static final Logger logger = LoggerFactory.getLogger(NewsRepository.class);

    public LocalDate findLastNewsDateRetrieved() {
        logger.info("findLastNewsDateRetrieved called");
        return LocalDate.now();
    }

}

package fi.missingprojectfiles.adwize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AdwizeApplication {

    private static final Logger logger = LoggerFactory.getLogger(AdwizeApplication.class);

    public static void main(String[] args) {
        logger.info("Init the application...");
        SpringApplication.run(AdwizeApplication.class, args);
    }
}

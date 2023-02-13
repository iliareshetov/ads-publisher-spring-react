package fi.missingprojectfiles.adwize.jobs;

import fi.missingprojectfiles.adwize.repo.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class AdCleanupJob {

    @Autowired
    private AdRepository adRepository;

// The @Scheduled annotation is used to schedule the deleteOldAds method to run once per day at midnight
// (0 0 0 * * ? is a cron expression that specifies this).
    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteOldAds() {
        LocalDateTime twoWeeksAgo = LocalDateTime.now().minus(2, ChronoUnit.WEEKS);
        adRepository.deleteAdsOlderThan(twoWeeksAgo);
    }
}

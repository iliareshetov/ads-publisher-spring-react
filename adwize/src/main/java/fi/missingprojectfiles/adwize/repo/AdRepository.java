package fi.missingprojectfiles.adwize.repo;

import fi.missingprojectfiles.adwize.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository("adRepository")
public interface AdRepository extends JpaRepository<Ad, UUID> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Ad a WHERE a.createTime < :twoWeeksAgo")
    void deleteAdsOlderThan(LocalDateTime twoWeeksAgo);
}

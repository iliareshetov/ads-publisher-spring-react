package fi.missingprojectfiles.adwize.repo;

import fi.missingprojectfiles.adwize.entity.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("adRepository")
public interface AdRepository extends JpaRepository<Ad, UUID> {
}

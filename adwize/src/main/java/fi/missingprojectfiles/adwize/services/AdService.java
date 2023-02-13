package fi.missingprojectfiles.adwize.services;

import fi.missingprojectfiles.adwize.entity.Ad;
import fi.missingprojectfiles.adwize.repo.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("adService")
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public List<Ad> getAds() {
        return adRepository.findAll();
    }

    @Transactional
    public Ad save(Ad ad) {
        return adRepository.save(ad);
    }


    public void delete(UUID uuid) {
        adRepository.deleteById(uuid);
    }


    public Optional<Ad> getItemById(UUID uuid) {
        return adRepository.findById(uuid);
    }
}

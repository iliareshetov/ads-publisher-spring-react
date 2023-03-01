package fi.missingprojectfiles.adwize.controllers;

import fi.missingprojectfiles.adwize.dto.AdDto;
import fi.missingprojectfiles.adwize.entity.Ad;
import fi.missingprojectfiles.adwize.exceptions.EntryNotFoundException;
import fi.missingprojectfiles.adwize.model.request.ad.UpdateAd;
import fi.missingprojectfiles.adwize.response.ad.AdModel;
import fi.missingprojectfiles.adwize.response.ad.DeleteAdResponse;
import fi.missingprojectfiles.adwize.response.ad.MessageType;
import fi.missingprojectfiles.adwize.services.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdController {

    private static final Logger logger = LoggerFactory.getLogger(AdController.class);

    @Autowired
    private AdService adService;

    @GetMapping(path = "/ads",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AdModel> getAds() {
        logger.info("GET /api/ads");
        return adService.getAds().stream()
                .map(ad -> new AdDto(ad).toModel())
                .collect(Collectors.toList());
    }

    @PutMapping("/ads")
    public Ad updateAd(@RequestBody UpdateAd updateAd) {
        Optional<Ad> adOptional = adService.getItemById(UUID.fromString(updateAd.getId()));
        if(adOptional.isPresent()){
            Ad ad = adOptional.get();
            ad.setTitle(updateAd.getTitle());
            return adService.save(ad);
        }
        throw new EntryNotFoundException();
    }

    @DeleteMapping("/ads/{id}")
    public DeleteAdResponse deleteAd(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        adService.delete(uuid);
        return new DeleteAdResponse(MessageType.SUCCESS, "Ad deleted successfully");
    }

}

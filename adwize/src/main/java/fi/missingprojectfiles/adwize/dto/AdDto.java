package fi.missingprojectfiles.adwize.dto;

import fi.missingprojectfiles.adwize.entity.Ad;
import fi.missingprojectfiles.adwize.response.ad.AdModel;

import java.io.Serializable;

public class AdDto implements Serializable {
    private Ad ad;

    public AdDto(Ad ad) {
        this.ad = ad;
    }

    public AdModel toModel() {
        AdModel adModel = new AdModel();
        adModel.setId(String.valueOf(ad.getId()));
        adModel.setTitle(ad.getTitle());
        adModel.setContent(ad.getContent());
        adModel.setCity(ad.getCity());
        adModel.setAuthorName(ad.getAuthorName());
        adModel.setPrice(ad.getPrice().toString());
        adModel.setViewCount(ad.getViewCount().toString());
        return adModel;
    }

}

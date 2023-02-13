package fi.missingprojectfiles.adwize.model.request.ad;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@ToString
public class UpdateAd implements Serializable {
    private final String id;
    private final String title;
    private final String content;
    private final String city;
    private final String authorName;
    private final String price;
}

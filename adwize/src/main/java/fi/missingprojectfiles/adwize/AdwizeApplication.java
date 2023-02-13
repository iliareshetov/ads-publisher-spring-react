package fi.missingprojectfiles.adwize;

import fi.missingprojectfiles.adwize.entity.Ad;
import fi.missingprojectfiles.adwize.entity.Comment;
import fi.missingprojectfiles.adwize.repo.AdRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@SpringBootApplication
public class AdwizeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdwizeApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(AdRepository adRepository) {
        return args -> {

            Comment c1 = new Comment();
            c1.setAuthorName("Oliver");
            c1.setContent("In hac habitasse platea dictumst. ");

            Comment c2 = new Comment();
            c2.setAuthorName("Charlotte");
            c2.setContent("Proin eu pharetra metus.");

            List<Comment> comments = List.of(c1, c2);

            Ad ad1 = new Ad();
            ad1.setTitle("Volvo S90");
            ad1.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
            ad1.setPrice(BigDecimal.valueOf(30000));
            ad1.setViewCount(BigInteger.valueOf(347));
            ad1.setCity("Helsinki");
            ad1.setAuthorName("Theodore");

            Ad ad2 = new Ad();
            ad2.setTitle("Audi A6");
            ad2.setContent("Curabitur hendrerit facilisis sem non elementum");
            ad2.setPrice(BigDecimal.valueOf(9000));
            ad2.setViewCount(BigInteger.valueOf(5));
            ad2.setCity("Tampere");
            ad1.setAuthorName("Harper");

            List<Ad> ads = List.of(ad1, ad2);

            adRepository.saveAll(ads);

            List<Ad> adsAddComments = adRepository.findAll();

            for (Ad a : adRepository.findAll()) {
                comments.forEach(c -> c.setAd(a));
                a.setComments(comments);
            }

            adRepository.saveAll(adsAddComments);
        };
    }
}

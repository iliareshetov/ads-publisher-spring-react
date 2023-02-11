package fi.missingprojectfiles.adwize.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ads")
@Getter
@Setter
public class Ad extends AbstractTimestampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "viewCount")
    private BigInteger viewCount = BigInteger.ZERO;

    @OneToMany(mappedBy = "ad",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private List<Comment> comments = new ArrayList<>();

}

package com.iespark.urlshortering.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_url")
public class Url
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="l_id",unique = true,nullable = false)
    private Long id;
    @Column(name="c_originalurl")
    private String originalUrl;
    @Column(name="c_shortlink")
    private String shortLink;
    @Column(name="d_creation")
    private LocalDateTime creationDate;
    @Column(name="d_expiration")
    private LocalDateTime expirationDate;
    @Column(name="l_visits")
    private Long totalVisits;

    public Url(Long id, String originalUrl, String shortLink, LocalDateTime creationDate, LocalDateTime expirationDate,Long totalVisits) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortLink = shortLink;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.totalVisits = totalVisits;
    }

    public Url() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(Long totalVisits) {
        this.totalVisits = totalVisits;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", originalUrl='" + originalUrl + '\'' +
                ", shortLink='" + shortLink + '\'' +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                ", totalVisits=" + totalVisits +
                '}';
    }
}

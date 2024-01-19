package com.iespark.urlshortering.service;

import com.google.common.hash.Hashing;
import com.iespark.urlshortering.model.Url;
import com.iespark.urlshortering.model.UrlDto;
import com.iespark.urlshortering.repository.UrlRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

@Component
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlRepository urlRepository;
    @Override
    public Url generateShortLink(UrlDto urlDto) {
        if (StringUtils.isNotEmpty(urlDto.getUrl())) {
            String encodedUrl = encodeUrl(urlDto.getUrl());
            Url urlToPersist = new Url();
            urlToPersist.setCreationDate(LocalDateTime.now());
            urlToPersist.setOriginalUrl(urlDto.getUrl());
            urlToPersist.setShortLink(encodedUrl);
            urlToPersist.setExpirationDate(getExpirationDate(urlDto.getExpirationDate(),urlToPersist.getCreationDate()));
            urlToPersist.setTotalVisits(0L);
            Url urlToRet = persistShortLink(urlToPersist);

            if (urlToRet != null) return urlToRet;
            return null;
        }
        return null;
    }

    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
        if (StringUtils.isBlank(expirationDate)){
            return creationDate.plusSeconds(60);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime expirationDateToRet = LocalDateTime.parse(expirationDate,formatter);
        return expirationDateToRet;
    }

    private String encodeUrl(String url) {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
        return encodedUrl;
    }

    @Override
    public Url persistShortLink(Url url) {
        Url urlToRet = urlRepository.save(url);
        return urlToRet;
    }

    @Override
    public Url getEncodedUrl(String url) {
        Url urlToRet = urlRepository.findByShortLink(url);
        return urlToRet;
    }

    @Override
    public void deleteShortLink(Url url) {
        urlRepository.delete(url);

    }
}

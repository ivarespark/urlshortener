package com.iespark.urlshortering.service;

import com.iespark.urlshortering.model.Url;
import com.iespark.urlshortering.model.UrlDto;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    public Url generateShortLink(UrlDto urlDto);
    public Url persistShortLink(Url url);
    public Url getEncodedUrl(String url);
    public void deleteShortLink(Url url);
    public Url updateUrlVisits(Url url);

}

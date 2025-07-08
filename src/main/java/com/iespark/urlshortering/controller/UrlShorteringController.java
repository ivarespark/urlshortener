package com.iespark.urlshortering.controller;

import com.iespark.urlshortering.model.Url;
import com.iespark.urlshortering.model.UrlDto;
import com.iespark.urlshortering.model.UrlErrorResponseDto;
import com.iespark.urlshortering.model.UrlResponseDto;
import com.iespark.urlshortering.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1")
public class UrlShorteringController {
    @Autowired
    private UrlService urlService;

    @PostMapping(value = "generate")
    public ResponseEntity<?> generateShortLink(@RequestBody UrlDto urlDto){
        Url urlToRet = urlService.generateShortLink(urlDto);
        if(urlToRet != null){
            UrlResponseDto urlResponseDto = new UrlResponseDto();
            urlResponseDto.setOriginalUrl(urlToRet.getOriginalUrl());
            urlResponseDto.setExpirationDate(urlToRet.getExpirationDate());
            urlResponseDto.setShortLink(urlToRet.getShortLink());
            return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
        }

        UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
        urlErrorResponseDto.setStatus("404");
        urlErrorResponseDto.setError("Error procesando respuesta");
        return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK);
    }

}

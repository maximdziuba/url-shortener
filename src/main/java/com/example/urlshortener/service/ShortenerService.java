package com.example.urlshortener.service;

import com.example.urlshortener.model.Link;
import com.example.urlshortener.repository.ShortenerRepository;
import com.example.urlshortener.utils.RandomLinkGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortenerService {

    private final RandomLinkGenerator linkGenerator;
    private final ShortenerRepository shortenerRepository;

    public Link createNewShortLink(String originalLink) {
        var shortLink = linkGenerator.generate();
        var link = new Link(originalLink, shortLink);
        shortenerRepository.save(link);
        return link;
    }

    public Link findByShortLink(String shortLink) {
        var link = shortenerRepository.findByShortUrl(shortLink).orElseThrow();
        return link;
    }
}

package com.example.urlshortener.controller;

import com.example.urlshortener.model.Link;
import com.example.urlshortener.service.ShortenerService;
import com.example.urlshortener.utils.RandomLinkGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ShortenerController {

    private final ShortenerService shortenerService;
    @Value("${server.domain}")
    private String domain;

    @GetMapping
    public String getShortLink() {
        return "index";
    }

    @PostMapping
    public String saveShortLink(@RequestParam String link, Model model) {
        Link createdLink = shortenerService.createNewShortLink(link);
        model.addAttribute("shortLink", createdLink.getShortUrl());
        return "index";
    }

    @GetMapping("/redirect/{shortLinkId}")
    public String redirectToOriginalUrl(@PathVariable String shortLinkId) {
        var shortUrl = domain + "/redirect/" + shortLinkId;
        var link = shortenerService.findByShortLink(shortUrl);
        var originalLink = link.getOriginalUrl();
        return "redirect:" + originalLink;
    }
}

package com.example.urlshortener.repository;

import com.example.urlshortener.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortenerRepository extends JpaRepository<Link, Long> {
    Optional<Link> findByShortUrl(String shortUrl);
}

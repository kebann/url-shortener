package com.bobocode.service;

import com.bobocode.dto.UrlInfoDTO;
import com.bobocode.entity.ShortUrl;
import com.bobocode.exception.NoUrlFoundException;
import com.bobocode.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UrlShortenerService {

  private final UrlRepository urlRepository;

  @Transactional
  @Retryable
  public String shorten(UrlInfoDTO urlInfo) {
    ShortUrl shortenedUrl = new ShortUrl();
    shortenedUrl.setOriginalUrl(urlInfo.url());
    shortenedUrl.setTitle(urlInfo.title());

    ShortUrl savedUrl = urlRepository.save(shortenedUrl);

    return savedUrl.getId();
  }

  @Cacheable("urls")
  public String getOriginalUrl(String urlId) {
    return urlRepository.findById(urlId)
        .map(ShortUrl::getOriginalUrl)
        .orElseThrow(
            () -> new NoUrlFoundException("No short url found for key %s".formatted(urlId)));
  }
}

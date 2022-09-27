package com.bobocode.controller;


import static org.springframework.http.HttpStatus.MOVED_PERMANENTLY;

import com.bobocode.dto.UrlInfoDto;
import com.bobocode.service.UrlShortenerService;
import java.net.URI;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/short-url")
@RequiredArgsConstructor
public class UrlShortenerController {

  private final UrlShortenerService urlShortenerService;

  @PostMapping
  public ResponseEntity<?> shortenUrl(@RequestBody @Valid UrlInfoDto urlInfo) {
    String shortUrlKey = urlShortenerService.shorten(urlInfo);
    return ResponseEntity.created(buildShortURI(shortUrlKey)).build();
  }

  private URI buildShortURI(String shortUrlKey) {
    return ServletUriComponentsBuilder.fromCurrentRequestUri().pathSegment(shortUrlKey).build()
        .toUri();
  }

  @GetMapping("/{urlId}")
  public ResponseEntity<?> getOriginalUrl(@PathVariable String urlId) {
    String url = urlShortenerService.getOriginalUrl(urlId);
    return ResponseEntity.status(MOVED_PERMANENTLY).location(URI.create(url)).build();
  }
}

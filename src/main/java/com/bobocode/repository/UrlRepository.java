package com.bobocode.repository;

import com.bobocode.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<ShortUrl, String> {

}

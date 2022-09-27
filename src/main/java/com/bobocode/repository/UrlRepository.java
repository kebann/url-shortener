package com.bobocode.repository;

import com.bobocode.entity.ShortUrl;
import org.springframework.data.repository.CrudRepository;

public interface UrlRepository extends CrudRepository<ShortUrl, String> {

}

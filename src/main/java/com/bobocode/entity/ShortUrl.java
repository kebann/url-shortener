package com.bobocode.entity;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@Data
public class ShortUrl {

  @Id
  private String id;
  private String originalUrl;
  private String title;
  private LocalDateTime createdAt;
}
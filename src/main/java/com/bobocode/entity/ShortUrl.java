package com.bobocode.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "short_urls")
@Data
public class ShortUrl {

  @Id
  @GeneratedValue(generator = "url-key-generator")
  @GenericGenerator(name = "url-key-generator",
      strategy = "com.bobocode.entity.generator.UrlIdGenerator")
  private String id;

  @Column(nullable = false, updatable = false)
  private String originalUrl;

  private String title;

  @Column(nullable = false, insertable = false, updatable = false)
  private LocalDateTime createdAt;
}
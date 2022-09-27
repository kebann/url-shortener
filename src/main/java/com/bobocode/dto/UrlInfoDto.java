package com.bobocode.dto;

import com.bobocode.validation.ValidUrl;
import javax.validation.constraints.NotBlank;

public record UrlInfoDto(
    @NotBlank(message = "cannot be null or blank")
    @ValidUrl(message = "must be a valid URL")
    String url,
    String title
) {

}

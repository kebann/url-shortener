package com.bobocode.dto;

import javax.validation.constraints.NotBlank;

public record UrlInfoRequest(@NotBlank(message = "cannot be null or blank")
                             String url,
                             String title) {

}

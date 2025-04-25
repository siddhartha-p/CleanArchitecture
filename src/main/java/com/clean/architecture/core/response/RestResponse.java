package com.clean.architecture.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.serde.annotation.Serdeable;


@Serdeable
public record RestResponse<T>(
        String code,
        String message,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data
) {
    public static <T> RestResponse<T> success(T data) {
        return new RestResponse<>("0", "SUCCESS", data);
    }

    public static <T> RestResponse<T> error(String message) {
        return new RestResponse<>("-1", message, null);
    }

    public static RestResponse<Void> success() {
        return new RestResponse<>("0", "SUCCESS", null);
    }
}
package com.clean.architecture.usecase.auth;

import com.clean.architecture.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record AuthenticateUseCaseResponse(String token) implements UseCase.Response {
}

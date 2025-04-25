package com.clean.architecture.usecase.auth;

import com.clean.architecture.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record AuthenticateUseCaseRequest(String username,
                                         String password) implements UseCase.Request {
}

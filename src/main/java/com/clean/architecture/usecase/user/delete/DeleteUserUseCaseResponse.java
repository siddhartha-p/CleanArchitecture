package com.clean.architecture.usecase.user.delete;

import com.clean.architecture.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record DeleteUserUseCaseResponse() implements UseCase.Response {
}

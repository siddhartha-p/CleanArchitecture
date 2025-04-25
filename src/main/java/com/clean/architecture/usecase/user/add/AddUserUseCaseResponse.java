package com.clean.architecture.usecase.user.add;

import com.clean.architecture.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record AddUserUseCaseResponse(String id,
                                     String message) implements UseCase.Response {
}

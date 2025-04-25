package com.clean.architecture.usecase.user.update;

import com.clean.architecture.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;


@Serdeable
public record UpdateUserUseCaseResponse(String id,String message

) implements UseCase.Response {
}

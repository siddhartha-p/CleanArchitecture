package com.clean.architecture.usecase.user.delete;

import com.clean.architecture.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

@Serdeable
public record DeleteUserUseCaseRequest(
        @NotBlank(message = "Id is required")
        String id

) implements UseCase.Request {

}

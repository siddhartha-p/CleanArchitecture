package com.clean.architecture.usecase.user.add;

import com.clean.architecture.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

@Serdeable
public record AddUserUseCaseRequest(
        @NotBlank(message="Id is required")
        String id,
        @NotBlank(message = "Username is required")
        String username,
        @NotBlank(message = "Email is required")
        String email,
        @NotBlank(message = "Address is required")
        String address
) implements UseCase.Request {
}

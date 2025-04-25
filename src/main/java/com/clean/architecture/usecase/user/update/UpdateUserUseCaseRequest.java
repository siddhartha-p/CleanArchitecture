package com.clean.architecture.usecase.user.update;

import com.clean.architecture.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

@Serdeable
public record UpdateUserUseCaseRequest(
   @NotBlank(message="id is required")
   String id,
   String username,
   String email,
   String address
)implements UseCase.Request{

}

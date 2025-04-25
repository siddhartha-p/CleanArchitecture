package com.clean.architecture.usecase.auth;

import com.clean.architecture.core.usecase.UseCase;
import reactor.core.publisher.Mono;

public class AuthenticateUseCase implements UseCase<AuthenticateUseCaseRequest, AuthenticateUseCaseResponse> {
    @Override
    public Mono<AuthenticateUseCaseResponse> execute(AuthenticateUseCaseRequest request) {
        return null;
    }
}

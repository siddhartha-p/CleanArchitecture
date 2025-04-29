package com.clean.architecture.controller;

import com.clean.architecture.core.response.RestResponse;
import com.clean.architecture.usecase.auth.AuthenticateUseCase;
import com.clean.architecture.usecase.auth.AuthenticateUseCaseRequest;
import com.clean.architecture.usecase.auth.AuthenticateUseCaseResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import reactor.core.publisher.Mono;

@Controller("auth")
public class AuthenticateUserController {
    private final AuthenticateUseCase authenticateUseCase;

    public AuthenticateUserController(AuthenticateUseCase authenticateUseCase){
        this.authenticateUseCase=authenticateUseCase;
    }

    @Post("login")
    public Mono<RestResponse<AuthenticateUseCaseResponse>> post(@Body AuthenticateUseCaseRequest payload) {
        return authenticateUseCase.execute(payload)
                .map(RestResponse::success)
                .onErrorResume(err->Mono.just(RestResponse.error(err.getLocalizedMessage())));
    }
}

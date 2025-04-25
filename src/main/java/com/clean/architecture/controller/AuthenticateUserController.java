package com.clean.architecture.controller;

import com.clean.architecture.usecase.auth.AuthenticateUseCaseRequest;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import reactor.core.publisher.Mono;

@Controller("auth")
public class AuthenticateUserController {

    @Post("login")
    public Mono<Object> post(@Body AuthenticateUseCaseRequest payload) {
        System.out.println(payload);
        return Mono.just("Success");
    }
}

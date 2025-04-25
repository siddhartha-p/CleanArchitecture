package com.clean.architecture.core.usecase;

import reactor.core.publisher.Mono;

@FunctionalInterface
//this is called a generic interface
public interface UseCase<I extends UseCase.Request, O extends UseCase.Response> {
    //I must be type that implements UseCase.Request
    //O must be type that implements UseCase.Response
    interface Request {
    }

    interface Response {
    }

    Mono<O> execute(I request);
}

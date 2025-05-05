package com.clean.architecture.core.usecase;

import reactor.core.publisher.Flux;

public interface QueryUseCase <O>{

    interface request{

    };

    interface response{

    };

    Flux<O> execute();
}

package com.clean.architecture.usecase.user.update;

import com.clean.architecture.converter.UserConverter;
import com.clean.architecture.core.usecase.UseCase;
import com.clean.architecture.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.h2.engine.User;
import reactor.core.publisher.Mono;

@Singleton
public class UpdateUserUseCase implements UseCase<UpdateUserUseCaseRequest,UpdateUserUseCaseResponse> {
    public final UserRepository userRepository;

    @Inject
    public UpdateUserUseCase(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public Mono<UpdateUserUseCaseResponse> execute(UpdateUserUseCaseRequest request){
        return userRepository.findById(request.id())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Data for ID "+request.id()+" not found")))
                .flatMap(entity -> {
                   var updatableEntity =  UserConverter.toUpdatableEntity(entity, request);
                   return userRepository.update(updatableEntity)
                           .switchIfEmpty(Mono.error(new IllegalArgumentException("Cannot update")))
                           .map(data -> new UpdateUserUseCaseResponse(data.getId(), "Data with Id "+request.id() +" has updated"));

                });


    }


}

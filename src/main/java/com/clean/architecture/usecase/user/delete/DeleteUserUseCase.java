package com.clean.architecture.usecase.user.delete;

import com.clean.architecture.converter.UserConverter;
import com.clean.architecture.core.usecase.UseCase;
import com.clean.architecture.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import reactor.core.publisher.Mono;

@Named
public class DeleteUserUseCase implements UseCase<DeleteUserUseCaseRequest, DeleteUserUseCaseResponse> {
    private final UserRepository userRepository;

    @Inject
    public DeleteUserUseCase(UserRepository userRepository){
        this.userRepository=userRepository;

    };

    @Override
    public Mono<DeleteUserUseCaseResponse> execute(DeleteUserUseCaseRequest request) {
        String deleteid= UserConverter.tostring(request);
        return userRepository.deleteById(deleteid)
                .map(data -> {
                    System.out.println("DELETED DATA : "+data);
                    return new DeleteUserUseCaseResponse();
                });

    }
}

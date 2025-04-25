package com.clean.architecture.usecase.user.add;

import com.clean.architecture.converter.UserConverter;
import com.clean.architecture.core.usecase.UseCase;
import com.clean.architecture.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
public class AddUserUseCase implements UseCase<AddUserUseCaseRequest, AddUserUseCaseResponse> {
    private final UserRepository userRepository;

    @Inject
    public AddUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<AddUserUseCaseResponse> execute(AddUserUseCaseRequest request) {
        var userEntity = UserConverter.toEntity(request);
        return userRepository.save(userEntity)
                .map(userData -> new AddUserUseCaseResponse(userData.getId(), "Success Add User"))
                .onErrorResume(err -> Mono.error(new Throwable("Error Add User" + err.getLocalizedMessage())));
    }
}

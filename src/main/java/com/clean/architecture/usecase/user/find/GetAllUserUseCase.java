package com.clean.architecture.usecase.user.find;

import com.clean.architecture.core.usecase.QueryUseCase;
import com.clean.architecture.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;

@Singleton
public class GetAllUserUseCase implements QueryUseCase<GetAllUserUseCaseResponse> {

    private final UserRepository userRepository;

    @Inject
    public GetAllUserUseCase(UserRepository userRepository){

        this.userRepository=userRepository;
    }


    @Override
    public  Flux<GetAllUserUseCaseResponse> execute() {
        return userRepository.findAll().map(users-> new GetAllUserUseCaseResponse(
                users.getId(),
                users.getUsername(),
                users.getEmail(),
                users.getAddress()
        ));
    }
}

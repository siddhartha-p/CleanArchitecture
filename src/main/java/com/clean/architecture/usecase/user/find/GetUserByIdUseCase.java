package com.clean.architecture.usecase.user.find;

import com.clean.architecture.core.usecase.UseCase;
import com.clean.architecture.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class GetUserByIdUseCase implements UseCase<GetUserByIDUseCaseRequest, GetUserByIdUseCaseResponse> {

    private final UserRepository userRepository;

    @Inject
    public GetUserByIdUseCase(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public Mono<GetUserByIdUseCaseResponse> execute(GetUserByIDUseCaseRequest request) {
        return userRepository.findById(request.getUserid()).map(user->
            new GetUserByIdUseCaseResponse(
                    user.getUsername(),
                    user.getEmail(),
                    user.getAddress()
            ));



    }


}

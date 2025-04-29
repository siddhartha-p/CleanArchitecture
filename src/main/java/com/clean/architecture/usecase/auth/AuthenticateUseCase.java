package com.clean.architecture.usecase.auth;

import com.clean.architecture.core.usecase.UseCase;
import com.clean.architecture.repository.UserRepository;
import jakarta.inject.Inject;
import org.h2.engine.User;
import org.mindrot.jbcrypt.BCrypt;
import reactor.core.publisher.Mono;

public class AuthenticateUseCase implements UseCase<AuthenticateUseCaseRequest, AuthenticateUseCaseResponse> {

    public final UserRepository userRepository;

    @Inject
    public AuthenticateUseCase(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public Mono<AuthenticateUseCaseResponse> execute(AuthenticateUseCaseRequest request) {
        return userRepository.findByUsername(request.username())
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Data for username "+request.username()+" not found")))
                .flatMap(user->{
                    if(BCrypt.checkpw(request.password(),user.getPassword())){
                        return Mono.just(new AuthenticateUseCaseResponse("password is matched"));
                    }else{
                        return Mono.error(new RuntimeException("invalid password"));
                    }
                });
    }




}

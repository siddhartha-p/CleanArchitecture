package com.clean.architecture.controller;

import com.clean.architecture.Utils.JwtUtils;
import com.clean.architecture.core.response.RestResponse;
import com.clean.architecture.usecase.user.add.AddUserUseCase;
import com.clean.architecture.usecase.user.add.AddUserUseCaseRequest;
import com.clean.architecture.usecase.user.add.AddUserUseCaseResponse;
import com.clean.architecture.usecase.user.delete.DeleteUserUseCase;
import com.clean.architecture.usecase.user.delete.DeleteUserUseCaseRequest;
import com.clean.architecture.usecase.user.delete.DeleteUserUseCaseResponse;
import com.clean.architecture.usecase.user.find.*;
import com.clean.architecture.usecase.user.update.UpdateUserUseCase;
import com.clean.architecture.usecase.user.update.UpdateUserUseCaseRequest;
import com.clean.architecture.usecase.user.update.UpdateUserUseCaseResponse;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


//@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("users")
public class UserController {

    private final AddUserUseCase addUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final GetAllUserUseCase getAllUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;

    // Bean , types of bean in micronaut
// annotation
    @Inject
    public UserController(AddUserUseCase addUserUseCase, DeleteUserUseCase deleteUserUseCase, UpdateUserUseCase updateUserUseCase,
                          GetAllUserUseCase getAllUserUseCase, GetUserByIdUseCase getUserByIdUseCase) {
        this.addUserUseCase = addUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.updateUserUseCase=updateUserUseCase;
        this.getAllUserUseCase=getAllUserUseCase;
        this.getUserByIdUseCase=getUserByIdUseCase;

    }

    @Post("add")
    public Mono<RestResponse<AddUserUseCaseResponse>> post(@Body AddUserUseCaseRequest request, @Header("Authorization") String authorization)
    {
        if (JwtUtils.isValidToken(authorization)) {
            return addUserUseCase.execute(request)
                    .map(RestResponse::success)
                    .onErrorResume(err -> Mono.just(RestResponse.error(err.getLocalizedMessage())));
        }
        return Mono.just(RestResponse.error("invalid Token"));
    }


    @Delete("delete")
    public Mono<RestResponse<DeleteUserUseCaseResponse>> delete(@Body DeleteUserUseCaseRequest request,@Header("Authorization") String authorization){
        if (JwtUtils.isValidToken(authorization)) {
        return this.deleteUserUseCase.execute(request)
                .map(RestResponse::success)
                .onErrorResume(err -> Mono.just(RestResponse.error(err.getLocalizedMessage())));
    }
        return Mono.just(RestResponse.error("invalid Token"));
    }

    @Put("update")
    public Mono<RestResponse<UpdateUserUseCaseResponse>> update(@Body UpdateUserUseCaseRequest request,@Header("Authorization") String authorization) {
        if (JwtUtils.isValidToken(authorization)) {
            return this.updateUserUseCase.execute(request).map(RestResponse::success)
                    .onErrorResume(err -> Mono.just(RestResponse.error(err.getLocalizedMessage())));
        }
        return Mono.just(RestResponse.error("invalid Token"));
    }




     @Get("getAll")
    public Flux<GetAllUserUseCaseResponse> getAllUsers(@Header("Authorization") String authorization){
        if(JwtUtils.isValidToken(authorization)){
                return getAllUserUseCase.execute();
        }

         return Flux.error(new RuntimeException("Invalid token"));
     }

     @Get("getOne/{id}")
    public Mono<GetUserByIdUseCaseResponse> getOneUsers(@PathVariable String id, @Header("Authorization") String authorization){
        if(JwtUtils.isValidToken(authorization)){
            return getUserByIdUseCase.execute(new GetUserByIDUseCaseRequest(id));
        }
        return Mono.error(new RuntimeException("Invalid token"));
     }


    }




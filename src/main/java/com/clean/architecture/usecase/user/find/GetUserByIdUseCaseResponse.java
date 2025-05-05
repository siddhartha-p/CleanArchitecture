package com.clean.architecture.usecase.user.find;

import com.clean.architecture.core.usecase.UseCase;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class GetUserByIdUseCaseResponse implements UseCase.Response{

    private String username;
    private String email;
    private String address;

    public GetUserByIdUseCaseResponse(String username,String email,String address){
        this.username=username;
        this.email=email;
        this.address=address;
    }

    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getAddress(){
        return address;
    }
}

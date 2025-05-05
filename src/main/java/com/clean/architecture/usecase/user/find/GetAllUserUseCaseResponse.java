package com.clean.architecture.usecase.user.find;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class GetAllUserUseCaseResponse {
    private String id;
    private String username;
    private String email;
    private String address;

    public GetAllUserUseCaseResponse(String id,String username,String email,String address){
        this.id=id;
        this.username=username;
        this.email=email;
        this.address=address;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}

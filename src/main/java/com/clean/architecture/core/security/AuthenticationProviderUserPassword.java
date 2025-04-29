//package com.clean.architecture.core.security;
//import io.micronaut.core.annotation.NonNull;
//import io.micronaut.core.annotation.Nullable;
//import io.micronaut.http.HttpRequest;
//import io.micronaut.security.authentication.AuthenticationFailureReason;
//import io.micronaut.security.authentication.AuthenticationRequest;
//import io.micronaut.security.authentication.AuthenticationResponse;
//import io.micronaut.security.authentication.provider.HttpRequestAuthenticationProvider;
//import jakarta.inject.Singleton;
//
//@Singleton
//public class AuthenticationProviderUserPassword <B> implements HttpRequestAuthenticationProvider<B> {
//    @Override
//    public @NonNull AuthenticationResponse authenticate(@Nullable HttpRequest<B> httpRequest,
//                                                        @NonNull AuthenticationRequest<String, String> authenticationRequest)
//    {
//
//        return authenticationRequest.getIdentity().equals("siddhartha08") && authenticationRequest.getSecret().equals("Hashing Password")
//                ? AuthenticationResponse.success(authenticationRequest.getIdentity())
//                :AuthenticationResponse.failure(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH);
//
//    }
//
//}

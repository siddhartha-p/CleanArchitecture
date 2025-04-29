//package com.clean.architecture.controller;
//import io.micronaut.http.MediaType;
//import io.micronaut.http.annotation.Controller;
//import io.micronaut.http.annotation.Get;
//import io.micronaut.http.annotation.Produces;
//import io.micronaut.security.annotation.Secured;
//import io.micronaut.security.rules.SecurityRule;
//
//import java.security.Principal;
//
//
//@Secured(SecurityRule.IS_AUTHENTICATED)
//@Controller
//public class HomeController {
//
//    @Produces(MediaType.TEXT_PLAIN)
//    @Get
//    public String index (Principal principal){
//        System.out.println("this code is working");
//        return principal.getName();
//    }
//}

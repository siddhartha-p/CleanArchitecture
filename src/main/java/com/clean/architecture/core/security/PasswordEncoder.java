package com.clean.architecture.core.security;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {
    public static String hashPassword(String plainPassword){
        return BCrypt.hashpw(plainPassword,BCrypt.gensalt());
    }
}

package com.finaltraining.hotelbooking.utils;

import org.springframework.util.DigestUtils;

public class EncodeSecret {
    public static String hashPass(String password){
        String hashPass = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
        return hashPass;
    }
}

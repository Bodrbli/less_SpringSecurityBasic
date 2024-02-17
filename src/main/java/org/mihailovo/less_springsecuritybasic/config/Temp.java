package org.mihailovo.less_springsecuritybasic.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        System.out.println(encoder.encode("admin"));
        System.out.println(encoder.encode("user"));
        System.out.println(encoder.encode("loser"));
    }
}

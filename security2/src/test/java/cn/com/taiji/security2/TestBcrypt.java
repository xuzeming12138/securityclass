package cn.com.taiji.security2;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

public class TestBcrypt {
    public static void main(String[] args) {
        String p="1";
        String encode = new BCryptPasswordEncoder().encode(p);
        System.out.println(encode);
    }
}

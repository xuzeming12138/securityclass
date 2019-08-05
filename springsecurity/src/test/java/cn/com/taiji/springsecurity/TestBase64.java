package cn.com.taiji.springsecurity;

import java.util.Base64;

public class TestBase64 {
    public static void main(String[] args) {
        String u="u";
        String p="1";
        byte[] bytes = Base64.getEncoder().encode((u+":"+p).getBytes());
        System.out.println(bytes);
    }
}

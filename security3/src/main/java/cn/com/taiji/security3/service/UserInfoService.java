package cn.com.taiji.security3.service;

import cn.com.taiji.security3.bean.UserInfo;

public interface UserInfoService {
    public UserInfo findByUsername(String username);
}
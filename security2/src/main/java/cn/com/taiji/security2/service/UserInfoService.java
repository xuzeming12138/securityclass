package cn.com.taiji.security2.service;

import cn.com.taiji.security2.bean.UserInfo;

public interface UserInfoService {
    public UserInfo findByUsername(String username);
}
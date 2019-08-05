/*
package cn.com.taiji.security2.service;

import Role;
import RoleRepository;
import UserInfo;
import UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataInit {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostConstruct
    public void dataInit() {
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        adminRole.setDescription("管理员");
        Role normalRole = new Role();
        normalRole.setName("ROLE_USER");
        normalRole.setDescription("普通用户");
        roleRepository.save(adminRole);
        roleRepository.save(normalRole);
        List<Role> roles = new ArrayList<>();
        roles.add(adminRole);
        roles.add(normalRole);
        UserInfo admin = new UserInfo();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("1"));
        admin.setRoles(roles);
        userInfoRepository.save(admin);
        roles = new ArrayList<>();
        roles.add(normalRole);
        UserInfo user = new UserInfo();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("1"));
        user.setRoles(roles);
        userInfoRepository.save(user);

    }
}*/

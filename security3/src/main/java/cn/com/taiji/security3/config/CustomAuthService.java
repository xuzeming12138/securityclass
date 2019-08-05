package cn.com.taiji.security3.config;


import cn.com.taiji.security3.bean.Permission;
import cn.com.taiji.security3.bean.PermissionReporitory;
import cn.com.taiji.security3.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class CustomAuthService {
    @Autowired
    PermissionReporitory permissionReporitory;
    public Boolean canAccess(HttpServletRequest request, Authentication authentication){
        //动态鉴权逻辑
        //1.先判断当前的用户有没有认证过
        Object principal = authentication.getPrincipal();
        if (principal == null || "anonymousUser".equals(principal)) {
            return false;
        }
        // 2. 如果是匿名的角色 ROLE_ANONYMOUS
        // 3. 动态鉴权逻辑
        // User
        // Role
        // Permission uid，url接口  的对应关系
        String url = request.getRequestURI().toString();
        Permission permission=permissionReporitory.findByUrl(url);
        if (permission == null || CollectionUtils.isEmpty(permission.getRoles())) {
            return false;
        }
        for (Role role:permission.getRoles()) {
            //2.如果authentication当前用户拥有这个role角色，返回true
            if (CollectionUtils.isEmpty(authentication.getAuthorities())){
                return false;
            }
            for (GrantedAuthority authority:authentication.getAuthorities()) {
                //如果用户拥有访问某个url的权限的角色，就允许
                if (role.getName().equals(authority.getAuthority())){
                    return true;
                }
            }
        }
        /*permission.getRoles().forEach(role -> {
            if (CollectionUtils.isEmpty(authentication.getAuthorities())){
                return false;
            }
        });*/
        return false;
    }
}

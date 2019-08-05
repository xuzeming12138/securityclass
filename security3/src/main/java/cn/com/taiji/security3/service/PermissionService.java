package cn.com.taiji.security3.service;

import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.Map;

public interface PermissionService {
    public Map<String, Collection<ConfigAttribute>> getPermissionMap();
}
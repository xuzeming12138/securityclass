package cn.com.taiji.security3.bean;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionReporitory extends JpaRepository<Permission, Long> {
    public Permission findByUrl(String url);
}
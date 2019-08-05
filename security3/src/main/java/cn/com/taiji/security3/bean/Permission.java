package cn.com.taiji.security3.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Permission {
    @Id
    @GeneratedValue
    private long pid;//主键.

    /**
     *  注意：Permission 表的url通配符为两颗星，比如说 /user下的所有url，应该写成 /user/**;
     */
    private String url;//授权链接

    // 角色 - 权限是多对多的关系
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="RolePermission",joinColumns= {@JoinColumn(name="pid")} , inverseJoinColumns= {@JoinColumn(name="rid")})
    private List<Role> roles;

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
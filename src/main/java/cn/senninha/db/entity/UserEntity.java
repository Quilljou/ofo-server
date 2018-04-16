package cn.senninha.db.entity;

import cn.senninha.web.enums.LoginEnum;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 管理员实体
 * Coded by senninha on 18-1-26
 */
public class UserEntity {
    @Id
    private int id;
    private String username;
    private String password;
    private String region;
    private Date lastLoginTime;
    private int isRoot;
    private String phone;


    public String getUsername() {
        LoginEnum.NOTNULL_USERNAME.getMsg();
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(int isRoot) {
        this.isRoot = isRoot;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + region + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", isRoot=" + isRoot +
                ", phone='" + phone + '\'' +
                '}';
    }
}

package cn.senninha.db.entity;

import java.util.Date;

/**
 * 管理员实体
 * Coded by senninha on 18-1-26
 */
public class UserEntity {
    private int id;
    private String username;
    private String password;
    private String salt;
    private Date lastLoginTime;
    private byte isRoot;
    private String phone;
    private String rights;

    public String getUsername() {
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public byte getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(byte isRoot) {
        this.isRoot = isRoot;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
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
                ", salt='" + salt + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", isRoot=" + isRoot +
                ", phone='" + phone + '\'' +
                ", rights='" + rights + '\'' +
                '}';
    }
}

package com.ssm.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * User Information Table(SsmUser)实体类
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public class SsmUser implements Serializable {
    private static final long serialVersionUID = -72425760209957086L;
/**
     * User ID
     */
    private Long userId;
/**
     * Username
     */
    private String userName;
/**
     * Nickname
     */
    private String nickName;
/**
     * User Email
     */
    private String email;
/**
     * Phone Number
     */
    private String phonenumber;
/**
     * User Gender (0 Male 1 Female 2 Unknown)
     */
    private String sex;
/**
     * Avatar URL
     */
    private String avatar;
/**
     * Password
     */
    private String password;
/**
     * Account Status (0 Active 1 Disabled)
     */
    private String status;
/**
     * Delete Flag (0 Exists 2 Deleted)
     */
    private String delFlag;
/**
     * Last Login IP
     */
    private String loginIp;
/**
     * Last Login Time
     */
    private Date loginDate;
/**
     * Created By
     */
    private String createBy;
/**
     * Creation Time
     */
    private Date createTime;
/**
     * Updated By
     */
    private String updateBy;
/**
     * Update Time
     */
    private Date updateTime;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}


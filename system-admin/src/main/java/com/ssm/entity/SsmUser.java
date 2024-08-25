package com.ssm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * User Information Table(SsmUser)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SsmUser extends SsmBaseEntity implements Serializable {
    private static final long serialVersionUID = -25027710659979270L;
/**
     * User ID
     */
    private Long userId;
/**
     * Username
     */
    @NotNull
    @Size(min = 5, max = 15, message = "The length of username should be between 5 and 15.")
    private String userName;
/**
     * Nickname
     */
    private String nickName;
/**
     * User Email
     */
    @Email
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
    @NotNull
    @Size(min = 5, max = 15, message = "The length of password should be between 5 and 15.")
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

    private List<SsmRole> ssmRoles;
}


package com.ssm.entity;

import java.io.Serializable;

/**
 * User and Role Association Table(SsmUserRole)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public class SsmUserRole implements Serializable {
    private static final long serialVersionUID = -94506801750502223L;
/**
     * User ID
     */
    private Long userId;
/**
     * Role ID
     */
    private Long roleId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}


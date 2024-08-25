package com.ssm.entity;

import java.io.Serializable;

/**
 * User and Role Association Table(SsmUserRole)实体类
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public class SsmUserRole implements Serializable {
    private static final long serialVersionUID = 688209668283373003L;
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


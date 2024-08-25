package com.ssm.entity;

import java.io.Serializable;

/**
 * Role and Menu Association Table(SsmRoleMenu)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public class SsmRoleMenu implements Serializable {
    private static final long serialVersionUID = 479276664081456108L;
/**
     * Role ID
     */
    private Long roleId;
/**
     * Menu ID
     */
    private Long menuId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

}


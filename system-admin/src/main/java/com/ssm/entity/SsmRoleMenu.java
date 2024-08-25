package com.ssm.entity;

import java.io.Serializable;

/**
 * Role and Menu Association Table(SsmRoleMenu)实体类
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public class SsmRoleMenu implements Serializable {
    private static final long serialVersionUID = -65347709023670027L;
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


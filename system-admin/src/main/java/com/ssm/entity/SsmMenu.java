package com.ssm.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * Menu Permissions Table(SsmMenu)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public class SsmMenu implements Serializable {
    private static final long serialVersionUID = -15304502767722689L;
/**
     * Menu ID
     */
    private Long menuId;
/**
     * Menu Name
     */
    private String menuName;
/**
     * Permission Identifier
     */
    private String perms;
/**
     * Parent Menu ID
     */
    private Long parentId;
/**
     * Display Order
     */
    private Integer orderNum;
/**
     * Route Address
     */
    private String path;
/**
     * Component Path
     */
    private String component;
/**
     * Menu Type (M Directory C Menu F Button)
     */
    private String menuType;
/**
     * Menu Status (0 Visible 1 Hidden)
     */
    private String visible;
/**
     * Menu Icon
     */
    private String icon;
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


    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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


package com.ssm.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * Role Information Table(SsmRole)实体类
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public class SsmRole implements Serializable {
    private static final long serialVersionUID = 264498682299226378L;
/**
     * Role ID
     */
    private Long roleId;
/**
     * Role Name
     */
    private String roleName;
/**
     * Role Tag
     */
    private String roleTag;
/**
     * Display Order
     */
    private Integer roleSort;
/**
     * Role Status (0 Active 1 Disabled)
     */
    private String status;
/**
     * Delete Flag (0 Exists 1 Deleted)
     */
    private String delFlag;
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


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }

    public Integer getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(Integer roleSort) {
        this.roleSort = roleSort;
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


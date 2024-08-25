package com.ssm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Role Information Table(SsmRole)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SsmRole implements Serializable {
    private static final long serialVersionUID = -90867016520900095L;
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

    private List<SsmMenu> ssmMenus;
}


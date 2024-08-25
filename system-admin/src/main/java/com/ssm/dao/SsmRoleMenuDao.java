package com.ssm.dao;

import com.ssm.entity.SsmRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Role and Menu Association Table(SsmRoleMenu)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public interface SsmRoleMenuDao {


    SsmRoleMenu queryById(Long roleId);

    List<SsmRoleMenu> queryAllByLimit(SsmRoleMenu ssmRoleMenu, @Param("pageable") Pageable pageable);


    long count(SsmRoleMenu ssmRoleMenu);


    int insert(SsmRoleMenu ssmRoleMenu);


    int insertBatch(@Param("entities") List<SsmRoleMenu> entities);


    int insertOrUpdateBatch(@Param("entities") List<SsmRoleMenu> entities);


    int update(SsmRoleMenu ssmRoleMenu);


    int deleteById(Long roleId);

}


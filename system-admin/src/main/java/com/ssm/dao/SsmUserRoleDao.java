package com.ssm.dao;

import com.ssm.entity.SsmUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * User and Role Association Table(SsmUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public interface SsmUserRoleDao {


    SsmUserRole queryById(Long userId);

    List<SsmUserRole> queryAllByLimit(SsmUserRole ssmUserRole, @Param("pageable") Pageable pageable);


    long count(SsmUserRole ssmUserRole);


    int insert(SsmUserRole ssmUserRole);


    int insertBatch(@Param("entities") List<SsmUserRole> entities);


    int insertOrUpdateBatch(@Param("entities") List<SsmUserRole> entities);

    int update(SsmUserRole ssmUserRole);


    int deleteById(Long userId);

}


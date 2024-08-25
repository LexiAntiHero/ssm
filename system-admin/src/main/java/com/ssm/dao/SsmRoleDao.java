package com.ssm.dao;

import com.ssm.entity.SsmRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;


public interface SsmRoleDao {


    SsmRole queryById(Long roleId);


    List<SsmRole> queryAllByLimit(SsmRole ssmRole, @Param("pageable") Pageable pageable);


    long count(SsmRole ssmRole);


    int insert(SsmRole ssmRole);


    int insertBatch(@Param("entities") List<SsmRole> entities);


    int insertOrUpdateBatch(@Param("entities") List<SsmRole> entities);


    int update(SsmRole ssmRole);


    int deleteById(Long roleId);

}


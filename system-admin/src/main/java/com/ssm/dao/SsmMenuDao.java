package com.ssm.dao;

import com.ssm.entity.SsmMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Menu Permissions Table(SsmMenu)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public interface SsmMenuDao {

    SsmMenu queryById(Long menuId);


    List<SsmMenu> queryAllByLimit(SsmMenu ssmMenu, @Param("pageable") Pageable pageable);


    long count(SsmMenu ssmMenu);


    int insert(SsmMenu ssmMenu);


    int insertBatch(@Param("entities") List<SsmMenu> entities);


    int insertOrUpdateBatch(@Param("entities") List<SsmMenu> entities);

    int update(SsmMenu ssmMenu);


    int deleteById(Long menuId);

}


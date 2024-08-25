package com.ssm.dao;

import com.ssm.entity.SsmRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Role and Menu Association Table(SsmRoleMenu)表数据库访问层
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public interface SsmRoleMenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    SsmRoleMenu queryById(Long roleId);

    /**
     * 查询指定行数据
     *
     * @param ssmRoleMenu 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SsmRoleMenu> queryAllByLimit(SsmRoleMenu ssmRoleMenu, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param ssmRoleMenu 查询条件
     * @return 总行数
     */
    long count(SsmRoleMenu ssmRoleMenu);

    /**
     * 新增数据
     *
     * @param ssmRoleMenu 实例对象
     * @return 影响行数
     */
    int insert(SsmRoleMenu ssmRoleMenu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SsmRoleMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SsmRoleMenu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SsmRoleMenu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SsmRoleMenu> entities);

    /**
     * 修改数据
     *
     * @param ssmRoleMenu 实例对象
     * @return 影响行数
     */
    int update(SsmRoleMenu ssmRoleMenu);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
     */
    int deleteById(Long roleId);

}


package com.ssm.dao;

import com.ssm.entity.SsmUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * User and Role Association Table(SsmUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public interface SsmUserRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SsmUserRole queryById(Long userId);

    /**
     * 查询指定行数据
     *
     * @param ssmUserRole 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SsmUserRole> queryAllByLimit(SsmUserRole ssmUserRole, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param ssmUserRole 查询条件
     * @return 总行数
     */
    long count(SsmUserRole ssmUserRole);

    /**
     * 新增数据
     *
     * @param ssmUserRole 实例对象
     * @return 影响行数
     */
    int insert(SsmUserRole ssmUserRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SsmUserRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SsmUserRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SsmUserRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SsmUserRole> entities);

    /**
     * 修改数据
     *
     * @param ssmUserRole 实例对象
     * @return 影响行数
     */
    int update(SsmUserRole ssmUserRole);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Long userId);

}


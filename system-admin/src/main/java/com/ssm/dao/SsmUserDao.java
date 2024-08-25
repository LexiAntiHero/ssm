package com.ssm.dao;

import com.ssm.entity.SsmUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * User Information Table(SsmUser)表数据库访问层
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public interface SsmUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SsmUser queryById(Long userId);

    /**
     * 查询指定行数据
     *
     * @param ssmUser 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SsmUser> queryAllByLimit(SsmUser ssmUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param ssmUser 查询条件
     * @return 总行数
     */
    long count(SsmUser ssmUser);

    /**
     * 新增数据
     *
     * @param ssmUser 实例对象
     * @return 影响行数
     */
    int insert(SsmUser ssmUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SsmUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SsmUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SsmUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SsmUser> entities);

    /**
     * 修改数据
     *
     * @param ssmUser 实例对象
     * @return 影响行数
     */
    int update(SsmUser ssmUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Long userId);

}


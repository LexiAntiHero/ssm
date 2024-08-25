package com.ssm.service;

import com.ssm.entity.SsmUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * User and Role Association Table(SsmUserRole)表服务接口
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public interface SsmUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SsmUserRole queryById(Long userId);

    /**
     * 分页查询
     *
     * @param ssmUserRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SsmUserRole> queryByPage(SsmUserRole ssmUserRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ssmUserRole 实例对象
     * @return 实例对象
     */
    SsmUserRole insert(SsmUserRole ssmUserRole);

    /**
     * 修改数据
     *
     * @param ssmUserRole 实例对象
     * @return 实例对象
     */
    SsmUserRole update(SsmUserRole ssmUserRole);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

}

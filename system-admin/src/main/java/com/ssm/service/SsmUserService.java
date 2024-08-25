package com.ssm.service;

import com.ssm.entity.SsmUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * User Information Table(SsmUser)表服务接口
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public interface SsmUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SsmUser queryById(Long userId);

    /**
     * 分页查询
     *
     * @param ssmUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SsmUser> queryByPage(SsmUser ssmUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    SsmUser insert(SsmUser ssmUser);

    /**
     * 修改数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    SsmUser update(SsmUser ssmUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

}

package com.ssm.service;

import com.ssm.entity.SsmOperLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Operation Log(SsmOperLog)表服务接口
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
public interface SsmOperLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param operId 主键
     * @return 实例对象
     */
    SsmOperLog queryById(Integer operId);

    /**
     * 分页查询
     *
     * @param ssmOperLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SsmOperLog> queryByPage(SsmOperLog ssmOperLog, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ssmOperLog 实例对象
     * @return 实例对象
     */
    SsmOperLog insert(SsmOperLog ssmOperLog);

    /**
     * 修改数据
     *
     * @param ssmOperLog 实例对象
     * @return 实例对象
     */
    SsmOperLog update(SsmOperLog ssmOperLog);

    /**
     * 通过主键删除数据
     *
     * @param operId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer operId);

}

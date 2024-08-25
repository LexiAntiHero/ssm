package com.ssm.service.impl;

import com.ssm.entity.SsmOperLog;
import com.ssm.dao.SsmOperLogDao;
import com.ssm.service.SsmOperLogService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * Operation Log(SsmOperLog)表服务实现类
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
@Service("ssmOperLogService")
public class SsmOperLogServiceImpl implements SsmOperLogService {
    @Resource
    private SsmOperLogDao ssmOperLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param operId 主键
     * @return 实例对象
     */
    @Override
    public SsmOperLog queryById(Integer operId) {
        return this.ssmOperLogDao.queryById(operId);
    }

    /**
     * 分页查询
     *
     * @param ssmOperLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SsmOperLog> queryByPage(SsmOperLog ssmOperLog, PageRequest pageRequest) {
        long total = this.ssmOperLogDao.count(ssmOperLog);
        return new PageImpl<>(this.ssmOperLogDao.queryAllByLimit(ssmOperLog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ssmOperLog 实例对象
     * @return 实例对象
     */
    @Override
    public SsmOperLog insert(SsmOperLog ssmOperLog) {
        this.ssmOperLogDao.insert(ssmOperLog);
        return ssmOperLog;
    }

    /**
     * 修改数据
     *
     * @param ssmOperLog 实例对象
     * @return 实例对象
     */
    @Override
    public SsmOperLog update(SsmOperLog ssmOperLog) {
        this.ssmOperLogDao.update(ssmOperLog);
        return this.queryById(ssmOperLog.getOperId());
    }

    /**
     * 通过主键删除数据
     *
     * @param operId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer operId) {
        return this.ssmOperLogDao.deleteById(operId) > 0;
    }
}

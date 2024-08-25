package com.ssm.service.impl;

import com.ssm.entity.SsmUser;
import com.ssm.dao.SsmUserDao;
import com.ssm.service.SsmUserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * User Information Table(SsmUser)表服务实现类
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
@Service("ssmUserService")
public class SsmUserServiceImpl implements SsmUserService {
    @Resource
    private SsmUserDao ssmUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public SsmUser queryById(Long userId) {
        return this.ssmUserDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param ssmUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SsmUser> queryByPage(SsmUser ssmUser, PageRequest pageRequest) {
        long total = this.ssmUserDao.count(ssmUser);
        return new PageImpl<>(this.ssmUserDao.queryAllByLimit(ssmUser, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @Override
    public SsmUser insert(SsmUser ssmUser) {
        this.ssmUserDao.insert(ssmUser);
        return ssmUser;
    }

    /**
     * 修改数据
     *
     * @param ssmUser 实例对象
     * @return 实例对象
     */
    @Override
    public SsmUser update(SsmUser ssmUser) {
        this.ssmUserDao.update(ssmUser);
        return this.queryById(ssmUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.ssmUserDao.deleteById(userId) > 0;
    }
}

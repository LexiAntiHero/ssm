package com.ssm.service.impl;

import com.ssm.entity.SsmUserRole;
import com.ssm.dao.SsmUserRoleDao;
import com.ssm.service.SsmUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * User and Role Association Table(SsmUserRole)表服务实现类
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
@Service("ssmUserRoleService")
public class SsmUserRoleServiceImpl implements SsmUserRoleService {
    @Resource
    private SsmUserRoleDao ssmUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public SsmUserRole queryById(Long userId) {
        return this.ssmUserRoleDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param ssmUserRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SsmUserRole> queryByPage(SsmUserRole ssmUserRole, PageRequest pageRequest) {
        long total = this.ssmUserRoleDao.count(ssmUserRole);
        return new PageImpl<>(this.ssmUserRoleDao.queryAllByLimit(ssmUserRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ssmUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public SsmUserRole insert(SsmUserRole ssmUserRole) {
        this.ssmUserRoleDao.insert(ssmUserRole);
        return ssmUserRole;
    }

    /**
     * 修改数据
     *
     * @param ssmUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public SsmUserRole update(SsmUserRole ssmUserRole) {
        this.ssmUserRoleDao.update(ssmUserRole);
        return this.queryById(ssmUserRole.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.ssmUserRoleDao.deleteById(userId) > 0;
    }
}

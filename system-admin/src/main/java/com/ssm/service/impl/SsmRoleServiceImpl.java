package com.ssm.service.impl;

import com.ssm.entity.SsmRole;
import com.ssm.dao.SsmRoleDao;
import com.ssm.service.SsmRoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * Role Information Table(SsmRole)表服务实现类
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
@Service("ssmRoleService")
public class SsmRoleServiceImpl implements SsmRoleService {
    @Resource
    private SsmRoleDao ssmRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public SsmRole queryById(Long roleId) {
        return this.ssmRoleDao.queryById(roleId);
    }

    /**
     * 分页查询
     *
     * @param ssmRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SsmRole> queryByPage(SsmRole ssmRole, PageRequest pageRequest) {
        long total = this.ssmRoleDao.count(ssmRole);
        return new PageImpl<>(this.ssmRoleDao.queryAllByLimit(ssmRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ssmRole 实例对象
     * @return 实例对象
     */
    @Override
    public SsmRole insert(SsmRole ssmRole) {
        this.ssmRoleDao.insert(ssmRole);
        return ssmRole;
    }

    /**
     * 修改数据
     *
     * @param ssmRole 实例对象
     * @return 实例对象
     */
    @Override
    public SsmRole update(SsmRole ssmRole) {
        this.ssmRoleDao.update(ssmRole);
        return this.queryById(ssmRole.getRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long roleId) {
        return this.ssmRoleDao.deleteById(roleId) > 0;
    }
}

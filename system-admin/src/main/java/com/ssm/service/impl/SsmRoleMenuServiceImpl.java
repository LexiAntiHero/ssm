package com.ssm.service.impl;

import com.ssm.entity.SsmRoleMenu;
import com.ssm.dao.SsmRoleMenuDao;
import com.ssm.service.SsmRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * Role and Menu Association Table(SsmRoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
@Service("ssmRoleMenuService")
public class SsmRoleMenuServiceImpl implements SsmRoleMenuService {
    @Resource
    private SsmRoleMenuDao ssmRoleMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public SsmRoleMenu queryById(Long roleId) {
        return this.ssmRoleMenuDao.queryById(roleId);
    }

    /**
     * 分页查询
     *
     * @param ssmRoleMenu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SsmRoleMenu> queryByPage(SsmRoleMenu ssmRoleMenu, PageRequest pageRequest) {
        long total = this.ssmRoleMenuDao.count(ssmRoleMenu);
        return new PageImpl<>(this.ssmRoleMenuDao.queryAllByLimit(ssmRoleMenu, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ssmRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SsmRoleMenu insert(SsmRoleMenu ssmRoleMenu) {
        this.ssmRoleMenuDao.insert(ssmRoleMenu);
        return ssmRoleMenu;
    }

    /**
     * 修改数据
     *
     * @param ssmRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SsmRoleMenu update(SsmRoleMenu ssmRoleMenu) {
        this.ssmRoleMenuDao.update(ssmRoleMenu);
        return this.queryById(ssmRoleMenu.getRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long roleId) {
        return this.ssmRoleMenuDao.deleteById(roleId) > 0;
    }
}

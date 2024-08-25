package com.ssm.service.impl;

import com.ssm.entity.SsmMenu;
import com.ssm.dao.SsmMenuDao;
import com.ssm.service.SsmMenuService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * Menu Permissions Table(SsmMenu)表服务实现类
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
@Service("ssmMenuService")
public class SsmMenuServiceImpl implements SsmMenuService {
    @Resource
    private SsmMenuDao ssmMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param menuId 主键
     * @return 实例对象
     */
    @Override
    public SsmMenu queryById(Long menuId) {
        return this.ssmMenuDao.queryById(menuId);
    }

    /**
     * 分页查询
     *
     * @param ssmMenu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SsmMenu> queryByPage(SsmMenu ssmMenu, PageRequest pageRequest) {
        long total = this.ssmMenuDao.count(ssmMenu);
        return new PageImpl<>(this.ssmMenuDao.queryAllByLimit(ssmMenu, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ssmMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SsmMenu insert(SsmMenu ssmMenu) {
        this.ssmMenuDao.insert(ssmMenu);
        return ssmMenu;
    }

    /**
     * 修改数据
     *
     * @param ssmMenu 实例对象
     * @return 实例对象
     */
    @Override
    public SsmMenu update(SsmMenu ssmMenu) {
        this.ssmMenuDao.update(ssmMenu);
        return this.queryById(ssmMenu.getMenuId());
    }

    /**
     * 通过主键删除数据
     *
     * @param menuId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long menuId) {
        return this.ssmMenuDao.deleteById(menuId) > 0;
    }
}

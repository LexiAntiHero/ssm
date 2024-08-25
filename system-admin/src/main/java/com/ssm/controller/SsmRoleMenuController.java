package com.ssm.controller;

import com.ssm.entity.SsmRoleMenu;
import com.ssm.service.SsmRoleMenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Role and Menu Association Table(SsmRoleMenu)表控制层
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
@RestController
@RequestMapping("ssmRoleMenu")
public class SsmRoleMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SsmRoleMenuService ssmRoleMenuService;

    /**
     * 分页查询
     *
     * @param ssmRoleMenu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SsmRoleMenu>> queryByPage(SsmRoleMenu ssmRoleMenu, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ssmRoleMenuService.queryByPage(ssmRoleMenu, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SsmRoleMenu> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.ssmRoleMenuService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ssmRoleMenu 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SsmRoleMenu> add(SsmRoleMenu ssmRoleMenu) {
        return ResponseEntity.ok(this.ssmRoleMenuService.insert(ssmRoleMenu));
    }

    /**
     * 编辑数据
     *
     * @param ssmRoleMenu 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SsmRoleMenu> edit(SsmRoleMenu ssmRoleMenu) {
        return ResponseEntity.ok(this.ssmRoleMenuService.update(ssmRoleMenu));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.ssmRoleMenuService.deleteById(id));
    }

}


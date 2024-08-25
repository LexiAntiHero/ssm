package com.ssm.controller;

import com.ssm.entity.SsmUserRole;
import com.ssm.service.SsmUserRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * User and Role Association Table(SsmUserRole)表控制层
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
@RestController
@RequestMapping("ssmUserRole")
public class SsmUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SsmUserRoleService ssmUserRoleService;

    /**
     * 分页查询
     *
     * @param ssmUserRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SsmUserRole>> queryByPage(SsmUserRole ssmUserRole, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ssmUserRoleService.queryByPage(ssmUserRole, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SsmUserRole> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.ssmUserRoleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ssmUserRole 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SsmUserRole> add(SsmUserRole ssmUserRole) {
        return ResponseEntity.ok(this.ssmUserRoleService.insert(ssmUserRole));
    }

    /**
     * 编辑数据
     *
     * @param ssmUserRole 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SsmUserRole> edit(SsmUserRole ssmUserRole) {
        return ResponseEntity.ok(this.ssmUserRoleService.update(ssmUserRole));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.ssmUserRoleService.deleteById(id));
    }

}


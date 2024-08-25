package com.ssm.controller;

import com.ssm.entity.SsmRole;
import com.ssm.service.SsmRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Role Information Table(SsmRole)表控制层
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
@RestController
@RequestMapping("ssmRole")
public class SsmRoleController {
    /**
     * 服务对象
     */
    @Resource
    private SsmRoleService ssmRoleService;

    /**
     * 分页查询
     *
     * @param ssmRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SsmRole>> queryByPage(SsmRole ssmRole, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ssmRoleService.queryByPage(ssmRole, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SsmRole> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.ssmRoleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ssmRole 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SsmRole> add(SsmRole ssmRole) {
        return ResponseEntity.ok(this.ssmRoleService.insert(ssmRole));
    }

    /**
     * 编辑数据
     *
     * @param ssmRole 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SsmRole> edit(SsmRole ssmRole) {
        return ResponseEntity.ok(this.ssmRoleService.update(ssmRole));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.ssmRoleService.deleteById(id));
    }

}


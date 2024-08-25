package com.ssm.controller;

import com.ssm.entity.SsmUser;
import com.ssm.service.SsmUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * User Information Table(SsmUser)表控制层
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
@RestController
@RequestMapping("ssmUser")
public class SsmUserController {
    /**
     * 服务对象
     */
    @Resource
    private SsmUserService ssmUserService;

    /**
     * 分页查询
     *
     * @param ssmUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SsmUser>> queryByPage(SsmUser ssmUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ssmUserService.queryByPage(ssmUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SsmUser> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.ssmUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ssmUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SsmUser> add(SsmUser ssmUser) {
        return ResponseEntity.ok(this.ssmUserService.insert(ssmUser));
    }

    /**
     * 编辑数据
     *
     * @param ssmUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SsmUser> edit(SsmUser ssmUser) {
        return ResponseEntity.ok(this.ssmUserService.update(ssmUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.ssmUserService.deleteById(id));
    }

}


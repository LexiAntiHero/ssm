package com.ssm.controller;

import com.ssm.entity.SsmOperLog;
import com.ssm.service.SsmOperLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Operation Log(SsmOperLog)表控制层
 *
 * @author makejava
 * @since 2024-07-26 20:56:27
 */
@RestController
@RequestMapping("ssmOperLog")
public class SsmOperLogController {
    /**
     * 服务对象
     */
    @Resource
    private SsmOperLogService ssmOperLogService;

    /**
     * 分页查询
     *
     * @param ssmOperLog 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SsmOperLog>> queryByPage(SsmOperLog ssmOperLog, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ssmOperLogService.queryByPage(ssmOperLog, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SsmOperLog> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.ssmOperLogService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ssmOperLog 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SsmOperLog> add(SsmOperLog ssmOperLog) {
        return ResponseEntity.ok(this.ssmOperLogService.insert(ssmOperLog));
    }

    /**
     * 编辑数据
     *
     * @param ssmOperLog 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SsmOperLog> edit(SsmOperLog ssmOperLog) {
        return ResponseEntity.ok(this.ssmOperLogService.update(ssmOperLog));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.ssmOperLogService.deleteById(id));
    }

}


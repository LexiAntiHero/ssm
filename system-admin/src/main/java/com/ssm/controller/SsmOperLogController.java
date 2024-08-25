package com.ssm.controller;

import com.ssm.entity.SsmOperLog;
import com.ssm.service.SsmOperLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("ssmOperLog")
public class SsmOperLogController {

    @Resource
    private SsmOperLogService ssmOperLogService;


    @GetMapping
    public ResponseEntity<Page<SsmOperLog>> queryByPage(SsmOperLog ssmOperLog, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ssmOperLogService.queryByPage(ssmOperLog, pageRequest));
    }


    @GetMapping("{id}")
    public ResponseEntity<SsmOperLog> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.ssmOperLogService.queryById(id));
    }


    @PostMapping
    public ResponseEntity<SsmOperLog> add(SsmOperLog ssmOperLog) {
        return ResponseEntity.ok(this.ssmOperLogService.insert(ssmOperLog));
    }

    @PutMapping
    public ResponseEntity<SsmOperLog> edit(SsmOperLog ssmOperLog) {
        return ResponseEntity.ok(this.ssmOperLogService.update(ssmOperLog));
    }


    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.ssmOperLogService.deleteById(id));
    }

}


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
 * @since 2024-07-27 05:35:46
 */
@RestController
@RequestMapping("ssmUserRole")
public class SsmUserRoleController {

    @Resource
    private SsmUserRoleService ssmUserRoleService;


    @GetMapping
    public ResponseEntity<Page<SsmUserRole>> queryByPage(SsmUserRole ssmUserRole, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ssmUserRoleService.queryByPage(ssmUserRole, pageRequest));
    }


    @GetMapping("{id}")
    public ResponseEntity<SsmUserRole> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.ssmUserRoleService.queryById(id));
    }


    @PostMapping
    public ResponseEntity<SsmUserRole> add(SsmUserRole ssmUserRole) {
        return ResponseEntity.ok(this.ssmUserRoleService.insert(ssmUserRole));
    }


    @PutMapping
    public ResponseEntity<SsmUserRole> edit(SsmUserRole ssmUserRole) {
        return ResponseEntity.ok(this.ssmUserRoleService.update(ssmUserRole));
    }


    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.ssmUserRoleService.deleteById(id));
    }

}


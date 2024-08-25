package com.ssm.controller;

import com.ssm.entity.SsmRole;
import com.ssm.service.SsmRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Role Information Table(SsmRole)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
@RestController
@RequestMapping("ssmRole")
public class SsmRoleController {

    @Resource
    private SsmRoleService ssmRoleService;


    @GetMapping
    public ResponseEntity<Page<SsmRole>> queryByPage(SsmRole ssmRole, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ssmRoleService.queryByPage(ssmRole, pageRequest));
    }


    @GetMapping("{id}")
    public ResponseEntity<SsmRole> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.ssmRoleService.queryById(id));
    }


    @PostMapping
    public ResponseEntity<SsmRole> add(SsmRole ssmRole) {
        return ResponseEntity.ok(this.ssmRoleService.insert(ssmRole));
    }


    @PutMapping
    public ResponseEntity<SsmRole> edit(SsmRole ssmRole) {
        return ResponseEntity.ok(this.ssmRoleService.update(ssmRole));
    }


    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.ssmRoleService.deleteById(id));
    }

}


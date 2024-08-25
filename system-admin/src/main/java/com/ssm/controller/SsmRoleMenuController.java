package com.ssm.controller;

import com.ssm.entity.SsmRoleMenu;
import com.ssm.service.SsmRoleMenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Role and Menu Association Table(SsmRoleMenu)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
@RestController
@RequestMapping("ssmRoleMenu")
public class SsmRoleMenuController {

    @Resource
    private SsmRoleMenuService ssmRoleMenuService;


    @GetMapping
    public ResponseEntity<Page<SsmRoleMenu>> queryByPage(SsmRoleMenu ssmRoleMenu, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ssmRoleMenuService.queryByPage(ssmRoleMenu, pageRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<SsmRoleMenu> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.ssmRoleMenuService.queryById(id));
    }


    @PostMapping
    public ResponseEntity<SsmRoleMenu> add(SsmRoleMenu ssmRoleMenu) {
        return ResponseEntity.ok(this.ssmRoleMenuService.insert(ssmRoleMenu));
    }


    @PutMapping
    public ResponseEntity<SsmRoleMenu> edit(SsmRoleMenu ssmRoleMenu) {
        return ResponseEntity.ok(this.ssmRoleMenuService.update(ssmRoleMenu));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.ssmRoleMenuService.deleteById(id));
    }

}


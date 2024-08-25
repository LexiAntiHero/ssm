package com.ssm.controller;

import com.ssm.entity.SsmMenu;
import com.ssm.service.SsmMenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Menu Permissions Table(SsmMenu)表控制层
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
@RestController
@RequestMapping("ssmMenu")
public class SsmMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SsmMenuService ssmMenuService;


    @GetMapping
    public ResponseEntity<Page<SsmMenu>> queryByPage(SsmMenu ssmMenu, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ssmMenuService.queryByPage(ssmMenu, pageRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<SsmMenu> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.ssmMenuService.queryById(id));
    }


    @PostMapping
    public ResponseEntity<SsmMenu> add(SsmMenu ssmMenu) {
        return ResponseEntity.ok(this.ssmMenuService.insert(ssmMenu));
    }


    @PutMapping
    public ResponseEntity<SsmMenu> edit(SsmMenu ssmMenu) {
        return ResponseEntity.ok(this.ssmMenuService.update(ssmMenu));
    }


    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.ssmMenuService.deleteById(id));
    }

}


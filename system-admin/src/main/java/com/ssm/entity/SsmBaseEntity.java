package com.ssm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * Role and Menu Association Table(SsmRoleMenu)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SsmBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int page;
    private int size;
    private Sort sort;

}


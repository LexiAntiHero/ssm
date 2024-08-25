package com.ssm.service;

import com.ssm.entity.SsmOperLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Operation Log(SsmOperLog)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public interface SsmOperLogService {

    SsmOperLog queryById(Integer operId);


    Page<SsmOperLog> queryByPage(SsmOperLog ssmOperLog, PageRequest pageRequest);


    SsmOperLog insert(SsmOperLog ssmOperLog);

    SsmOperLog update(SsmOperLog ssmOperLog);

    boolean deleteById(Integer operId);

}

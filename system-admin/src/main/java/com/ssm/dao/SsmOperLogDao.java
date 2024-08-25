package com.ssm.dao;

import com.ssm.entity.SsmOperLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;


public interface SsmOperLogDao {


    SsmOperLog queryById(Integer operId);

    List<SsmOperLog> queryAllByLimit(SsmOperLog ssmOperLog, @Param("pageable") Pageable pageable);

    long count(SsmOperLog ssmOperLog);


    int insert(SsmOperLog ssmOperLog);


    int insertBatch(@Param("entities") List<SsmOperLog> entities);


    int insertOrUpdateBatch(@Param("entities") List<SsmOperLog> entities);


    int update(SsmOperLog ssmOperLog);


    int deleteById(Integer operId);

}


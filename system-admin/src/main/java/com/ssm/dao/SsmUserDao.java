package com.ssm.dao;

import com.ssm.entity.SsmUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * User Information Table(SsmUser)
 *
 * @author makejava
 * @since 2024-07-27 05:35:46
 */
public interface SsmUserDao {

    SsmUser queryByUserName(String userName);

    SsmUser queryById(Long userId);

    List<SsmUser> queryAllByLimit(@Param("ssmUser") SsmUser ssmUser, @Param("pageable") Pageable pageable);

    long count(SsmUser ssmUser);

    int insert(SsmUser ssmUser);

    int insertBatch(@Param("entities") List<SsmUser> entities);

    int insertOrUpdateBatch(@Param("entities") List<SsmUser> entities);

    int update(SsmUser ssmUser);

    int deleteById(Long userId);

    SsmUser getInfo(Long userId);

}


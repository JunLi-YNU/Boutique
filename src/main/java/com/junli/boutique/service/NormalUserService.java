package com.junli.boutique.service;

import com.junli.boutique.domain.NormalUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author junli
* @description 针对表【normal_user(用户信息表)】的数据库操作Service
* @createDate 2023-08-03 21:35:47
*/
public interface NormalUserService extends IService<NormalUser> {

    int insertSimpleNormalUser(NormalUser normalUser);

    int insertNormalUser(NormalUser normalUser);

    int deleteCurrentNormalUser(String normalUserNickName);

    int truncateNormalUserTable();

    int updateNormalUserNickName(int normalUserId, String normalUserNickName);

    NormalUser getNormalUserByNickName(String normalUserNickName);

    NormalUser getNormalUserById(int normalUserId);
    List<NormalUser> getAllNormalUser();
}

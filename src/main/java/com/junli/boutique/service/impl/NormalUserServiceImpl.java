package com.junli.boutique.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junli.boutique.domain.NormalUser;
import com.junli.boutique.service.NormalUserService;
import com.junli.boutique.mapper.NormalUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author junli
 * @description 针对表【normal_user(用户信息表)】的数据库操作Service实现
 * @createDate 2023-08-03 21:35:47
 */
@Service
public class NormalUserServiceImpl extends ServiceImpl<NormalUserMapper, NormalUser>
        implements NormalUserService {

    @Autowired
    NormalUserMapper normalUserMapper;


    @Override
    public int insertSimpleNormalUser(NormalUser normalUser) {
        return normalUserMapper.insertSimpleNormalUserByXML(normalUser);
    }

    @Override
    public int insertNormalUser(NormalUser normalUser) {
        return normalUserMapper.insertNormalUser(normalUser);
    }

    @Override
    public int deleteCurrentNormalUser(String normalUserNickName) {
        return normalUserMapper.deleteCurrentNormalUserByNickName(normalUserNickName);
    }

    @Override
    public int truncateNormalUserTable() {
        return normalUserMapper.truncateNormalUserTable();
    }

    @Override
    public int updateNormalUserNickName(int normalUserId, String normalUserNickName) {
        List<String> nickNameList = normalUserMapper.getNormalUserAllNickName();
        for (String s : nickNameList) {
            if (normalUserNickName.equals(s)) {
                log.debug("已经存在的用户昵称:" + s);
                return 0;
            }
        }
        return normalUserMapper.updateNormalUserNickNameById(normalUserId, normalUserNickName);
    }

    @Override
    public NormalUser getNormalUserByNickName(String normalUserNickName) {
        return normalUserMapper.getNormalUserByNickName(normalUserNickName);
    }

    @Override
    public NormalUser getNormalUserById(int normalUserId) {
        return normalUserMapper.getNormalUserById(normalUserId);
    }

    @Override
    public List<NormalUser> getAllNormalUser() {
        return normalUserMapper.getAllNormalUser();
    }
}





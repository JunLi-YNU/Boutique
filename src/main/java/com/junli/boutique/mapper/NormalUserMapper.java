package com.junli.boutique.mapper;

import com.junli.boutique.domain.NormalUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jdk.jfr.SettingDefinition;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author junli
 * @description 针对表【normal_user(用户信息表)】的数据库操作Mapper
 * @createDate 2023-08-03 21:35:47
 * @Entity com.junli.boutique.entity.NormalUser
 */
@Mapper
public interface NormalUserMapper extends BaseMapper<NormalUser> {

    int insertSimpleNormalUserByXML(@Param("simpleNormalUser") NormalUser simpleNormalUser);

    @Insert("insert into normal_user")
    int insertNormalUser(@Param("normalUser") NormalUser normalUser);

    @Delete("delete from normal_user where nick_name = #{normalUserNickName}")
    int deleteCurrentNormalUserByNickName(@Param("normalUserNickName") String normalUserNickName);

    @Update("update normal_user set nick_name = #{normalUserNickName} where user_id = #{normalUserId}")
    int updateNormalUserNickNameById(int normalUserId, String normalUserNickName);

    @Select("select nick_name from normal_user")
    List<String> getNormalUserAllNickName();

    @Select("select * from normal_user where nick_name = #{normalUserNickName}")
    NormalUser getNormalUserByNickName(@Param("normalUserNickName") String normalUserNickName);
    @Select("select * from normal_user where user_id=#{normalUserId}")
    NormalUser getNormalUserById(@Param("normalUserId") int normalUserId);
    @Delete("delete normal_user,normal_images from normal_user join boutique.normal_images ni on normal_user.user_id = ni.image_user_id")
    int deleteNormalUserInfoAndUserImages();

    @Delete("delete from normal_user")
    int truncateNormalUserTable();
    @Select("select * from normal_user")
    List<NormalUser> getAllNormalUser();
}





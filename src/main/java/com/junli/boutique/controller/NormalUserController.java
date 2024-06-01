package com.junli.boutique.controller;

import com.junli.boutique.controller.sql.handle.DatabaseReturnHandler;
import com.junli.boutique.domain.NormalUser;
import com.junli.boutique.service.NormalUserService;
import com.junli.boutique.util.RandomUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

/**
 * @Author: LiJun-YNU
 * @createTime: 2023年08月05日 13:03:25
 * @version: 0.0.1
 * @Description: 用户操作表
 */
@RestController
public class NormalUserController {

    @Autowired
    NormalUserService normalUserService;

    @Tag(name = "Insert normal String.", description = "上传一个普通的字符串")
    @PostMapping("/insertNormalString")
    public boolean insertNormalString(@PathParam("string") String normalString) {
        System.out.println(normalString);
        return normalString.isEmpty();
    }

    @Tag(name = "Get normal String.", description = "上传一个普通的字符串")
    @PostMapping("/getNormalString")
    public String getNormalString(@RequestParam String normalStringName) {
        System.out.println(normalStringName);
        return normalStringName;
    }

    @Tag(name = "Insert a normal user:", description = "传入一个用户实体，新建一个用户。")
    @PutMapping("/insertNormalUser")
    public boolean insertNormalUser(@RequestBody NormalUser normalUser) {
        return DatabaseReturnHandler.getDataBaseReturnLine(normalUserService.insertNormalUser(normalUser));
    }

    @Tag(name = "Post a normal user:", description = "传入一个用户实体，新建一个用户。")
    @PostMapping("/postNormalUser")
    public boolean postNormalUser(@RequestBody NormalUser normalUser) {
        System.out.println("postNormalUser------------------->" + normalUser.toString());
        return true;
    }

    @Tag(name = "Auto insert some normal users:", description = "传入一个数值，自动新建对应数量的普通用户。")
    @PutMapping("/autoInsertNormalUser")
    public String autoInsertNormalUser(@RequestParam int autoNumber) {
        StringBuilder returnStr = new StringBuilder();
        NormalUser normalUser = new NormalUser();
        for (int i = 0; i < autoNumber; i++) {
            normalUser.setUserName(RandomUtil.generatorUpperCase(1) + RandomUtil.generatorLowCase(5));
            normalUser.setNickName(RandomUtil.generatorUpperCase(1) + RandomUtil.generatorLowCase(6));
            normalUser.setRemark("自动生成");
            if (DatabaseReturnHandler.getDataBaseReturnLine(normalUserService.insertSimpleNormalUser(normalUser))) {
                returnStr.append("第").append(i).append("条数据插入成功").append(System.lineSeparator());
            } else {
                returnStr.append("第").append(i).append("条数据插入失败").append(System.lineSeparator());
            }
        }
        return returnStr.toString();
    }

    @Tag(name = "Delete a normal user:", description = "传入一个用户唯一的昵称，删除当前用户。")
    @DeleteMapping("/deleteNormalUser")
    public boolean deleteNormalUser(@RequestParam String normalUserNickName) {
        return DatabaseReturnHandler.getDataBaseReturnLine(normalUserService.deleteCurrentNormalUser(normalUserNickName));
    }

    @Tag(name = "update normal user nick name:", description = "传入用户ID，更新用户昵称。")
    @PatchMapping("/updateNormalUserNickName")
    public boolean updateNormalUserNickName(@RequestParam String normalUserNickName, @RequestParam int normalUserId) {
        return DatabaseReturnHandler.getDataBaseReturnLine(normalUserService.updateNormalUserNickName(normalUserId, normalUserNickName));
    }

    @Tag(name = "get a normal user", description = "传入用户昵称，获取用户信息。")
    @GetMapping("/getNormalUserByNickName")
    public NormalUser getNormalUserByNickName(@RequestParam String normalUserNickName) {
        return DatabaseReturnHandler.getDataBaseReturnDomain(normalUserService.getNormalUserByNickName(normalUserNickName));
    }

    @Tag(name = "get a normal user:", description = "传入用户ID，获取用户信息。")
    @GetMapping("/getNormalUserById")
    public NormalUser getNormalUserById(@RequestParam int normalUserId) {
        return normalUserService.getNormalUserById(normalUserId);
    }

    @Tag(name = "get all normal user:", description = "获取所有用户")
    @GetMapping("/getAllNormalUser")
    public List<NormalUser> getAllNormalUser() {
        return normalUserService.getAllNormalUser();
    }

    @Tag(name = "Truncate normal user table", description = "清空表")
    @DeleteMapping("/deleteNormalUserTable")
    public boolean truncateNormalUserTable() {
        return DatabaseReturnHandler.getDataBaseReturnLine(normalUserService.truncateNormalUserTable());
    }

    @Tag(name = "throw exception", description = "抛出一个异常使用ExceptionHandler处理")
    @DeleteMapping("/throwExceptionUseExceptionHandler")
    public void throwExceptionUseExceptionHandler() {
        try {
            saveToFile();
        } catch (FileNotFoundException e) {
            System.out.println("该文件不存在:" + e.getMessage());
        }
        showException();
    }

    private static void showException() {
        var arr = new int[5];
        System.out.println(arr[6]);
    }

    private static void saveToFile() throws FileNotFoundException {
        var file = new FileInputStream("demo.txt");
    }

    @ExceptionHandler({ArrayIndexOutOfBoundsException.class, FileNotFoundException.class, IllegalArgumentException.class})
    public void handlerArrayException(Exception e) {
        System.out.println("统一对异常进行捕获处理：" + e);
    }
}

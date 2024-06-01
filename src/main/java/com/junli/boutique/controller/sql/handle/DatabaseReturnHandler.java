package com.junli.boutique.controller.sql.handle;

/**
 * @Author: LiJun-YNU
 * @createTime: 2023年08月05日 13:11:38
 * @version: 0.0.1
 * @Description: 数据库返回信息处理
 */
public class DatabaseReturnHandler {

    public static boolean getDataBaseReturnLine(int sqlReturn) {
        return sqlReturn != 0;
    }

    public static <T> T getDataBaseReturnDomain(T t) {
        if(t == null){
            return null;
        }else {
            return t;
        }
    }
}

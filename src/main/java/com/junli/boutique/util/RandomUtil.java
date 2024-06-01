package com.junli.boutique.util;

import java.util.Random;

/**
 * @Author: LiJun-YNU
 * @createTime: 2023年08月05日 18:40:18
 * @version: 0.0.1
 * @Description: 随机生成器：数字，字母
 */
public class RandomUtil {
    private static final Random random = new Random();
    private static final int LETTER_QUANTITY = 26;
    private static  final  int NUMBER_QUANTITY = 10;

    public static String generatorUpperCase(int quantity) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            stringBuilder.append((char) ((random.nextInt(LETTER_QUANTITY) + 65)));
        }
        return stringBuilder.toString();
    }

    public static String generatorLowCase(int quantity) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            stringBuilder.append((char) ((random.nextInt(LETTER_QUANTITY) + 97)));
        }
        return stringBuilder.toString();
    }

    public static String generatorNumberStr(int quantity) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < quantity; i++) {
            number.append(random.nextInt(NUMBER_QUANTITY));
        }
        return number.toString();
    }

}

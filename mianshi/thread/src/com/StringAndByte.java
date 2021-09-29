package com;

import java.io.UnsupportedEncodingException;

/**
 * @date 2021/8/8
 * @time 20:13
 */
public class StringAndByte {
    public static void main(String[] args) {
        String str = "123";
        byte[] bytes = str.getBytes();
        Byte b3 = new Byte(str);
        System.out.println(b3);
        for (Byte b : bytes){
            System.out.println(b);
        }
        System.out.println("======");
        byte[] bytes1 = {'h','1'};
        String str2 = null;
        try {
            str2 = new String(bytes1,"GBK");
            System.out.println(str2);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

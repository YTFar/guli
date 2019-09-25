package com.guli.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

    /**
     * 密码加密
     *
     * @param passWord 密码
     * @return 最终密码
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public String encryptionMD5(String passWord) {
        System.out.println("未加密的密码:"+passWord);
        //确定计算方法
        MessageDigest md5 = null;
        String password = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            password = base64en.encode(md5.digest(passWord.getBytes("utf-8")));
            System.out.println("第0次加密的密码:"+password);
            for (int i = 0 ; i<passWord.length();i++){  //按照传入的密码长度循环次数
                //每一次循环将上一次密码的代码再次加密,再在后面加上上次密码的长度组成新的密码
                password = base64en.encode(md5.digest(password.getBytes("utf-8")))+password.length();
                System.out.println("第"+(i+1)+"次加密的密码:"+password);
            }
            /*String pwd = base64en.encode(md5.digest(passWord.getBytes("utf-8")));   //加密后的密码
            System.out.println("第一次加密后的密码:"+pwd);
            //在MD5基础上再次加密
            //用户名的长度 + newstr + MD5后的用户名的前三位 = 最终密码 phoneNum.substring(0, 3);
            password = passWord.length() + pwd;
            System.out.println("第二次加密后的密码:"+password);
            password = base64en.encode(md5.digest(password.getBytes("utf-8")));   //再次加密后的密码
            System.out.println("第三次加密后的密码:"+password);*/
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return password;
    }

}

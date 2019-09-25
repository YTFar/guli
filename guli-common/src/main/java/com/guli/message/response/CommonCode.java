package com.guli.message.response;

import lombok.ToString;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */

@ToString
public enum CommonCode implements ResultCode{

    FIND_ALL_USER_CARD_OUT_DATE_SUCCESS(true,3007,"查询全部已过期优惠卷信息"),

    FIND_ALL_USER_CARD_USED(true,3006,"查询全部已使用优惠卷信息"),

    FIND_ALL_USER_CARD_USE_ABLE_SUCCESS(true,3005,"查询全部未使用优惠卷信息"),

    FIND_ALL_USER_DISCOUNT_SUCCESS(true,3004,"查询全部优惠卷信息"),

    FIND_ALL_REFUND_ORDER(true,3003,""),

    FIND_ALL_ORDER_SUCCESS(true,3002,""),

    VERIFY_CODE_ERROR(false,3001,"验证码有误!"),

    //  根据用户id查询个人用户信息
    FIND_USER_BY_ID_SUCCESS(true,2009,"查询成功!"),
    FIND_USER_BY_ID_ERROR(false,2010,"查询失败!"),

    //登陆  2000起步
    LOGIN_SUCCESS(true,2001,"登陆成功!"),
    LOGIN_FAIL(false,2002,"登陆失败!"),
    //  注册
    REGISTER_FAIL(true,2003,"注册成功!"),
    REGISTER_SUCCESS(false,2004,"注册失败!"),
    //  用户名是否存在
    USERNAME_EXIST(true,2005,"用户名已存在!"),
    USERNAME_NOT_EXIST(false,2006,""),

    //修改用户个人信息
    UPDATE_USERINFO_SUCCESS(true,2007,"修改成功!"),
    UPDATE_USERINFO_ERROR(false,2008,"修改失败!"),

    //课程  3000起步

    INVALID_PARAM(false,10003,"非法参数！"),
    SUCCESS(true,10000,"操作成功！"),
    DATASHOWSUCCESS(true,0,"数据回显成功！"),
    FAIL(false,11111,"操作失败！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！");
//    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}

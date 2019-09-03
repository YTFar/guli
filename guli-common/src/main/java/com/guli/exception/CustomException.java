package com.guli.exception;

import com.guli.message.response.ResultCode;

/**
 * 自定义异常类型
 * 运行时异常,抛出时对代码没有侵入性
 */
public class CustomException extends RuntimeException{

    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
    //异常信息为错误代码+异常信息
    super("错误代码："+resultCode.code()+"错误信息："+resultCode.message());
    this.resultCode = resultCode;
    }

    public ResultCode getResultCode()
    {
        return this.resultCode;
    }

}

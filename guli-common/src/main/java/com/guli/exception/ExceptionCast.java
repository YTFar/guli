package com.guli.exception;


import com.guli.message.response.ResultCode;

public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }

}

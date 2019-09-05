package com.guli.exception;

import com.google.common.collect.ImmutableMap;
import com.guli.message.response.CommonCode;
import com.guli.message.response.ResponseResult;
import com.guli.message.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常捕获类
 */
@ControllerAdvice//控制器增强
public class ExceptionCatch {

    //日志
    private  static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    //定义map,配置异常类型所对应的错误代码
    //使用EXCEPTIONS存放异常类型和错误代码的映射，ImmutableMap的特点的一旦创建不可改变，并且线程安全
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTION;

    //使用builder来构建一个异常类型和错误代码的异常
    protected static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();

    @ExceptionHandler(CustomException.class)//捕获哪一类异常
    @ResponseBody
    public ResponseResult customException(CustomException customException){
        //记录日志
        LOGGER.error("catch exception:{}"+customException.getMessage());
        ResultCode resultCode = customException.getResultCode();
        return new ResponseResult(resultCode);
    }

    @ExceptionHandler(Exception.class)//捕获哪一类异常
    @ResponseBody
    public ResponseResult exception(Exception exception){
        //记录日志
        LOGGER.error("catch exception:{}"+exception.getMessage());
        if(EXCEPTION == null){
            builder.build();//EXCEPTION构建成功
        }
        //从EXCEPTION中找异常类型所对应的错误代码,如果找到了将错误代码响应个客户,如果找不到给用户响应99999异常
        ResultCode resultCode = EXCEPTION.get(exception.getClass());
        if(resultCode != null){
            return new ResponseResult(resultCode);
        }else{
            //返回99999异常
            return new ResponseResult(CommonCode.INVALID_PARAM);
        }
    }

    static{
        //在这里加入一些基础的异常类型判断
        builder.put(HttpMessageNotReadableException.class,CommonCode.INVALID_PARAM);
    }

}

package com.guli.response;

import com.guli.message.response.ResponseResult;
import com.guli.message.response.ResultCode;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 */
@Data
public class ObjectResult extends ResponseResult {

    Object object;

    //基础对应的接口
    //1 信息  2  数据
    public ObjectResult(ResultCode resultCode, Object object) {
        super(resultCode);
        this.object = object;
    }
}

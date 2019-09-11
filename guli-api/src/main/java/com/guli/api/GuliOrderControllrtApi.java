package com.guli.api;

import com.guli.pojo.GuliOrder;
import com.guli.pojo.OrderVo.GuliOrderAndUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @author 齐天大圣
 * @date 2019/9/7 9:18
 * @package com.guli.api
 */
@Api(value="订单管理接口",description = "订单管理接口，提供课程分类的增、删、改、查")
public interface GuliOrderControllrtApi {

    @ApiOperation("按教师id所有订单")
    public List<GuliOrderAndUser> findAllOrdel(int userId);

}

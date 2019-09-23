package com.guli.api;

import com.guli.pojo.GuliOrder;
import com.guli.pojo.response.AllTypePage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.guli.pojo.OrderVo.OrderAndUser;

/**
 * @author 齐天大圣
 * @date 2019/9/7 9:18
 * @package com.guli.api
 */
@Api(value="订单管理接口",description = "订单管理接口，提供课程分类的增、删、改、查")
public interface GuliOrderControllrtApi {

    @ApiOperation("按教师id分页查询所有订单")
    public AllTypePage<OrderAndUser> findAllPageOrdel(int pageNo,int pageSize,int userId,String orderNumber,String userName);

    @ApiOperation("按订单id修改指定信息")
    public int updateOrder(GuliOrder guliOrder);
}

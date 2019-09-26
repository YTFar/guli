package com.guli.api;

import com.guli.pojo.GuliOrder;
import com.guli.pojo.ordervo.OrderAndUser;
import com.guli.pojo.response.AllTypePage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 齐天大圣
 * @date 2019/9/7 9:18
 * @package com.guli.api
 */
@Api(value="订单管理接口",description = "订单管理接口，提供课程分类的增、删、改、查")
public interface GuliOrderControllrtApi {

    @ApiOperation("按教师id分页查询所有订单")
    public AllTypePage<OrderAndUser> findAllPageOrdel(int pageNo, int pageSize, Long userId, String orderNumber, String userName, int orderStatus);

    @ApiOperation("按订单id修改指定信息")
    public int updateOrder(GuliOrder guliOrder);

    @ApiOperation("按订单id查询订单信息")
    public OrderAndUser findOneOrder(int orderId);
}

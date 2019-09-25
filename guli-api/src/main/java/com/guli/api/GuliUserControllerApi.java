package com.guli.api;

import com.guli.pojo.GuliUser;
import com.guli.pojo.ordervo.GuliDiscountVo;
import com.guli.pojo.ordervo.GuliOrderAndCourseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @author 齐天大圣
 * @date 2019/9/3 14:41
 * @package com.guli.api
 */
@Api(value="用户管理接口",description = "用户管理接口，提供用户的增、删、改、查")
public interface GuliUserControllerApi {

    @ApiOperation("用户登陆")
    public GuliUser login(String userName, String pwd);

    @ApiOperation("用户注册")
    public int register(GuliUser guliUser);

    @ApiOperation("检查用户是否存在")
    public int checkName(String userName);

    @ApiOperation("修改个人用户信息")
    public int updateUserInfo(GuliUser guliUser);

    @ApiOperation("根据用户id查询一条用户信息")
    public GuliUser findUserById(int id);

    @ApiOperation("根据用户id查询该用户所有订单信息")
    public List<GuliOrderAndCourseVo> findAllOrder(int userId);

    @ApiOperation("根据用户id查询该用户退款管理信息")
    public List<GuliOrderAndCourseVo> findAllRefundOrder(int userId);

    @ApiOperation("根据课程名称进行模糊查询")
    public List<GuliOrderAndCourseVo> searchVague(int userId, String searchName);

    @ApiOperation("根据id查询该用户所有优惠卷信息")
    public List<GuliDiscountVo> findAllUserDiscount(int userId);

    @ApiOperation("根据用户id查询该用户所有未使用的优惠卷信息")
    public List<GuliDiscountVo> findAllUserCardUseAble(int userId);

    @ApiOperation("根据用户id查询该用户所有已使用的优惠卷信息")
    public List<GuliDiscountVo> findAllUserCardUsed(int userId);

    @ApiOperation("根据用户id查询该用户所有已过期的优惠卷信息")
    public List<GuliDiscountVo> findAllUserCardOutDate(int userId);

}

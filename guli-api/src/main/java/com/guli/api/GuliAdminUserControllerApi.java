package com.guli.api;

import com.guli.pojo.GuliUser;
import com.guli.pojo.response.AllTypePage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 齐天大圣
 * @date 2019/9/3 14:41
 * @package com.guli.api
 */
@Api(value="管理员与教师用户管理接口",description = "管理员与教师用户管理接口，提供管理员与教师用户的增、删、改、查")
public interface GuliAdminUserControllerApi {

//    @ApiOperation("用户登陆")
//    public GuliUser login(String userName, String pwd);

    @ApiOperation("按id查询用户信息")
    public GuliUser findUserIdOneUser(int userId);

    @ApiOperation("按id查询本老师下所有学员")
    public AllTypePage<GuliUser> findMemberPage(int pageNo,int pageSize,int userId,String userName);

    @ApiOperation("按id修改用户信息")
    public int updateUser(GuliUser guliUser);



}

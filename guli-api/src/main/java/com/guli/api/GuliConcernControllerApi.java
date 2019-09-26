package com.guli.api;

import com.guli.pojo.concernvo.ConcernAndUser;
import com.guli.pojo.response.AllTypePage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 齐天大圣
 * @date 2019/9/24 17:24
 * @package com.guli.api
 */
@Api(value="粉丝与关注管理接口",description = "粉丝与关注管理接口，提供粉丝与关注的增、删、改、查")
public interface GuliConcernControllerApi {

    @ApiOperation("按添加分页查询粉丝信息")
    public AllTypePage<ConcernAndUser> findPageConcern(int pageNo, int pageSize, int userId, String userName);

    @ApiOperation("按添加分页查询关注信息")
    public AllTypePage<ConcernAndUser> findPageTowConcern(int pageNo, int pageSize, int userId, String userName);

    @ApiOperation("按粉丝与关注id修改信息")
    public int deleteConcern(int concernId);
}

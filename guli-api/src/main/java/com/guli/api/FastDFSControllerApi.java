package com.guli.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 齐天大圣
 * @date 2019/9/5 14:25
 * @package com.guli.api
 */
@Api(value="图片管理接口",description = "图片管理接口，提供图片的增、删、改、查")
public interface FastDFSControllerApi {

    @ApiOperation("图片上传")
    public String uploadPictures(MultipartFile multipartFile);
}

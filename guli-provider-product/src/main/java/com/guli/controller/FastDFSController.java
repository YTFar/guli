package com.guli.controller;

import com.guli.service.impl.FastDFSService;
import com.guli.api.FastDFSControllerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 齐天大圣
 * @date 2019/9/5 14:26
 * @package com.guli.controller
 */
@RestController
@RequestMapping("/FastDFS")
public class FastDFSController implements FastDFSControllerApi {

    @Autowired
    FastDFSService fastDFSService;

    /**
     * 上传图片
     * @param multipartFile 上传图片
     * @return 保存路径
     */
    @Override
    @PostMapping(value = "uploadPictures")
    public String uploadPictures(@RequestParam("multipartFile") MultipartFile multipartFile) {
        return fastDFSService.uploadPictures(multipartFile);
    }
}

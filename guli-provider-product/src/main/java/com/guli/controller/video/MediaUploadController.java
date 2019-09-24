package com.guli.controller.video;

import com.guli.api.media.MediaUploadControllerApi;
import com.guli.media.response.CheckChunkResult;
import com.guli.message.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@RequestMapping("/media/upload")
public class MediaUploadController implements MediaUploadControllerApi {

    @Autowired
    MediaUploadController mediaFileService;

    //文件上传前的注册
    @Override
    @PostMapping("/register")
    public ResponseResult register(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {
        return mediaFileService.register(fileMd5,fileName,fileSize,mimetype,fileExt);
    }

    @Override
    @PostMapping("/checkchunk")
    public CheckChunkResult checkchunk(String fileMd5, Integer chunk, Integer chunkSize) {
        return mediaFileService.checkchunk(fileMd5,chunk,chunkSize);
    }

    @Override
    @PostMapping("/uploadchunk")
    public ResponseResult uploadchunk(MultipartFile file, String fileMd5, Integer chunk) {
        return mediaFileService.uploadchunk(file,fileMd5,chunk);
    }

    @Override
    @PostMapping("/mergechunks")
    public ResponseResult mergechunks(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {
        return mediaFileService.mergechunks(fileMd5,fileName,fileSize, mimetype,fileExt);
    }
}

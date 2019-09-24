package com.guli.controller;

import com.guli.api.media.MediaUploadControllerApi;
import com.guli.media.response.CheckChunkResult;
import com.guli.message.response.ResponseResult;
import com.guli.service.MediaUploadService;
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
    MediaUploadService mediaFileService;

    //文件上传前的注册
    @Override
    @PostMapping("/register")
    public ResponseResult register(String fileMd5, String fileName, Long fileSize, String mimetype, String fileExt) {

        System.out.println(fileMd5);
        System.out.println(fileName);
        System.out.println(fileSize);
        System.out.println(mimetype);
        System.out.println(fileExt);
        System.out.println("1232122211111111111111111111111111111111111111111111111111111");
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

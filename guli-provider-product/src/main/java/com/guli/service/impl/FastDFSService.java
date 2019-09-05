package com.guli.service.impl;

import com.guli.exception.ExceptionCast;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 齐天大圣
 * @date 2019/9/5 14:28
 * @package com.guli
 */
@Service
public class FastDFSService {

    @Value("${xuecheng.fastdfs.tracker_servers}")
    String tracker_servers;
    @Value("${xuecheng.fastdfs.connect_timeout_in_seconds}")
    int connect_timeout_in_seconds;
    @Value("${xuecheng.fastdfs.network_timeout_in_seconds}")
    int network_timeout_in_seconds;
    @Value("${xuecheng.fastdfs.charset}")
    String charset;

    /**
     * 文件上传
     * @param multipartFile 上传图片
     * @return 保存路径
     */
    public String uploadPictures(MultipartFile multipartFile) {
        if(multipartFile == null){
            System.out.println("照片为空!");
        }
        //初始化fastDFS的环境
        initFdfsConfig();
        TrackerClient trackerClient = new TrackerClient();
        try {
            TrackerServer trackerServer = trackerClient.getConnection();
            //得到storeStorage服务器
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);

            //创建storageClient来上传文件
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storeStorage);
            //上传文件
            //得到文件字节
            byte[] bytes = multipartFile.getBytes();
            //得到文件原始名称
            String originalFilename = multipartFile.getOriginalFilename();
            //得到文件扩展名
            String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //返回图片id(储存路径)
            String fileId = storageClient1.upload_file1(bytes, ext, null);
            return fileId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //初始化fastDFS环境
    private void initFdfsConfig(){
        try {
            System.out.println(tracker_servers);
            System.out.println(charset);
            System.out.println(network_timeout_in_seconds);
            System.out.println(connect_timeout_in_seconds);
            ClientGlobal.initByTrackers(tracker_servers);
            ClientGlobal.setG_charset(charset);
            ClientGlobal.setG_network_timeout(network_timeout_in_seconds);
            ClientGlobal.setG_connect_timeout(connect_timeout_in_seconds);
        } catch (Exception e) {
            e.printStackTrace();
            //抛出异常
//            ExceptionCast.cast(FileSystemCode.FS_INITFDFSERROR);
        }
    }
}

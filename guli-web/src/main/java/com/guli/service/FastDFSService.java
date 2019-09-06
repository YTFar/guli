package com.guli.service;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 齐天大圣
 * @date 2019/9/5 20:47
 * @package com.guli.service
 */
@FeignClient(value = "GULI-PROVIDER-PRODUCT",configuration = FastDFSService.MultipartSupportConfig.class)
public interface FastDFSService {


    @PostMapping(value = "/FastDFS/uploadPictures",
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadPictures(MultipartFile multipartFile);

    /**
     * 引用配置类MultipartSupportConfig.并且实例化
     */
    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }

//    @Configuration
//    class MultipartSupportConfig {
//        @Bean
//        @Primary
//        @Scope("prototype")
//        public Encoder feignFormEncoder() {
//            return new SpringFormEncoder();
//        }
//    }

}

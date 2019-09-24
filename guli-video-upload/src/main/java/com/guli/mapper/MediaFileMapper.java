package com.guli.mapper;

import com.guli.media.MediaFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MediaFileMapper extends MongoRepository<MediaFile,String> {
    

}

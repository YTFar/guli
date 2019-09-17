package com.guli.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CatalogueVO {

    private Long catalogueId;

    private Long courseId;

    private String catalogueName;

    private Long subdirectoryId;

    private String subdirectoryName;

    /**
     * 0 压缩包 1视频
     */
    private Integer subdirectoryType;

    private LocalDateTime subdirectoryTime;

    private String subdirectoryPath;

}

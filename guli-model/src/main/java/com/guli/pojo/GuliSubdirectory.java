package com.guli.pojo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.time.LocalDateTime;
    import java.io.Serializable;

/**
* <p>
    * ??Ŀ¼?
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliSubdirectory extends Model<GuliSubdirectory> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "subdirectory_id", type = IdType.AUTO)
    private Long subdirectoryId;

    private Long catalogueId;

    private String subdirectoryName;

            /**
            * 0 压缩包 1视频
            */
    private Integer subdirectoryType;

    private LocalDateTime subdirectoryTime;

    private String subdirectoryPath;

        public Long getSubdirectoryId() {
        return subdirectoryId;
        }

            public void setSubdirectoryId(Long subdirectoryId) {
        this.subdirectoryId = subdirectoryId;
        }
        public Long getCatalogueId() {
        return catalogueId;
        }

            public void setCatalogueId(Long catalogueId) {
        this.catalogueId = catalogueId;
        }
        public String getSubdirectoryName() {
        return subdirectoryName;
        }

            public void setSubdirectoryName(String subdirectoryName) {
        this.subdirectoryName = subdirectoryName;
        }
        public Integer getSubdirectoryType() {
        return subdirectoryType;
        }

            public void setSubdirectoryType(Integer subdirectoryType) {
        this.subdirectoryType = subdirectoryType;
        }
        public LocalDateTime getSubdirectoryTime() {
        return subdirectoryTime;
        }

            public void setSubdirectoryTime(LocalDateTime subdirectoryTime) {
        this.subdirectoryTime = subdirectoryTime;
        }
        public String getSubdirectoryPath() {
        return subdirectoryPath;
        }

            public void setSubdirectoryPath(String subdirectoryPath) {
        this.subdirectoryPath = subdirectoryPath;
        }

    @Override
    protected Serializable pkVal() {
        return this.subdirectoryId;
    }

    @Override
    public String toString() {
    return "GuliSubdirectory{" +
            "subdirectoryId=" + subdirectoryId +
            ", catalogueId=" + catalogueId +
            ", subdirectoryName=" + subdirectoryName +
            ", subdirectoryType=" + subdirectoryType +
            ", subdirectoryTime=" + subdirectoryTime +
            ", subdirectoryPath=" + subdirectoryPath +
    "}";
    }
}

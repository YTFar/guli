package com.guli.pojo;

    import com.baomidou.mybatisplus.annotation.IdType;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import com.baomidou.mybatisplus.annotation.TableId;
    import java.io.Serializable;

/**
* <p>
    * ?γ?Ŀ¼?
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliCatalogue extends Model<GuliCatalogue> {

    private static final long serialVersionUID = 1L;

            @TableId(value = "catalogue_id", type = IdType.AUTO)
    private Long catalogueId;

    private Long courseId;

    private Long catalogueName;

        public Long getCatalogueId() {
        return catalogueId;
        }

            public void setCatalogueId(Long catalogueId) {
        this.catalogueId = catalogueId;
        }
        public Long getCourseId() {
        return courseId;
        }

            public void setCourseId(Long courseId) {
        this.courseId = courseId;
        }
        public Long getCatalogueName() {
        return catalogueName;
        }

            public void setCatalogueName(Long catalogueName) {
        this.catalogueName = catalogueName;
        }

    @Override
    protected Serializable pkVal() {
        return this.catalogueId;
    }

    @Override
    public String toString() {
    return "GuliCatalogue{" +
            "catalogueId=" + catalogueId +
            ", courseId=" + courseId +
            ", catalogueName=" + catalogueName +
    "}";
    }
}

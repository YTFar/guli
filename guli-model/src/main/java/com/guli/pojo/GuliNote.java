package com.guli.pojo;

    import java.math.BigDecimal;
    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import java.io.Serializable;

/**
* <p>
    * ?ʼǱ
    * </p>
*
* @author slz
* @since 2019-09-03
*/
    public class GuliNote extends Model<GuliNote> {

    private static final long serialVersionUID = 1L;

    private Long noteId;

    private Long userId;

    private Long catalogueId;

    private String noteContent;

    private BigDecimal noteCreateTime;

    private Long noteLikeNumber;

        public Long getNoteId() {
        return noteId;
        }

            public void setNoteId(Long noteId) {
        this.noteId = noteId;
        }
        public Long getUserId() {
        return userId;
        }

            public void setUserId(Long userId) {
        this.userId = userId;
        }
        public Long getCatalogueId() {
        return catalogueId;
        }

            public void setCatalogueId(Long catalogueId) {
        this.catalogueId = catalogueId;
        }
        public String getNoteContent() {
        return noteContent;
        }

            public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
        }
        public BigDecimal getNoteCreateTime() {
        return noteCreateTime;
        }

            public void setNoteCreateTime(BigDecimal noteCreateTime) {
        this.noteCreateTime = noteCreateTime;
        }
        public Long getNoteLikeNumber() {
        return noteLikeNumber;
        }

            public void setNoteLikeNumber(Long noteLikeNumber) {
        this.noteLikeNumber = noteLikeNumber;
        }

    @Override
    protected Serializable pkVal() {
        return this.noteId;
    }

    @Override
    public String toString() {
    return "GuliNote{" +
            "noteId=" + noteId +
            ", userId=" + userId +
            ", catalogueId=" + catalogueId +
            ", noteContent=" + noteContent +
            ", noteCreateTime=" + noteCreateTime +
            ", noteLikeNumber=" + noteLikeNumber +
    "}";
    }
}

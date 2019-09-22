package com.guli.pojo.cataloguevo;

import com.guli.pojo.GuliCatalogue;
import lombok.Data;
import lombok.ToString;

/**
 * @author 齐天大圣
 * @date 2019/9/20 20:44
 * @package com.guli.pojo.cataloguevo
 */
@Data
@ToString
public class CatalogueAndCourse extends GuliCatalogue {
    private String courseName;//课程名称
}

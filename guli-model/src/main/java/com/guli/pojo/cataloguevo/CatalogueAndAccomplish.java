package com.guli.pojo.cataloguevo;

import com.guli.pojo.GuliCatalogue;

/**
 * @author 齐天大圣
 * @date 2019/9/19 12:03
 * @package com.guli.pojo.cataloguevo
 * 此类为CatalogueAndAccomplishAndUser三个类合成
 */
public class CatalogueAndAccomplish extends GuliCatalogue {
    private Long userId;//用户id
    private String userName;//用户姓名
    private int accomplishLearningTrogress;
    private String accomplishLearningTrogressStr;//课程进度
    private String publisher;//发布人
    private int publisherId;//发布人id

}

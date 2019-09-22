package com.guli.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.pojo.GuliCatalogue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.pojo.cataloguevo.CatalogueAndAccomplish;
import com.guli.pojo.cataloguevo.CatalogueAndCourse;
import com.guli.pojo.response.AllTypePage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * ?γ?Ŀ¼? Mapper 接口
 * </p>
 *
 * @author slz
 * @since 2019-09-03
 */
public interface GuliCatalogueMapper extends BaseMapper<GuliCatalogue> {

    @Select({"<script>",
            "SELECT a.*,b.course_name",
            " FROM guli_catalogue a",
            "INNER JOIN guli_course b ON a.course_id = b.course_id",
            "<trim prefix=\"where\" prefixOverrides=\"and||or\">",
            "a.course_id = #{courseId}",
            "<if test=\"catalogueName != null and catalogueName != ''\">",
            "AND a.catalogue_name like concat('%',#{catalogueName},'%')",
            "</if>",
            "</trim>",
            "ORDER BY catalogue_id DESC",
            "</script>"})
    List<CatalogueAndCourse> findAllPageCatalogue(Page<CatalogueAndCourse> page, @Param("courseId") Long courseId,@Param("catalogueName") String catalogueName);

//    @Select({"<script>",
//            "SELECT a.*,b.user_id,b.user_name,b.accomplish_learning_trogress,e.user_id as publisherId,e.user_name as publisher",
//            "FROM guli_catalogue a",
//            "INNER JOIN guli_accomplish b ON a.catalogue_id = b.catalogue_id",
//            "INNER JOIN guli_course c ON a.course_id = c.course_id",
//            "INNER JOIN guli_item d ON d.item_id = c.item_id",
//            "INNER JOIN guli_user e ON e.user_id = d.user_id",
//            "<trim prefix=\"where\" prefixOverrides=\"and||or\">",
//            "<if test=\"userId != null and userId != -1\">",
//            "AND e.user_id = #{userId}",
//            "</if>",
//            "<if test=\"courseId != null and courseId != 0\">",
//            "AND a.course_id = #{courseId}",
//            "</if>",
//            "<if test=\"catalogueName != null and catalogueName != ''\">",
//            "AND a.catalogue_name like concat('%',#{catalogueName},'%')",
//            "</if>",
//            "</trim>",
//            "</script>"})
//    List<CatalogueAndAccomplish> findAllPageCatalogue(Page<CatalogueAndAccomplish> page, @Param("userId") Long userId, @Param("courseId") Long courseId, @Param("catalogueName") String catalogueName);
}

package com.guli.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGen {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Velocity
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("slz");
        gc.setOutputDir("C:\\Users\\阿呆\\IdeaProjects\\guli\\guli-provider-user\\src\\main\\java");
        gc.setFileOverride(true);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setServiceName("%sService");  // 设置生成的service接口的名字的首字母是否为I
//        gc.setSwagger2(true);//实体属性注释

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("bushini");
        dsc.setUrl("jdbc:mysql://localhost:3306/guli?useUnicode=true&serverTimezone=UTC&characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 数据源配置
        StrategyConfig strategy = new StrategyConfig();
//        StrategyConfig stConfig = new StrategyConfig();
//        stConfig.setDbColumnUnderline(true);  // 指定表名 字段名是否使用下划线
//        stConfig.setNaming(NamingStrategy.underline_to_camel); // 数据库表映射到实体的命名策略
        //strategy.setTablePrefix(new String[] { "buy_" });// // 此处可以修改为您的表前缀׺
//        strategy.setNaming(NamingStrategy.no_change);// 表名生成策略 默认是全部表
//        strategy.setInclude(new String[] { "guli_accomplish","guli_activitie","guli_catalogue","guli_classify","guli_complete","guli_concern","guli_course","guli_discount","guli_evaluate","guli_info","guli_introduce","guli_item","guli_note","guli_order","guli_power","guli_receive","guli_subdirectory","guli_topic"}); // 表名生成策略 指定表
        strategy.setInclude(new String[] { "guli_user"}); // 表名生成策略 指定表

        //3. 策略配置globalConfiguration中
//        StrategyConfig stConfig = new StrategyConfig();
        strategy.setCapitalMode(true) //全局大写命名
//                .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setCapitalMode(true); //全局大写命名
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.guli")
        // pc.setModuleName("test");
        .setMapper("mapper")
                .setService("service")//servcie
                .setController("controller")//controller
                .setEntity("pojo")
                .setXml("mapper");//mapper.xml
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }
}


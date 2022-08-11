package com.example.springbootmybatisplus;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/8/5
 */
@Data
public class MybatisPlusGenerator {

    static final String URL = "jdbc:mysql://172.23.156.10:3305/school?useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false&serverTimezone=GMT%2B8";
    static final String PASSWORD = "123456";
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String USERNAME = "root";


    /**
     *  配置文件名
     */
    private final static String APP_PROPERTY = "application.yml";
    private static String projectPath = System.getProperty("user.dir");

    /**
     * 公共包路径
     */
    private String parentPackage = "com.example";

    /**
     * 模块名
     */
    private String modulePath = "springbootmybatisplus";


    /**
     * 自定义模板的位置
     */
    private String templatePath        = "template/";
    private String controllerTemplate  = templatePath + "controller.java";
    private String serviceTemplate     = templatePath + "service.java";
    private String serviceImplTemplate = templatePath + "serviceImpl.java";
    private String mapperTemplate      = templatePath + "mapper.java";
    private String mapperXMLTemplate   = templatePath + "mapper.xml";

    public static String scanner (String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入");
        help.append(tip);
        help.append("：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (ipt != null && !ipt.trim().isEmpty()) {
                return ipt;
            }
        }
        throw new RuntimeException("请输入正确的：" + tip + "！");
    }


    public void execute() {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "\\spring-boot-mybatis-plus\\src\\main\\java");

        gc.setAuthor("PanYi");
        gc.setOpen(false);
        gc.setActiveRecord(true);
        gc.setIdType(IdType.AUTO);
        gc.setServiceName("%sService");
        gc.setBaseResultMap(true);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);

        mpg.setGlobalConfig(gc);
        // 数据源配置
        mpg.setDataSource(dataSourceConfig());

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentPackage);
        pc.setModuleName(modulePath);
        mpg.setPackageInfo(pc);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setService(serviceTemplate);
        templateConfig.setServiceImpl(serviceImplTemplate);
        templateConfig.setMapper(mapperTemplate);
        templateConfig.setController(controllerTemplate);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        //** 自定义输出配置 *//*
        List<FileOutConfig> focList = new ArrayList<>();
        //** 自定义配置会被优先输出: 读取的是编译后文件的位置 *//*
        focList.add(new FileOutConfig("template/mapper.xml.ftl") {

            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + "\\spring-boot-mybatis-plus\\src\\main\\resources\\mapper\\"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);


        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


    public static DataSourceConfig dataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();

        String resourcePath = System.getProperty("user.dir") + "\\spring-boot-mybatis-plus\\src\\main\\resources\\" + APP_PROPERTY;

        try {
            InputStream inputStream = new FileInputStream(new File(resourcePath));
            Properties prop = new Properties();
            prop.load(inputStream);
            System.out.println(prop.getProperty("spring.datasource.url"));
            dsc.setUrl(prop.getProperty("spring.datasource.url", URL));
            dsc.setDriverName(prop.getProperty("spring.datasource.driver-class-name", DRIVER));
            dsc.setUsername(prop.getProperty("spring.datasource.username", USERNAME));
            dsc.setPassword(prop.getProperty("spring.datasource.password", PASSWORD));
            System.out.println(dsc.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsc;
    }





    public static void main(String[] args) {
        System.out.println(projectPath);
        MybatisPlusGenerator codeGenerator = new MybatisPlusGenerator();
        codeGenerator.execute();

    }
}

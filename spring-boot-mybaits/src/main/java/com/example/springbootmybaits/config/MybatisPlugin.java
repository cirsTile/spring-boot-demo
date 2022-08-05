package com.example.springbootmybaits.config;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.List;

/**
 * @Description:
 * @Author: PanYi
 * @Date: 2022/8/5
 */

public class MybatisPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    private void addMapperInterfaceAnnotations(Interface interfaze) {
        // 添加Mapper的import
        interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));
        // 添加Mapper的注解
        interfaze.addAnnotation("@Mapper");
    }


    private void genJavaTypeComment(JavaElement javaElement, IntrospectedTable introspectedTable) {
        String remarks = introspectedTable.getRemarks();
        javaElement.addJavaDocLine("/**");
        if (StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            for (String remarkLine : remarkLines) {
                javaElement.addJavaDocLine(" * " + remarkLine);
            }
        }
        javaElement.addJavaDocLine(" * ");
        javaElement.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable());
        javaElement.addJavaDocLine(" */");
    }

    private void addMapperInterfaceComment(Interface interfaze, IntrospectedTable introspectedTable) {
        genJavaTypeComment(interfaze, introspectedTable);
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addMapperInterfaceAnnotations(interfaze);
        addMapperInterfaceComment(interfaze, introspectedTable);
        return true;
    }


}

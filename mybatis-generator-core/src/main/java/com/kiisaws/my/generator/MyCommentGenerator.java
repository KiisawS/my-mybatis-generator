package com.kiisaws.my.generator;


import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 重写mybatis-generator注释代码规则
 *
 * @author KiisawS
 */
public class MyCommentGenerator extends DefaultCommentGenerator implements CommentGenerator {


    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private boolean suppressDate = false;
    /**
     * 日期格式化
     */
    private String dateFormatPattern = DEFAULT_DATE_FORMAT;

    private String dateString;

    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.suppressDate = StringUtility.isTrue(properties.getProperty("suppressDate"));
        if (StringUtility.stringHasValue(properties.getProperty("dateFormatPattern"))){
            dateFormatPattern = properties.getProperty("dateFormatPattern");
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormatPattern);
            dateString = sdf.format(new Date());
        }
    }

    @Override
    protected String getDateString() {
        if (suppressDate) {
            return dateString;
        }
        return null;
    }

    /**
     * 实体类字段注释
     * @param field
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * <pre>");
        if (introspectedColumn.getRemarks() != null) {
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
        }
        sb.append(" * 表字段：");
        sb.append(introspectedColumn.getFullyQualifiedJavaType());
        sb.append(".");
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());
        if (introspectedColumn.getDefaultValue() != null) {
            field.addJavaDocLine(" * 默认值：" + introspectedColumn.getDefaultValue());
        }
        field.addJavaDocLine(" * </pre>");
        field.addJavaDocLine(" * ");
        field.addJavaDocLine(" */");
    }

    /**
     * java文件注释，文件顶部，package上面
     *
     * @param compilationUnit
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//        compilationUnit.addFileCommentLine("/*");
//        compilationUnit.addFileCommentLine("*");
//        compilationUnit.addFileCommentLine("* "+compilationUnit.getType().getShortName()+".java");
//        compilationUnit.addFileCommentLine("* Copyright(C) 2017-2020 ***公司");
//        compilationUnit.addFileCommentLine("* @date "+sdf.format(new Date())+"");
//        compilationUnit.addFileCommentLine("*/");
    }


    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addJavaDocLine("/*****/");
        topLevelClass.addImportedType(FullyQualifiedJavaType.getNewArrayListInstance());
    }

    /**
     * Mapper方法注释
     * @param method
     * @param introspectedTable
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    /**
     * set方法注释
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    /**
     * get方法注释
     * @param method
     * @param introspectedTable
     * @param introspectedColumn
     */
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {

    }

    /**
     * xml文件注释
     * @param xmlElement
     */
    @Override
    public void addComment(XmlElement xmlElement) {

    }
}

package com.kiisaws.my.generator;


import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 重写mybatis-generator注释代码规则
 *
 * @author KiisawS
 */
public class MyCommentGenerator extends DefaultCommentGenerator implements CommentGenerator {

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

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addJavaDocLine("/*****/");
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

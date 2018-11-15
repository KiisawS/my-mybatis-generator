package com.kiisaws.my.resolver;

import org.mybatis.generator.api.JavaTypeResolver;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * 重写mybatis-generator类型转换
 * 数据类型与Java类型转换
 *
 * @author KiisawS
 */
public class MyTypeResolver extends JavaTypeResolverDefaultImpl implements JavaTypeResolver {


    public MyTypeResolver() {
        super();
        //原类型关系为 TINYINT -- Byte
        this.typeMap.put(-6, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName())));
    }

}

my-mybatis-generator
mybatis逆向代码生成环境搭建

mybatis-generator-core定制化mybatis逆向代码生成

mybatis-generator-execute执行例子

首先需要将core包安装到本地，命令：mvn clean install <br>
在execute包中，插件引用core包，配置好数据库信息，执行 mybatis-generator:generator
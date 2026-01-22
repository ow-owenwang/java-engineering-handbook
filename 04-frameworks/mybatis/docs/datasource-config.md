









## JNDI
<font style="color:rgb(0, 0, 0);">JNDI 是 Java 命名与目录接口（Java Naming and Directory Interface），在J2EE规范中是重要的规范之一，不少专家认为，没有透彻理解 JNDI 的意义和作用，就没有真正掌握 J2EE 特别是 EJB 的知识。</font>

<font style="color:rgb(0, 0, 0);"></font>

<font style="color:rgb(0, 0, 0);">回忆一下使用 JDBC 操作数据库的几个步骤：</font>

1. 加载数据库驱动
2. 获取连接
3. 执行 SQL
4. 关闭数据源



这种做法一般在简单的应用程序中不会有问题，一旦应用复杂之后，此时需要更换数据库或者账号等等，就非常麻烦了。JNDI 的出现就是为了解决以上诸多问题，Tomcat 提供了数据源的配置选项，我们可以直接在服务器上配置好数据源连接池。当我们需要使用数据源时，只需要向 Tomcat 要即可。



要想使用 JNDI 必须配置虚拟目录，配置是在虚拟目录上起作用的。











<font style="color:rgb(0, 0, 0);"></font>

<font style="color:rgb(0, 0, 0);"></font>


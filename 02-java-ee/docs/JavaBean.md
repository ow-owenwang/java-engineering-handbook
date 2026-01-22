# JavaBean

JavaBean 是一个标准的 Java 类，用来封装数据。

需要满足以下条件：

类必须被 public 修饰

必须提供公共的空参构造器

成员变量必须使用 private 修饰

提供公共 setter 和 getter 方法

JavaBeans是Java中一种特殊的类，可以将多个对象封装到一个对象（bean）中。特点是可序列化，提供无参构造器，提供getter方法和setter方法访问对象的属性。名称中的“Bean”是用于Java的可重用软件组件的惯用叫法。

java为了便于操作数据，通常是使用对象为容器，把需要操作的数据赋值给对象，而为了便于赋值，那我们必须要有这种get/set方法。

JavaBean 是特殊的 Java 类，使用 Java 语言书写，并且遵守 JavaBean 规范。

接下来给出的是 JavaBean 与其它 Java 类相比而言独一无二的特征：

提供一个默认的无参构造函数（一定要为 public ），也可以根据需要定义带参构造函数。

需要被序列化并且实现了 Serializable 接口。

可能有一系列可读写属性。

可能有一系列的 getter 或 setter 方法。

曾经JavaEE开发前端多数用的是JSP技术，因为在JSP出现之前，程序员基本都是在Servlet端直接通过out.print的方式拼接出一个页面返回，这样的做法严重的违背了MVC分层原则，前端会非常难以维护。Jsp技术出现后，极大的改善了这个问题，在将试图层抽离出来的同时，也充分保证了页面的动态性。但是现在开发却很少用到JSP了。终其原因大概可以归纳为以下几点：

1、JSP底层原理就是Servlet直接out.print的方式运行，在第一次访问JSP时，需要将JSP编译成Servlet的class文件，拖慢运行速度。

2、JSP可以直接嵌入java脚本，实现页面动态化，但是这样就打破了分层的思想，影响整体程序结构，降低JSP页面的可读性。

3、可以使用jstl标签或者el表达式代替Java脚本，增加页面的可读性，但是el表达式底层有一些反射实现，这样会降低页面的渲染速度。

4、后续出现了很多优秀的模板技术（velocity、freemarker、thymeleaf等），这些模板技术效率都高于jsp，对于企业和开发者来说，选择变多了。

5、现在很多企业都开始采用前后端分离的项目结构了，后端专注并发、存储等方面，前端通过VUE等框架实现，JSP只能运行在web容器中，无法运行在nginx这样的高效的http服务上，因此慢慢的被时代所遗弃。

https://www.zhihu.com/question/328713931

JavaBean 的应用

JavaBean 是用 Java 语言所写成的可重用组件，它可以应用于系统的很多层中，如 PO、VO、DTO、POJO等。

获取 JavaBean 属性信息

为了防止外部直接对 JavaBean 属性的访问，通常将 JavaBean 中的属性设置为私有的，但需要为其提供共有的访问方法。

只有严格遵循 JavaBean 规范，在 JSP 页面中才能方便地调用及操作 JavaBean。

将 JavaBean 对象应用到 JSP 页面中，JavaBean 的生命周期可以自行进行设置，它存在于4种范围内，分别为 page、request、session 和 application ，默认情况下，JavaBean 作用于 page 范围内。

JavaBean 的产生，使 JSP 页面中的业务逻辑变得更加清晰。程序中的实体对象和业务逻辑可以单独封装到 Java 类中，JSP 页面通过自身操作 JavaBean 的动作标识对其进行操作，改变了 HTML 网页代码与 Java 代码混乱的编写方式，不仅提高了程序的可读性、易维护性，而且还提高了代码的重用性。

在 JSP 网页开发的初级阶段，并没有所谓的框架与逻辑分层的概念，JSP 网页代码是与业务逻辑代码写在一起的。这种零乱的代码书写方式，给程序的调试带来了很大的困难，直至 JavaBean 的出现。

如果使 HTML 代码与 Java 代码相分离，将 Java 代码单独封装成为一个处理某种业务逻辑的类，然后再 JSP 页面中调用此类，则可以降低 HTML 与 Java 代码之间的耦合度，简化 JSP 页面，提高 Java 程序代码的重用性与灵活性。
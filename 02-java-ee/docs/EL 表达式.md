# EL 表达式

## 概述

EL（Expression Language），简化 jsp 页面中的 java 代码编写。

${requestScope.emp.address.street}

jsp 默认支持 EL，如果需要忽略所有表达式，可以在 page 指令中设置 isELIgnored="true"，如果只是想忽略某个表达式，可以这样 \${msg}。

## 运算符

EL 支持的运算符如下：

![](assets/document_image_rId4.png)

根据上表，比较特殊的是 empty 运算符，它用于判断字符串、集合、数组对象是否为 null 或者长度是否为0。

当 EL 表达式的值为 null 时不会显示任何东西。

EL 表达式格式：

操作 List 和数组：${list[0]}、${arr[0]}

操作 bean 的属性：${person.name}、${person['name']}

操作 Map：${map.key}、${map['key']}

## 内置对象

EL 表达式只能从域对象中获取值。EL 一共有11个域对象，无需创建即可使用。

pageScope

requestScope

sessionScope

applicationScope

param：适用于单值参数

paramValues：适用于多值参数

header：适用于单值请求头

headerValues：适用于多值请求头

initParam：获取 web.xml 中 <context-param> 内参数

cookie：

pageContext：可通过它获取 jsp 其他八个内置对象。如要获取虚拟目录：${pageContext.request.contextPath}。

如果 request 域中存储了一个名为 name 的数据，可以这样获取值 ${requestScope.name}。整个过程是依次从最小的域中查找是否有该键对应的值，直到找到为止。

隐式对象：

请求参数相关内置对象：

param 和 paramValues 这两个内置对象是用来获取请求参数的。

param 是 Map<String, String> 类型。

pageContext

![](assets/document_image_rId4.png)

## EL 函数库

使用之前需要导入标签库：

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

标签库中提供了很多常用方法：

${fn:trim("  abc ")}${fn:contains("abc", "b")}

## 自定义函数库

写一个 java 类，类中定义若干个方法，方法必须是静态方法，必须有返回值

在 WEB-INF 目录下创建一个 tld 文件

<function>  <name>fun</name>  <function-class>org.example.fn.MyFunction</function-class>  <function-signature>java.lang.String fun()</function-signature></function>

在 jsp 中导入标签库

<%@ taglib prefix="mylib" uri="/WEB-INF/tlds/hello.tld" %>

使用自定义函数库
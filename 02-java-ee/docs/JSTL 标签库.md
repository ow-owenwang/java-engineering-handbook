# JSTL 标签库

JSTL（JavaServer Pages Tag Library），即 JSP 标准标签库，它是 Apache 对 EL 表达式的扩展，也就是说 JSTL 依赖 EL，它是一种标签语言。

它的出现也是为了简化 jsp 中 java 代码，它不是内置的标签，所以需要自己导包。

JSTL 一共包含四大标签库：

core：核心标签库。

fmt：格式化标签库。

sql：数据库标签库。

xml：xml 标签库。

只需要重点掌握 core 库即可。

## 导入标签库

除了 JSP 动作标签外，使用任何第三方的标签库都需要使用 taglib 导包。

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

prefix 是指定标签库的前缀，值是随意的，一般指定为 c。

## core 标签库常用标签

### out

<c:out value="abc"/>：输出字符串 abc。

<c:out value="${code}" escapeXml="false"/>：输出 code 变量，和 ${code} 一样。不对数据进行转义。

<c:out value="${code}" default="hello"/>：当 code 不存在时，输出 hello 字符串。

### set

<c:set var="msg" value="hello"/>：在 pageContext 中添加属性名为 msg，属性值为 hello 的数据。

<c:set var="msg" value="hello" scope="session"/>：在 session 中添加属性名为 msg，属性值为 hello 的数据。

### remove

<c:remove var="msg" scope="page"/>：删除 pageContext 属性 msg。

<c:remove var="msg"/>：不指定 scope 的话，默认删除所有域中属性 msg。

### url

url 标签会在需要 URL 重写时添加 sessionId。

<c:url value="/"/>：输出上下文路径。

<c:url value="/" var="msg" scope="request"/>：输出结果赋值给变量 msg，范围为 request。

<c:url value="/ServletDemo"/>：输出 上下文路径/ServletDemo。

自定义参数的写法：

<c:url value="/ServletDemo">    <c:param name="username" value="root"/>    <c:param name="password" value="123"/></c:url>

上面代码输出的结果为：/jstl_demo_war_exploded/ServletDemo?username=root&password=123

### if

if 标签的 test 属性必须是一个 boolean 类型的值。

<c:set var="msg" value="hello"/><c:if test="${not empty msg}">    <c:out value="${msg}"/></c:if>

因为不支持 else 的缘故，如果存在多个分支判断时，可以使用多个 if 标签代替。

### choose

<c:set var="score" value="90"/><c:choose>  <c:when test="${score == 100}">满分</c:when>  <c:when test="${score >= 90}">优秀</c:when>  <c:when test="${score >= 60}">及格</c:when>  <c:otherwise>不合格</c:otherwise></c:choose>

test 的值为 true 时，输出当前 when 标签的内容。如果所有 when 都为 false，输出 otherwise 标签的内容。

### forEach

可以用来输出数组和集合。

<c:forEach var="i" begin="1" end="10" step="2">    ${i}<br></c:forEach><c:forEach items="${arr}" var="item">    ${item}<br></c:forEach><c:forEach items="${map}" var="m">    <c:out value="${m.key} : ${m.value}"/></c:forEach>

items：要循环的集合或数组。

var：每次循环，当前值要赋值的变量名。

forEach 标签还有一个属性 varStatus，此属性用来指定接受循环状态的变量名，通过它可以获取的状态有：

count：int 类型，已遍历元素的个数

index：int 类型，当前元素的下标

first：boolean 类型，是否为第一个元素

last：boolean 类型，是否为最后一个元素

current：Object 类型，表示当前元素

## fmt 标签库常用标签

fmt 标签库是用来格式化输出的，一般需要格式化的有时间和数字。

格式化时间：

<fmt:formatDate value="${date}" pattern="yyyy-MM-dd hh:mm:ss"/>

格式化数字：

<fmt:formatNumber value="${d1}" pattern="0.000"/><fmt:formatNumber value="${d2}" pattern="#.##"/>

## 自定义标签
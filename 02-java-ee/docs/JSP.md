# JSP

JSP（Java Server Page）是用来简化 Servlet 输出 HTML 结构数据的一种技术，在 JSP 文件中可以同时编写 Java 代码和 HTML 代码，与 PHP 类似。Java 代码可以用来动态生成内容，而静态内容就用 HTML 的方式编写即可。

在一个 JSP 页面中，可以包括指令标识、HTML 代码、JavaScript 代码、Java 代码、注释和 JSP 动作标识等内容，但这些内容并不是一个 JSP 页面所必需的。

JSP 页面最后都会被编译成一个 Servlet 实例。

## 指令

指令主要用于设定整个 JSP 页面范围内有效的相关信息，它是被服务器解释执行的，不会产生任何内容输出到网页中，并且对于客户端浏览器是不可见的。

指令的语法格式：

<%@ 指令名 属性1="属性值" 属性2="属性值2" %>

参数说明：

指令名：用于指定指令名称，在 JSP 中包含 page、include 和 taglib 3条指令。

属性：用于指定属性名称，不同的指令包含不同的属性。在一个指令中可以设置多个属性，各属性之间用逗号或空格分隔。

属性值：用于指定属性值

<%@page contentType="text/html;charset=UTF-8" language="java" %>

注意：

指令 <%@ 和 %> 是完整的标记，不能添加空格，但是标签中定义的属性与指令之间是有空格的。

为了保证程序的可读性，指令一般放到 JSP 文件的最上方，也就是放在整个 JSP 页面的起始位置。

### page 指令

page 是 JSP 页面最常用的指令，它是可选的。用于定义整个 JSP 页面的相关属性，这些属性在 JSP 中被服务器解析成 Servlet 时会被转换为相应的 Java 程序代码。

常用的属性：

language 属性

指定当前 JSP 编译后的语言类型，默认值为 java。

<%@page language="java" %>

extends 属性

该属性用于设置 JSP 页面生成的 Servlet 去继承该属性指定的类。继承的 Java 类，所有 JSP 页面在执行之前都会被服务器解析成 Servlet，而 Servlet 是由 Java 类定义的，所以 JSP 和 Servlet 都可以继承指定的父类。该属性并不常用，而且有可能影响服务器的性能优化。

import 属性

用于设置 JSP 需要导入的类包，可以出现多次。JSP 页面可以嵌入 Java 代码片段，这些 Java 代码在调用 API 时需要导入相应的类包。

<%@page import="java.util.*" %>

pageEncoding 属性

用于指定 JSP 页面的编码格式，也就是文件编码。在编译成 .java 文件时会使用到。

<%@page pageEncoding="utf-8" %>

contentType 属性

主要做两项工作，一是添加 Content-Type 响应头，等同于 response.setContentType("text/html;charset:utf-8")；二是设置响应字符流编码。当更改成 GBK 编码时，IDEA 右下角也会跟着变化，说明文件编码也变了。

pageEncoding 和 contentType 如果只设置了一个，另外一个的设置也会使用这个设置的。如果两个都没有设置，两个默认都设置为 iso。

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

session 属性

默认值为 true，如果设置为 false，此页面不会初始化 session 这个内置对象。

buffer 属性

用于设置 JSP 的 out 输出对象使用的缓冲区大小，默认为8KB，且单位只能使用KB。一般不做修改，如果必须修改的话，建议使用8的倍数作为该属性的属性值。

autoFlush 属性

用于设置 JSP 页面缓存满时，是否自动刷新缓存。默认值为 true，如果设置为 false，则缓存被填满时将抛出异常。

isErrorPage 属性

指定当前页面是否为错误处理页面，设置为 true 后才可以访问 exception 变量。一般错误页面不能在浏览器中直接通过URL地址访问，所以可以放到 `WEB-INF/` 下，而此目录下的文件通过转发是可以访问到的。

<%@page isErrorPage="true" %>

errorPage 属性

用于指定处理当前 JSP 页面异常错误的另一个 JSP 页面，指定的 JSP 错误处理页面必须设置 isErrorPage 属性为 true。errorPage 属性的属性值是一个 url 字符串。指定若当前页面出现错误，实际响应的页面是哪个。路径中的 / 表示当前 web 应用的根目录。可能出现错误的页面设置 errorPage="errorPage.jsp" 属性，发生错误后转发到的页面设置 isErrorPage="true" 属性。

<%@page errorPage="errorPage.jsp" %>

还有一种方式设置错误页面，就是在 web.xml 中进行配置。

<web-app>  <error-page>    <error-code>404</error-code>    <location>/error404.jsp</location>  </error-page>  <error-page>    <error-code>500</error-code>    <location>/error500.jsp</location>  </error-page>  <error-page>    <exception-type>java.lang.RuntimeException</exception-type>    <location>/error.jsp</location>  </error-page></web-app>

<error-code>：错误状态码。

<location>：发生异常时要转发到的页面。

<exception-type>：异常类型。根据以上代码，如果没有设置，在发生错误时，会响应 error500.jsp。

注意：如果设置 errorPage 属性，那么在 web.xml 文件中定义的任何错误页面都将被忽略，而优先使用该属性定义的错误处理页面。

isElIgnored 属性

是否忽略 EL 表达式，默认值为 false，也就是不忽略，表示支持。

isThreadSafe 属性

当前 JSP 是否支持并发访问。

### include 指令

文件包含指令 include 是 JSP 的另一条指令标识。通过该指令可以在一个 JSP 页面中包含另一个 JSP 页面。不过该指令是静态包含，也就是说被包含文件中所有内容会被原样包含到该 JSP 页面中，即使被包含文件中有 JSP 代码，在包含时也不会被编译执行。使用 include 指令，最终将生成一个文件，所以在被包含和包含的文件中，不能有相同名称的变量。

此指令与 RequestDispatcher.include() 方法的功能类似。<%@include %> 指令是在 JSP 页面编译成 java 文件时完成的。它们共同生成一个 java 文件，然后再生成一个 class。而 RequestDispatcher.include() 方法，包含和被包含的是两个不同的 Servlet，即两个class文件，此方法只是把响应的内容进行了合并。

该指令只有一个 file 属性，用于指定要包含文件的路径。该路径可以是相对路径，也可以是绝对路径，但不可以是通过 <%=%> 表达式所代表的文件。

<%@include file="footer.jsp" %>

使用 include 指令包含文件可以大大提高代码的重用性，而且也便于以后的维护和升级。

### taglib 指令

在 JSP 文件中，可以通过 taglib 指令标识声明该页面中所使用的标签库，同时引用标签库，并指定标签的前缀。在页面中引用标签库后，就可以通过前缀来引用标签库中的标签。

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

参数说明：

- prefix：用于指定标签的前缀。该前缀不能命名为jsp、jspx、java、javax、sun、servlet 和 sunw。

- uri：用于指定标签库文件的存放位置

## 脚本标识

JSP 中的脚本标识包括3部分，即 JSP 表达式（Expression）、声明标识（Declaration）和脚本程序（Scriptlet）。通过这些标识，在 JSP 页面中可以像编写 Java 程序一样来声明变量、定义函数或进行各种表达式的运算。

### JSP 表达式

JSP 表达式用于向页面中输出信息。表达式可以是任何 Java 语言的完整表达式。表达式最终运算结果将被转换为字符串。

语法：

<%=表达式%>

JSP 表达式不仅可以插入到网页的文本中用于输出文本内容，也可以插入到 HTML 标记中用于动态设置属性值。

<%String manager = "mr";%>管理员：<%=manager%><%="管理员：" + manager%><%=5 + 6%><%String url = "1.png";%><img src="images/<%=url%>" alt="">

### 声明标识

用于在 JSP 页面中定义全局的变量或方法。用过声明标识定义的变量和方法可以被整个 JSP 页面访问，所以通常使用该标识定义整个 JSP 页面需要引用的变量或方法。

服务器执行 JSP 页面时，会将 JSP 页面转换为 Servlet 类，在该类中会把使用 JSP 声明标识定义的变量和方法转换为类的成员变量和方法。

语法：

<%! 声明变量或者方法的代码%>

<%!    int number = 0;    int count() {        number++;        return number;    }%><%=count()%>

### 代码片段

所谓代码片段，就是在 JSP 页面中嵌入的 Java 代码或是脚本代码。代码片段将在页面请求的处理期间被执行，通过 Java 代码可以定义变量或是流程控制语句等；而通过脚本代码可以应用 JSP 的内置对象在页面输出内容、处理请求和相应、访问 session 会话等。

语法：

<% Java 代码或是脚本代码 %>

<%    String str = "";    for (int i = 1; i <= 9; i++) {        for (int j = 1; j <= i; j++) {            str += j + "*" + i + "=" + j * i;            str += "&nbsp;";        }        str += "<br>";    }%><%=str%> // 九九乘法表

代码片段的使用比较灵活，它所实现的功能是 JSP 表达式无法实现的。

代码片段与声明标识的区别是：通过声明标识创建的变量和方法在当前 JSP 页面中有效，它的声明周期是从创建开始到服务器关闭结束；代码片段创建的变量或方法，也是在当前 JSP 页面中有效，但它的生命周期是页面关闭后就会被销毁。

### 编译原理

<div>Hello World.</div><%int a = 100;System.out.println(a);out.print(a);%>Hello<%=a%>

编译后：

out.write("<div>Hello World.</div>");int a = 100;System.out.println(a);out.print(a);out.write("Hello");out.print(a);

以上代码会编译为以下代码，并放入生成的 Servlet 中。其中：

HTML 数据会被双引号包裹，以字符串的方式出现在 out.write() 中。

<% %> 中的数据会原封不动的放入 JSP 对应的 Servlet 中，所以它里面的数据必须符合 java 语法。

<%= %> 中的数据会以变量的方式用 out.println() 输出。

## JSP 注释

在代码片段中加入的注释同 Java 的注释相同。

<%    // 单行注释    /*    多行注释     */%>    <%!    // 提示文档注释在被 Javadoc 文档工具生成文档时读取，文档是对代码结构和功能的描述。        int num = 0;    /**     * @function 计数器     * @return 访问次数     */    int count(){        num++;        return num;    }%>

隐藏注释

JSP 提供了一种隐藏注释，这种注释不仅在浏览器中看不到，在查看 HTML 源代码时也看不到，所以这种注释的安全性比较高。

语法：

<%-- 注释内容 --%>

动态注释

由于 HTML 注释对 JSP 嵌入的代码不起作用，因此可以利用它们构成动态的 HTML 注释文本。

示例：

<!-- <%=new Date()%> -->

## 动作标签

### 包含文件标识

用于向当前页面中包含其他的文件，把另外一个资源的输出内容插入到当前 JSP 页面的输出内容之中。被包含的文件可以是动态文件，也可以是静态文件。

语法：

<jsp:include page="index.jsp" flush="false" />

或

<jsp:include page="index.jsp" flush="false">

子动作标识<jsp:param name="" value=""/>

</jsp:include>

参数说明：

page：用于指定被包含文件的相对路径，它也可以通过执行一个表达式（<%=expression%>）来获得。

flush：指定在插入其它资源的输出内容时，是否先将当前 JSP 页面已经输出的内容刷新到客户端。默认为 false，如果设置为 true，在当前页面输出使用了缓冲区的情况下，先刷新缓冲区，然后再执行包含工作。

<jsp:include/> 标识对包含的动态文件和静态文件的处理方式是不同的。如果被包含的是静态文件，则页面执行后，在使用了该标识的位置将会输出这个文件的内容。如果包含的是一个动态文件，那么 JSP 编译器将编译并执行这个文件。

如果要在 JSP 页面中显示大量的纯文本，可以将这些文本文字写入静态文件（如记事本）中，然后通过 include 指令或动作标识包含该 JSP 文件，这样可以让 JSP 页面更简洁。

与 include 指令的区别：

include 指令通过 file 属性指定被包含的文件，并且 file 属性不支持任何表达式；<jsp:include/> 动作标识通过 page 属性指定被包含的文件，而且 page 属性支持 JSP 表达式。

使用 include 指令时，被包含的文件内容会原封不动地插入到包含页中，然后 JSP 编译器再将合成后的文件最终编译成一个 Java 文件；使用 <jsp:include/> 动作标识包含文件时，当该标识被执行时，程序会将请求转发（注意是转发，而不是请求重定向）到被包含的页面，并将执行结果输出到浏览器中，然后返回包含页，继续执行后面的代码。因为服务器执行的是多个文件，所以 JSP 编译器会分别对这些文件进行编译。

在应用 include 指令包含文件时，由于被包含的文件最终会生成一个文件，所以在被包含文件、包含文件中不能有重名的变量或方法；而在应用 <jsp:include/> 动作标识包含文件时，由于每个文件是单独编译的，所以在被包含文件和包含文件中重名的变量和方法是不相冲突的。

### 请求转发标识

通过 <jsp:forward> 动作标识可以将请求转发到其他资源，例如：另一个 JSP 页面、HTML 页面、Servlet 等。执行请求转发后，当前页面将不再被执行，而是去执行该标识指定的目标页面。

<jsp:forward page="index.jsp"/>

或

<jsp:forward page="index.jsp">

<jsp:param name="" value=""/>

</jsp:forward>

参数说明：

page：用于指定被包含文件的相对路径，它也可以通过执行一个表达式（<%=expression%>）来获得。请求被转向的目标文件必须是内部的资源，即当前应用中的资源。

子动作标识 <jsp:param />：用于向转向的目标文件中传递参数。

### 传递参数标识

JSP 的动作标识 <jsp:param> 可以作为其他两个标识的子标识，用于为其他标识传递参数。

<jsp:forward page="modify.jsp">   <jsp:param name="userId" value="<%=expression%>"/></jsp:forward><jsp:include page="modify.jsp">   <jsp:param name="userId" value="7"/></jsp:include>

以上代码在请求转发到 modify.jsp 页面的同时，传递了参数 userId，其参数值为7。

通过 <jsp:param> 动作标识指定的参数，将以“参数名=值”的形式加入到请求中，它的功能与在文件名后面直接加“?参数名=参数值”是相同的。

## 内置对象

JSP 提供了由容器实现和管理的9个内置对象，也可以称之为隐含对象。这些内置对象不需要手动创建就可以直接使用，它们起到了简化 JSP 页面开发的作用。这些对象分别是：

out：用来向客户端输出文本数据，等同于 response.getWriter()。

config: 对应 ServletConfig。

page：当前 JSP 页面的 this，及当前对象。它的引用类型是 Object，相当于 Object page = this。

pageContext：页面上下文对象。可以通过它获取所有的内置对象，如：pageContext.getOut()。

exception：只有在错误页面中可以使用这个对象。

request：即 HttpServletRequest 类的对象。

response：即 HttpServletResponse 类的对象。

application：即 ServletContext 类的实例。

session：即 HttpSession 类的实例，默认每个 JSP 页面都可以使用，除非设置了 <%@page session="false"%>。

### request 对象

request 对象封装了由客户端生成的 HTTP 请求的所有细节，主要包括 HTTP 头信息、系统信息、请求方式和请求参数等。通过 request 对象提供的相应方法可以处理客户端浏览器提交的 HTTP 请求中的各项参数。

访问请求参数

在使用 request 的 getParameter() 方法获取传递的参数值时，如果指定的参数不存在，将返回 null；如果指定了参数名，但未指定参数值，将返回空的字符串。

在作用域中管理属性

在进行请求转发时，需要把一些数据传递到转发后的页面进行处理。可以通过 request 对象的 setAttribute() 方法将数据保存到 request 范围内的变量中。转发到的页面可以通过 request 对象的 getAttribute() 方法获取该变量的值。

request.setAttribute(String name, Object obj);

request.getAttribute(String name);

获取 cookie

在互联网中 cookie 是小段的文本信息，在服务器上生成，并发送给浏览器。通过使用 cookie 可以标识用户身份，记录用户名和密码等。浏览器将 cookie 以 key/value 的形式保存到客户机的某个指定目录中。

getCookies()：获取所有 cookie 对象的集合

getName()：获取指定名称的 cookie

getValue()：获取 cookie 对象的值

addCookie()：添加 cookie 对象

解决中文乱码

所有的 request 请求都是 ISO-8859-1 的，而页面是 UTF-8 的编码方式，要解决此问题，只要将获取到的数据通过 String 的构造方法使用指定的编码类型重新构造一个 String 对象，即可正确地显示中文信息。

貌似不用处理就行！！！

name 参数的值为：<%=new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8")%>

获取客户端的信息

![](assets/document_image_rId4.png)

显示国际化信息

浏览器可以通过 accept-language 的 HTTP 报头向 Web 服务器指明它所使用的本地语言。request 对象中的 getLocale() 和 getLocales() 方法允许 JSP 开发人员获取这一信息，获取的信息属于 java.util.Local 类型。该类型的对象封装了一个国家和国家所使用的一种语言。

### response 对象

response 对象用于响应客户请求，向客户端输出信息。它封装了 JSP 产生的响应，并发送到客户端以响应客户端的请求。请求的数据可以是各种数据类型，甚至是文件。response 对象在 JSP 页面内有效。重定向网页使用 response 对象提供的 sendRedirect() 方法可以将网页重定向到另一个页面。重定向操作支持将地址重定向到不同的主机上，这一点与转发不同。在客户端浏览器上将会得到跳转的地址，并重新发送请求链接。用户可以从浏览器的地址栏看到跳转后的地址。进行重定向操作后，request 中的属性全部失效，并开始一个新的 request 对象。语法：response.sendRedirect(String path);

path：用于指定目标路径，可以是相对路径，也可以是不同主机的其他地址。

注意：该方法之后的代码没有意义，因为不会执行，并且可能产生错误。

处理 HTTP 文件头通过 response 对象可以设置 HTTP 响应报头，最常用的是禁用缓存、设置页面自动刷新和定时跳转网页。

1. 禁用缓存

默认情况下，浏览器将会对显示的网页内容进行缓存。当用户再次访问相关网页时，浏览器会判断网页是否变化，如果没有变化则直接显示缓存中的内容，这样可以提高网页的显示速度。对于一些安全性比较高的网站，通常需要禁用缓存。

<%   response.setHeader("Cache-Control", "no-store");   response.setHeader("Expires", 0);%>

2. 设置页面自动刷新

<%   response.setHeader("refresh", "10");%>

3. 定时跳转页面

<%   response.setHeader("refresh", "5;URL=login.jsp");%>

设置输出缓冲

通常情况下，服务器要输出到客户端的内容不会直接写到客户端，而是先写到一个输出缓冲区，在计算机术语中，缓冲区被定义为暂时放置输入或输出资料的内存。实际上，缓冲区可以这样理解：在一个粮库中，由于装卸车队的速度要快于传送带的传输速度，为了不造成装卸车队的浪费，粮库设计了一个站台，装卸车队可以先将运送的粮食卸到这个平台上，然后让传送机慢慢传送。粮库的这个站台就起到了缓冲的作用。

当满足一下3种情况之一，就会把缓冲区的内容写到客户端。

JSP 页面的输出信息已经全部写入到了缓冲区。

缓冲区已满。

在 JSP 页面中，调用了 response 对象的 flushBuffer() 方法或 out 对象的 flush() 方法。

![](assets/document_image_rId4.png)

注意：如果将缓冲区的大小设置为0KB，则表示不缓冲。

### session 对象

session 在网络中被称为会话。由于 HTTP 协议是一种无状态协议，也就是当一个客户向服务器发出请求，服务器接收请求，并返回响应后，该连接就结束了，而服务器并不保存相关的信息。为了弥补这一缺点，HTTP 协议提供了 session。通过 session 可以在应用程序的 Web 页面间进行跳转时，保存用户的状态，使整个用户会话一直存在下去，知道关闭浏览器。但是，如果在一个会话中，客户端长时间不向服务器发出请求，session 对象就会自动消失。这个时间取决于服务器，例如：Tomcat 服务器默认为30分钟。不过这个时间可以通过编写程序进行修改。

创建及获取客户的会话

通过 session 对象可以存储或读取客户相关的信息，如用户名或购物信息等。

session.setAttribute(String name, Object obj);

用于将信息保存在 session 范围内。

session.getAttribute(String name);

用于获取保存在 session 范围内的信息。

getAttribute() 方法的返回值是 Object 类型，如果将获取到的信息赋值给 String 类型的变量，则需要进行强制类型转换或调用其 toString() 方法。

String user1 = (String)session.getAttribute("username");String user2 = session.getAttribute("username").toString();

从会话中移动指定的绑定对象

对于存储在 session 会话中的对象，如果想将其从 session 会话中移除，可以使用 session 对象的 removeAttribute() 方法。

一定要保证该变量在 session 范围内有效，否则将抛出异常。

<%    session.removeAttribute("username");%>

销毁 session

虽然当客户端长时间不向服务器发送请求后，session 对象会自动消失，但对于某些实时统计在线人数的网站（例如聊天室），每次都等 session 过期后才能统计出准确的人数，这是远远不够的。所以还需要手动销毁 session。通过 invalidate() 方法可以销毁 session。

session 对象销毁后再调用 session 对象的任何方法，都抛出异常。

会话超时管理

在应用 session 对象时应该注意 session 的生命周期。一般来说，session 的生命周期是20~30分钟之间。当用户首次访问时将产生一个新的会话，以后服务器就可以记住这个会话状态，当会话生命周期超时时，或者服务器端强制使会话失效时，这个 session 就不能使用了。在开发程序时应该考虑到用户访问网站时可能发生的各种情况，例如用户登陆网站后在 session 的有效期外进行相应操作，用户会看到一张错误的页面，这样的现象是不允许发生的。为了避免这种情况的发生，在开发系统时应该对 session 的有效性进行判断。

session.getLastAccessedTime();

返回客户端最后一个与会话相关联的请求时间

session.getMaxInactiveInterval();

以秒为单位返回一个会话内两个请求最大时间间隔

session.setMaxInactiveInterval(10000);

以秒为单位设置 session 的有效时间

### pageContext

JSP 中包含4个域对象，除了 Servlet 中的 request、session、ServletContext 3个域对象，还包括 pageContext。通过 pageContext 可以代理其他3个域对象，所以使用这一特性开发人员可以向其它3个对象中存取数据。除此之外还可以通过它获取其它所有的内置对象。

pageContext.setAttribute("name", "John");pageContext.setAttribute("name", "John", PageContext.REQUEST_SCOPE);pageContext.setAttribute("name", "John", PageContext.SESSION_SCOPE);pageContext.setAttribute("name", "John", PageContext.APPLICATION_SCOPE);pageContext.forward();pageContext.include();

### application

该对象用于保存所有应用程序中的公有数据。它在服务器启动时自动创建，在服务器停止时销毁。当该对象没有被销毁时，所有用户都可以共享该对象。与 session 对象相比，该对象的生命周期更长，类似于系统的“全局变量”。

访问应用程序初始化参数

application 对象提供了对应用程序初始化参数进行访问的方法。应用程序初始化参数在 web.xml 文件中进行设置。在 web.xml 文件中通过 <context-param></context-param> 标记配置应用程序初始化参数。

配置连接 MySQL 数据库所需的 url 参数：

<web-app>   <context-param>      <param-name>url</param-name>      <param-value>jdbc:mysql://127.0.0.1:3306/db_database</param-value>   </context-param></web-app>

application.getInitParameter(String name);

返回已命名的参数值

application.getAttributeNames();

返回所有已定义的应用程序初始化参数名的枚举

<%    Enumeration enema = application.getInitParameterNames();    while (enema.hasMoreElements()) {        String name = (String) enema.nextElement();        String value = application.getInitParameter(name);        out.println(name + ": ");        out.println(value);    }%>

管理应用程序环境属性

与 session 对象相同，可以在 application 对象中设置属性。不同的是，session 只是在当前客户的会话范围内有效，当超过保存时间，session 对象就被回收；而 application 对象在整个应用区域中都有效。

getAttributeNames();

获得所有 application 对象使用的属性名

getAttribute(String name);

从 application 对象中获取指定对象名

setAttribute(String key, Object obj);

使用指定名称和指定对象在 application 对象中进行关联

removeAttribute(String name);

从 application 对象中去掉指定名称的属性

### out 对象

out 对象用来向客户端输出文本数据，等同于 response.getWriter() 。response.getWriter() 数据输出永远在 out.write() 之前。

out.print() 方法向客户端输出数据与使用 JSP 表达式输出数据效果相同。

<%    out.print("haha");%><%="haha"%>

out.println() 比 out.print() 多输出一个换行符。浏览器中并不能看到此换行符，需要用 <pre> 标签括起来。

<pre>    <%    	out.println("a");        out.println("b");    %></pre>

管理响应缓冲

out 对象的另一个比较重要的功能就是对缓冲区进行管理。通过调用 out 对象的 clear() 方法可以清除缓冲区的内容。这类似于重置响应流，以便重新开始操作。如果响应已经提交，则会产生 IOException 异常的负作用。out 对象还提供了另一种清除缓冲区内容的方法，那就是 clearBuffer() 方法，通过该方法可以清除缓冲区的“当前”内容，即使内容已经提交给客户端，也能够访问该方法。

![](assets/document_image_rId4.png)

### 其他内置对象

获取会话范围的 pageContext 对象

页面上下文的 pageContext 对象是一个比较特殊的对象，通过它可以获取 JSP 页面的 request、response、session、application 等对象。该对象的创建和初始化都是由容器来完成的，JSP 页面中可以直接使用。

![](assets/document_image_rId4.png)

读取 web.xml 配置信息的 config 对象

该对象主要用于取得服务器的配置信息。通过 pageContext 对象的 getServletConfig() 方法可以获取一个 config 对象。当一个 Servlet 初始化时，容器把某些信息通过 config 对象传递给这个 Servlet。

![](assets/document_image_rId4.png)

应答或请求的 page 对象

page 对象代表 JSP 本身，只有在 JSP 页面内才是合法的。page 对象本质上是包含当前 Servlet 接口引用的变量，可以看作是 this 关键字的别名。

![](assets/document_image_rId4.png)

获取异常信息的 exception 对象

该对象用来处理 JSP 文件执行时发生的所有错误和异常，只有在 page 指令中设置 isErrorPage 属性值为 true 的页面中才可以被使用，在一般的 JSP 页面中使用该对象将无法编译 JSP 文件。该对象几乎定义了所有异常情况，在 Java 程序中，可以使用 try-catch 关键字来处理异常情况，如果在 JSP 页面中出现没有捕捉到的异常，就会生成该对象，并把该对象传送到 page 指令指定的错误页面中，然后在错误页面中处理相应的 exception 对象。

![](assets/document_image_rId4.png)

## 注册与配置 JSP 页面的访问路径

<servlet>	<servlet-name>SimpleJspServlet</servlet-name>	<jsp-file>/jsp/simple.jsp</jsp-file>	<load-on-startup>1</load-on-startup ></servlet><servlet-mapping>	<servlet-name>SimpleJspServlet</servlet-name>	<url-pattern>/xxx/yyy.html</url-pattern></servlet-mapping>

## JSP 中与 JavaBean 相关的标签

JavaBean 规范：

必须要有一个默认构造器

必须提供 get/set 方法，如果只有 get 方法，那么这个属性是只读属性

可以只含有 get/set 方法，不声明对应的成员变量。

<!-- 查找名为 user1 的 javaBean，不存在就创建。 --><jsp:useBean id="user1" class="com.example.domain.User" scope="session"/><!-- 设置 user1 这个 javaBean 的 username 属性的值为 admin。 --><jsp:setProperty property="username" name="user1" value="admin"/><!-- 获取 user1 这个 javaBean 的 username 属性的值。 --><jsp:getProperty property="username" name="user1" value="admin"/>

通常使用成熟的 jar 包来进行开发：

commons-beanutils.jar 依赖内省类 Introspector 实现。常用方法：

BeanUtils.getProperty()

BeanUtils.setProperty()

BeanUtils.populate(Map map, Object bean)

BeanUtils.toBean(Map map, Class class)
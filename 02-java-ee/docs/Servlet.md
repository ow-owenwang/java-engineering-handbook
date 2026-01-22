# Servlet

Servlet，即 Server Applet，广义上它是运行在 Servlet 容器中的动态资源，狭义上它是一个接口。

Servlet 的作用是处理请求，然后进行响应。

与 Java 程序的区别是，Servlet 对象主要封装了对 HTTP 请求的处理，并且它的运行需要 Servlet 容器的支持。

Servlet 可完成如下功能：

创建并返回基于客户请求的动态HTML页面。

创建可嵌入到现有HTML 页面中的部分HTML 页面（HTML 片段）。

与其它服务器资源（如数据库或基于Java的应用程序）进行通信。

Servlet容器响应客户请求的过程

①Servlet引擎检查是否已经装载并创建了该Servlet的实例对象。如果是，则直接执行第④步，否则，执行第②步。

②装载并创建该Servlet的一个实例对象：调用该 Servlet 的构造器

③调用Servlet实例对象的init()方法。

④创建一个用于封装请求的ServletRequest对象和一个代表响应消息的ServletResponse对象，然后调用Servlet的service()方法并将请求和响应对象作为参数传递进去。

⑤WEB应用程序被停止或重新启动之前，Servlet引擎将卸载Servlet，并在卸载之前调用Servlet的destroy()方法。

注册与运行：

Servlet程序必须通过Servlet容器来启动运行，并且储存目录有特殊要求，需要存储在<WEB应用程序目录>\WEB-INF\classes\目录中。

Servlet程序必须在WEB应用程序的web.xml文件中进行注册和映射其访问路径，才可以被Servlet引擎加载和被外界访问。

一个<servlet>元素用于注册一个Servlet，它包含有两个主要的子元素：<servlet-name>和<servlet-class>，分别用于设置Servlet的注册名称和Servlet的完整类名。

一个<servlet-mapping>元素用于映射一个已注册的Servlet的一个对外访问路径，它包含有两个子元素：<servlet-name>和<url-pattern>，分别用于指定Servlet的注册名称和Servlet的对外访问路径。

<servlet>    <servlet-name>xxx</servlet-name>    <servlet-class>servlets.BServlet</servlet-class></servlet><servlet-mapping>    <servlet-name>xxx</servlet-name>    <url-pattern>/hello</url-pattern></servlet-mapping>

同一个Servlet可以被映射到多个URL上，即多个<servlet-mapping>元素的<servlet-name>子元素的设置值可以是同一个Servlet的注册名。

在Servlet映射到的URL中也可以使用*通配符，但是只能有两种固定的格式：一种格式是“*.扩展名”，另一种格式是以正斜杠（/）开头并以“/*”结尾。

<servlet-mapping>	<servlet-name>AnyName</servlet-name>	<url-pattern>*.do</url-pattern></servlet-mapping><servlet-mapping>	<servlet-name>AnyName</servlet-name>	<url-pattern>/action/*</url-pattern></servlet-mapping>

从 Servlet 3.0 开始，不必在 web.xml 中进行配置 Servlet 了，新的标准支持注解配置。

@WebServlet("/hello")：为一个 Servlet 定义访问路径。

@WebServlet({"/user/info", "*.do"})：为一个 Servlet 定义多个访问路径。

注解的出现解决了 XML 繁琐的配置，但对于一些修改也变得麻烦了，注解修改后不得不重新编译。

映射jsp

<servlet>

<servlet-name>hellojsp</servlet-name>

<jsp-file>/hello.jsp</jsp-file>

<init-param>

<param-name>test</param-name>

<param-value>testValue</param-value>

</init-param>

</servlet>

<servlet-mapping>

<servlet-name>hellojsp</servlet-name>

<url-pattern>/hellojsp</url-pattern>

</servlet-mapping>

<error-page>

<error-code>404</error-code>

<location>/WEB-INF/error.jsp</location>

</error-page>

<error-page>

<exception-type>java.lang.ArithmeticException</exception-type>

<location>/WEB-INF/error.jsp</location>

</error-page>

## Servlet 容器

Servlet 容器为 JavaWeb 应用提供运行时环境，它负责管理 Servlet 和 JSP 的生命周期，以及管理它们的共享数据。

目前最流行的 Servlet 容器软件括：

Tomcat

Resin

J2EE服务器（如WebLogic）中也提供了内置的 Servlet 容器。

## ServletConfig 接口

ServletConfig 封装了 Serlvet 的配置信息, 并且可以获取 ServletContext 对象。

Servlet在有些情况下可能需要访问Servlet容器或借助Servlet容器访问外部的资源，所以，Serlvet引擎需要将表示Servlet容器的对象传递给Servlet。另外，在web.xml文件中为某个Servlet设置的友好名称和初始化参数等信息也需要传递给该Servlet

Servlet引擎将代表Servlet容器的对象(ServletContext)和Servlet的配置参数信息一并封装到一个称为ServletConfig的对象中，并在初始化Servlet实例对象时传递给该Servlet。ServletConfig接口则用于定义ServletConfig对象需要对外提供的方法，以便在Servlet程序中可以调用这些方法来获取有关信息。

Servlet引擎调用Servlet的实例对象的init(ServletConfig config)方法将ServletConfig对象传递给Servlet。Servlet.getServletConfig()方法必须返回init(ServletConfig config)方法传递进来的这个ServletConfig对象的引用。

getInitParameterNames

getInitParameter

getServletName

getServletContext

## ServletContext 接口

代表整个web应用，可以和程序的容器(服务器)来通信。

Servlet引擎为每个WEB应用程序都创建一个对应的ServletContext对象，ServletContext对象被包含在ServletConfig对象中，调用ServletConfig.getServletContext方法可以返回ServletContext对象的引用。

获取方式：

通过 request 对象获取 request.getServletContext()。

通过 HttpServlet 获取 this.getServletContext()。

由于一个WEB应用程序中的所有Servlet都共享同一个ServletContext对象，所以，ServletContext对象被称之为 application 对象（Web应用程序对象）。

功能：

获取WEB应用程序的初始化参数

记录日志

application域范围的属性

访问资源文件

获取虚拟路径所映射的本地路径

WEB应用程序之间的访问

ServletContext的其他方法

获取 MIME 类型：String getMimeType(String file)

共享数据：

setAttribute(String name, Object value)

getAttribute(String name)

removeAttribute(String name)

获取文件的真实（服务器）路径：

context.getRealPath("/b.txt")：web 目录下资源访问

context.getRealPath("/WEB-INF/c.txt")：WEB-INF 目录下的资源访问

context.getRealPath("/WEB-INF/classes/a.txt")：src 目录下的资源访问

获取WEB应用程序的初始化参数

为WEB应用程序设置初始化参数的好处在于不需要修改Servlet源程序，就可以改变一些参数信息。

ServletContext.getInitParameterNames 方法用于返回一个包含WEB应用程序的所有初始化参数名称的Enumeration 集合对象，ServletContext.getInitParameter 方法用于返回某个指定名称的初始化参数值。

在web.xml文件的根元素<web-app>中增加<context-param>子元素，如下所示：

<context-param>  <param-name>companyName</param-name>  <param-value>lampbrother</param-value></context-param>

获取虚拟路径所映射的本地路径

getRealPath(String path) 方法: 用于返回某个虚拟路径所映射的本地文件系统路径。

getContextPath()

getResourceAsStream(String path) path的 / 为当前 WEB 应用的根目录，获取当前 WEB 应用的某一个文件对应的输入流。

servletContext.getResourceAsStream("/WEB-INF/classes/1.txt"); 获取类路径下文件流

## HttpServletRequest

Servlet API 中定义的 ServletRequest 接口类用于封装请求消息。

HttpServletRequest 是专用于HTTP协议的ServletRequest 子接口，它用于封装 HTTP 请求消息。

在 service() 方法内部调用 HttpServletRequest 对象的各种方法来获取请求消息。

获取请求行的相关信息

HTTP请求消息的请求行包括请求方式、资源路径和HTTP协议版本：

GET /lampbrother/servlet/RequestURI?param1=a&param2=b HTTP/1.1

getMethod：返回HTTP请求消息中的请求方式。

getRequestURI：返回请求行中的资源名部分。

getQueryString ：返回请求行中的参数部分。

getProtocol：返回请求行中的协议名和版本。

getContextPath：返回请求资源所属于的WEB应用程序的路径。

getPathInfo：返回请求URL中的额外路径信息。额外路径信息是请求URL中的位于Servlet的路径之后和查询参数之前的内容，它以“/”开头。

getPathTranslated：返回URL中的额外路径信息所对应的资源的真实路径。

getServletPath方法：Servlet的名称或Servlet所映射的路径。

获取参数时，需要注意多个同名参数的情况，如何获取到值。

获取网络连接信息

getRemoteAddr方法返回发出请求的客户机的IP地址，其格式为“192.168.0.3”这种形式的字符文本。 （*）

getRemoteHost方法返回发出请求的客户机的完整主机名，即“pc1.atguigu.com”这种格式。

getRemotePort方法返回发出请求的客户机所使用的网络接口的端口号。

getLocalAddr方法返回WEB服务器上接收当前请求的网络接口的IP地址。

getLocalName方法返回WEB服务器上接收当前请求的网络接口的IP地址所对应的主机名。

getLocalPort方法返回WEB服务器上接收当前请求的网络接口的端口号。

getServerName方法返回当前请求所指向的主机名。

getServerPort方法返回当前请求所连接的服务器端口号。

getScheme方法返回请求的协议名，例如http、https或ftp。

getRequestURL方法返回客户端发出请求时的完整URL。

获取请求头信息

getHeader方法

getHeaders方法

getHeaderNames方法

getIntHeader方法

getDateHeader方法

getContentType方

getContentLength方法

getCharacterEncoding方法

获取请求参数

<form action="/servletDemo" method="post">  用户名：<input type="text" name="username"><br>  密码：<input type="text" name="password"><br>  <input type="checkbox" name="hobby" value="game">游戏  <input type="checkbox" name="hobby" value="study">学习  <input type="submit" value="登录"></form>

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    String username = request.getParameter("username");    System.out.println(username);    String[] hobbies = request.getParameterValues("hobby");    for (String h : hobbies) {        System.out.println(h);    }    Enumeration<String> parameterNames = request.getParameterNames();    while (parameterNames.hasMoreElements()) {        String name = parameterNames.nextElement();        String value = request.getParameter(name);        System.out.println(name + ": " + value);    }    Map<String, String[]> parameterMap = request.getParameterMap();    Set<String> names = parameterMap.keySet();    for (String name : names) {        String[] values = parameterMap.get(name);        for (String v : values) {            System.out.println(v);        }    }}

## HttpServletResponse

Servlet API中定义的ServletResponse接口类用于创建响应消息。

HttpServletResponse是专用于HTTP协议的ServletResponse子接口，它用于封装HTTP响应消息。

常见响应头：

Content-Disposition：https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Disposition

Content-Type：https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Type

PrintWriter getWriter()：获取字符输出流

ServletOutputStream getOutputStream()：获取字节输出流

通过流对象可以把数据输出给客户端。

response.getWriter() 获取的流的默认编码是ISO-8859-1，在获取流之前需要先设置 response.setContentType("text/html;charset=utf-8")，否则输出中文会出现乱码。

重定向：

//1. 设置状态码为302response.setStatus(302);//2.设置响应头 locationresponse.setHeader("location","/HelloWorld/user");//或者response.sendRedirect("/HelloWorld/user");response.sendRedirect(request.getContextPath() + "/user");

## Servlet

## GenericServlet

抽象类。将 Servlet 接口中其他的方法做了默认空实现，只将 service() 方法作为抽象。如果继承 GenericServlet 类，需要自己实现 service() 方法。

## HttpServlet

抽象类。为了简化开发，对 HTTP 协议的一种封装。

## 生命周期

Servlet 生命周期可被定义为从创建直到毁灭的整个过程。默认情况下，Servlet 在第一次访问时被创建。可以配置执行 Servlet 的创建时机：

<load-on-startup>0</load-on-startup>：服务器启动时创建。

<load-on-startup>-1</load-on-startup>：第一次访问时创建。

<servlet>  <servlet-name>demo</servlet-name>  <servlet-class>org.example.web.servlet.ServletDemo</servlet-class>  <load-on-startup>0</load-on-startup></servlet><servlet-mapping>  <servlet-name>demo</servlet-name>  <url-pattern>/demo</url-pattern></servlet-mapping>

### init()

它在第一次创建 Servlet 时被调用，只调用一次，在后续每次用户请求时不再调用。由此可知 Servlet 是单例的。

由于单例的特性，多个用户同时访问时，可能存在线程安全问题。所以尽量不要在 Servlet 中定义成员变量。即使定义了成员变量，也不要对值做修改。

### service()

service() 方法是执行实际任务的主要方法。Servlet 容器调用 service() 方法来处理来自客户端的请求，并把格式化的响应写回给客户端。

每次服务器接收到一个 Servlet 请求时，此方法都会被调用一次。service() 方法检查 HTTP 请求类型（GET、POST、PUT、DELETE 等），并在适当的时候调用 doGet、doPost、doPut，doDelete 等方法。

您不用对 service() 方法做任何动作，您只需要根据来自客户端的请求类型来重写 doGet() 或 doPost() 即可。

### destroy()

当服务器正常关闭时，Servlet 被销毁，销毁前此方法会被调用一次。也就是此方法在 Servlet 生命周期结束时被调用唯一一次。此方法一般用于释放资源。

## HttpServletRequest

通过 HttpServletRequest 的实例可以获取所有与当前请求相关的信息，包括 HTTP 协议版本、HTTP 方法、请求头、客户机 IP、请求参数等等。

BufferedReader getReader()：获取字符输入流，只能操作字符数据。

ServletInputStream getInputStream()：获取字节输入流，可以操作所有类型数据。

获取请求参数通用方式：不论 get 还是 post 请求方式都可以使用下列方法来获取请求参数String getParameter(String name)：根据参数名称获取参数值

String[] getParameterValues(String name)：根据参数名称获取参数值的数组

Enumeration<String> getParameterNames()：获取所有请求的参数名称

Map<String,String[]> getParameterMap()：获取所有参数的 Map 集合

乱码问题：

GET 方式：tomcat 8 已经将 get 方式乱码问题解决了。

POST 方式：会乱码。在获取参数前，设置 request 的编码 request.setCharacterEncoding("utf-8")。

请求转发：

请求转发是一种在同一个服务器内部的资源间跳转的方式，不同于重定向，转发时浏览器地址栏不会变化。

req.getRequestDispatcher("/hello").forward(req, resp);

转发地址需要是这种 /hello 形式，路径中不能含有项目名，此处的字符串其实就是要跳转的 Servlet 的映射地址。

域对象：一个有作用范围的对象，可以在范围内共享数据。

request 域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据。

void setAttribute(String name,Object obj)：存储数据

Object getAttitude(String name)：通过键获取值

void removeAttribute(String name)：通过键移除键值对

BufferedReader br = request.getReader();String line = null;while ((line = br.readLine()) != null) {    System.out.println(line);}
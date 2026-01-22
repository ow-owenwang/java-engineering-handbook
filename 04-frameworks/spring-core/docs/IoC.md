

## 什么是程序的耦合
耦合性(Coupling)，也叫耦合度，是对模块间关联程度的度量。耦合的强弱取决于模块间接口的复杂性、调用模块的方式以及通过界面传送数据的多少。模块间的耦合度是指模块之间的依赖关系，包括控制关系、调用关系、数据传递关系。模块间联系越多，其耦合性越强，同时表明其独立性越差( 降低耦合性，可以提高其独立性)。耦合性存在于各个领域，而非软件设计中独有的，但是我们只讨论软件工程中的耦合。



在软件工程中，耦合指的就是就是对象之间的依赖性。对象之间的耦合越高，维护成本越高。因此对象的设计应使类和构件之间的耦合最小。软件设计中通常用耦合度和内聚度作为衡量模块独立程度的标准。**划分模块的一个准则就是高内聚低耦合。**



它有如下分类：

（1）内容耦合。当一个模块直接修改或操作另一个模块的数据时，或一个模块不通过正常入口而转入另一个模块时，这样的耦合被称为内容耦合。内容耦合是最高程度的耦合，应该避免使用之。

（2）公共耦合。两个或两个以上的模块共同引用一个全局数据项，这种耦合被称为公共耦合。在具有大量公共耦合的结构中，确定究竟是哪个模块给全局变量赋了一个特定的值是十分困难的。

（3） 外部耦合 。一组模块都访问同一全局简单变量而不是同一全局数据结构，而且不是通过参数表传递该全局变量的信息，则称之为外部耦合。

（4） 控制耦合 。一个模块通过接口向另一个模块传递一个控制信号，接受信号的模块根据信号值而进行适当的动作，这种耦合被称为控制耦合。

（5）标记耦合 。若一个模块 A 通过接口向两个模块 B 和 C 传递一个公共参数，那么称模块 B 和 C 之间存在一个标记耦合。

（6） 数据耦合。模块之间通过参数来传递数据，那么被称为数据耦合。数据耦合是最低的一种耦合形式，系统中一般都存在这种类型的耦合，因为为了完成一些有意义的功能，往往需要将某些模块的输出数据作为另一些模块的输入数据。

（7） 非直接耦合 。两个模块之间没有直接关系，它们之间的联系完全是通过主模块的控制和调用来实现的。



**总结：**

耦合是影响软件复杂程度和设计质量的一个重要因素，在设计上我们应采用以下原则：如果模块间必须存在耦，就尽量使用数据耦合，少用控制耦合，限制公共耦合的范围，尽量避免使用内容耦合。



内聚与耦合内聚标志一个模块内各个元素彼此结合的紧密程度，它是信息隐蔽和局部化概念的自然扩展。内聚是从功能角度来度量模块内的联系，一个好的内聚模块应当恰好做一件事。它描述的是模块内的功能联系。耦合是软件结构中各模块之间相互连接的一种度量，耦合强弱取决于模块间接口的复杂程度、进入或访问一个模块的点以及通过接口的数据。 程序讲究的是低耦合，高内聚。就是同一个模块内的各个元素之间要高度紧密，但是各个模块之间的相互依存度却要不那么紧密。



内聚和耦合是密切相关的，同其他模块存在高耦合的模块意味着低内聚，而高内聚的模块意味着该模块同其他

模块之间是低耦合。在进行软件设计时，应力争做到高内聚，低耦合。



在开发中，有些依赖关系是必须的，有些依赖关系可以通过优化代码来解除的。

请看如下代码：

```java
//账户的业务层实现类
public class AccountServiceImpl implements IAccountService {
	private IAccountDao accountDao = new AccountDaoImpl();
}
```

业务层调用持久层，并且此时业务层在依赖持久层的接口和实现类。如果此时没有持久层实现类，编译将不能通过。这种编译期依赖关系，应该在开发中杜绝。**我们应该做到的就是编译期不依赖，运行时才依赖。**



再比如，在进行 JDBC 操作时，注册驱动为什么要用 `Class.forName("com.mysql.jdbc.Driver")` 代替 `DriverManager.registerDriver(new com.mysql.jdbc.Driver())` ？



原因就是，我们的类依赖了数据库的具体驱动类（MySQL），如果这时候更换了数据库品牌（比如 Oracle），需要修改源码来重新数据库驱动。这显然不是我们想要的。



## 解决程序耦合的思路
当我们讲解 JDBC 时，是通过反射来注册驱动的。此时的好处是，我们的类中不再依赖具体的驱动类，此时就算删除 MySQL 的驱动 jar 包，依然可以编译（运行就不要想了，没有驱动不可能运行成功的）。



这样，也产生了一个新的问题，MySQL 驱动的全限定类名字符串是在 java 类中写死的，一旦要改还是要修改源码。解决这个问题也很简单，使用配置文件进行配置。



总体来说思路还是很简单的，使用反射来创建对象，对象的全限定类名配置到配置文件中，然后读取配置文件获取全限定类名。



## 控制反转
之前要获取某个对象是通过 `new` 来主动获取，现在是我们需要什么对象，就向容器要，由容器提供。这种思想就是控制反转。



在实际开发中我们可以把三层的对象都使用配置文件配置起来，当启动服务器应用加载的时候，让一个类中的方法通过读取配置文件，把这些对象创建出来并存起来。接下来如果需要用到，直接拿过来用就好了。



简单来说就是，在应用加载时，创建一个 Map，用于存放三层对象，需要某个对象时，就进行查找。



通过控制反转的思想我们可以很容易地**降低**耦合度，但并不能消除程序的耦合度。



<!-- 这是一张图片，ocr 内容为：privateIAccountDaoaccountDaonewAccountDaolmp1) 资源 资源 资源 APP APP 资源 控制资源资源 资源 供资源 i 工厂 accountDao"); IAccountDao beanName: IACCOunTDaO accountDao BeanFa private tBean -->
![](https://cdn.nlark.com/yuque/0/2021/png/115154/1626676682412-cf5ff381-e45f-438b-97f7-b5efe5911778.png)

## 使用 Spring 的 IoC 解决程序耦合
本案例是解决用户的业务层和持久层的依赖关系。



导包：

```xml

```

创建业务层接口及实现类

```java

```

```xml

```









Spring 容器顶层接口是 `BeanFactory`，`ApplicationContext` 是它的子接口。它们两个在创建对象时有明显的差别，`ApplicationContext` 在读取配置文件后会自动创建对象，而 `BeanFactory` 是在使用对象时才去创建对象。



`ApplicationContext` 接口常见的实现类有：

+ `ClassPathXmlApplicationContext`：从类路径下加载配置文件
+ `FileSystemXmlApplicationContext`：从磁盘路径下加载配置文件。
+ `AnnotationConfigApplicationContext`： 当我们使用注解配置容器对象时，需要使用此类来创建 spring 容器。它用来读取注解。  



## <bean>
`<bean>` 标签用来配置哪些对象让 Spring 来管理。默认情况下，Spring 在创建对象时，默认会调用类中的无参构造函数，如果没有无参构造函数则创建失败。



**属性：**

+ `id`： 给对象在容器中提供一个唯一标识。用于获取对象。  
+ `class`： 指定类的全限定类名。用于反射创建对象。默认情况下调用无参构造函数。  
+ `scope`： 指定对象的作用范围。
    - `singleton`：默认值，单例的。
    - `prototype`：多例的。
    - `request`：WEB 项目中，Spring 创建一个 Bean 的对象，将对象存入到 request 域中。
    - `session`：WEB 项目中，Spring 创建一个 Bean 的对象，将对象存入到 session 域中。
    - `global session`：WEB 项目中，应用在 Portlet 环境，如果没有 Portlet 环境，那么 globalSession 相当于 session。
+ `init-method`：指定类中的初始化方法名称。
+ `destroy-method`：指定类中销毁方法名称。



**作用范围和生命周期：**

**单例对象（scope="singleton" ）**

一个应用只有一个对象的实例，它的作用范围就是整个应用。 

当应用加载，创建容器时，对象就被创建了。只要容器在，对象一直活着。当应用卸载，销毁容器时，对象就被销毁了。



**多例对象（scope="prototype"）**

每次访问对象时，都会重新创建对象实例。

当使用对象时，创建新的对象实例。只要对象在使用中，就一直活着。当对象长时间不用时，被 java 的垃圾回收器回收了。  





**实例化 Bean 的三种方式：**

第一种：使用默认无参构造函数，没有默认构造函数，不能创建成功。

```xml
<bean id="accountService" class="org.example.service.impl.AccountServiceImpl"/>
```

第二种：使用静态工厂的方法创建对象，静态工厂可能是存在于某个第三方 jar 包中。

下面模拟一个静态工厂，创建业务层实现类：

```java
public class StaticFactory {
    public static IAccountService createAccountService() {
        return new AccountServiceImpl();
    }
}
```

使用 `StaticFactory` 类中的静态方法 `createAccountService` 创建对象，并存入容器。

```xml
<!--
   id：指定 bean 的 id，用于从容器中获取
   class：指定静态工厂的全限定类名
   factory-method：指定生产对象的静态方法
-->
<bean id="accountService" class="org.example.factory.StaticFactory" factory-method="createAccountService"/>
```

第三种方法：使用普通工厂的方法创建对象，此工厂可能是存在于某个第三方 jar 包中。

模拟一个实例工厂，创建业务层实现类

```java
public class InstanceFactory {
    public IAccountService createAccountService() {
        return new AccountServiceImpl();
    }
}
```

先把工厂的创建交给 spring 来管理，然后在使用工厂的 bean 来调用里面的方法。

```xml
<!--
    factory-bean：用于指定实例工厂 bean 的 id。
    factory-method：用于指定实例工厂中创建对象的方法。
-->
<bean id="instanceFactory" class="org.example.factory.InstanceFactory"/>
<bean id="accountService" factory-bean="instanceFactory" factory-method="createAccountService"/>
```



id 属性：指定 bean 的 id，用于从容器中获取

class 属性：指定静态工厂的全限定类名

factory-method 属性：指定生产对象的静态方法

factory-bean 属性：用于指定实例工厂 bean 的 id。

factory-method 属性：用于指定实例工厂中创建对象的方法。


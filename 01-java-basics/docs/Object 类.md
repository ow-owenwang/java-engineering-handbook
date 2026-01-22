# Object 类

java.lang.Object 类是所有 Java 类的根父类，所以所有类都实现了该类的所有方法。

如果在类的声明中未使用 extends 关键字指明其父类，则默认父类为 Object 类。

public class Person {}// 等价于：public class Person extends Object {}

当方法参数类型是 Object 时，则该方法可以接收任意类型的数据作为参数。

public class Person {    public Person() {    }    public void myMethod(Object o) {        System.out.println(o);    }}

主要方法：

方法

类型

描述

public Object()

构造

构造方法

public boolean equals(Object obj)

普通

对象比较

public int hashCode()

普通

取得Hash码

public String toString()

普通

对象打印时调用

## toString()

toString() 方法在 Object 类中定义，其返回值是对象的字符串表示，字符串内容就是对象的类型+@+内存地址值。

由于 toString 方法返回的结果是内存地址，而在开发中，经常需要按照对象的属性得到相应的字符串表现形式，因此也需要重写它。

可以根据需要在用户自定义类型中重写 toString() 方法。如 String 类就重写了该方法，返回字符串对象的值。

public class Test{    public static void main(String[] args) {        String s2 = new String("AAA");        System.out.println(s2); // AAA    }}

判断一个类是否重写了该方法可以简单的直接打印该类的实例对象，观察其结果。

package ObjectClass;import java.util.ArrayList;import java.util.Random;import java.util.Scanner;// Scanner、ArrayList 重写了 toString() 方法，而 Random 没有。public class Test{    public static void main(String[] args) {        Random r = new Random();        System.out.println(r); //java.util.Random@3f3afe78	相当于 System.out.println(r.toString());        Scanner sc = new Scanner(System.in);        System.out.println(sc); //java.util.Scanner[delimiters=\p{javaWhitespace}+..        ArrayList<Integer> list = new ArrayList<>();        list.add(1);        list.add(2);        list.add(3);        System.out.println(list); //[1, 2, 3]    }}

基本类型数据转换为 String 类型时，会调用对应包装类的 toString() 方法。在进行 String 与其它类型数据的连接操作时，会自动调用 toString() 方法。

public class Test{    public static void main(String[] args) {        int a = 1000;        System.out.println("a=" + a); // a=1000                // 相当于以下代码                System.out.println("a=" + Integer.toString(a));    }}

## equals()

equals() 方法本质上和 == 操作符没有，源码如下：

public boolean equals(Object obj) {    return (this == obj);}

只不过是有一些类（如：File、String、Integer 等等）对其进行了重写，让人感觉和 == 不同而已。

下面是 String 对其重写的源码：

public boolean equals(Object anObject) {    if (this == anObject) {        return true;    }    if (anObject instanceof String) {        String anotherString = (String)anObject;        int n = value.length;        if (n == anotherString.value.length) {            char v1[] = value;            char v2[] = anotherString.value;            int i = 0;            while (n-- != 0) {                if (v1[i] != v2[i])                    return false;                i++;            }            return true;        }    }    return false;}

== 操作符的作用：

基本类型比较值：两个变量的值相等就返回 true。

引用类型比较对象的地址值：对象的地址值相同就返回 true。

Integer integer1 = new Integer(5);Integer integer2 = new Integer(5);int int1 = 3;int int2 = 3;String s1 = new String("Hello");String s2 = new String("Hello");String s3;s3 = s1;System.out.println(integer1 == integer2);//falseSystem.out.println(integer1.equals(integer2));//trueSystem.out.println(int1 == int2);//trueSystem.out.println(s1 == s2);//falseSystem.out.println(s1.equals(s2));//trueSystem.out.println(s1 == s3);//trueSystem.out.println(s1.equals(s3));//true

再看一个例子：

String s1 = "ABC";String s2 = "ABC";System.out.println(s1 == s2);//trueSystem.out.println(s1.equals(s2));//true

为什么都是 true？因为以这种方式声明的字符串会保存在常量池中。每次声明新的字符串时，都会先在常量池中查找，如果已经存在就直接引用它的地址。

Integer a = 100;Integer b = 1000;Integer c = 100;Integer d = 1000;System.out.println(a == b);//falseSystem.out.println(b == c);//falseSystem.out.println(a == c);//trueSystem.out.println(b == d);//false

a 和 c 是不同的对象，地址也就不同，为什么是 true呢？因为在声明 Integer 变量时，默认会调用 valueOf() 方法，此方法会判断值是否在 -128-127 区间内。详情查看源码。
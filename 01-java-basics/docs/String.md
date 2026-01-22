# String

java.lang.String 类代表字符串。Java 程序中所有的字符串文字（例如 "abc" ）都可以被看作是此类的实例。它是一个 final 类，代表不可变的字符序列。一个字符串对象一旦被配置，其内容是不可变的。

和 String 类型容易混淆的是 char 类型，char 类型只能表示单个字符，并且必须放在一对单引号之内。而字符串可以表示单个字符或者多个字符，并且放在一对双引号中。

## 创建字符串

创建一个字符串有几种方式：

通过字符数组创建 String 对象

String 底层就是靠字符数组来实现！

char a[] = {'g', 'o', 'o', 'd'};String str = new String(a);//相当于：String str1 = "good";

提取字符数组中的一部分创建一个字符串对象。

参数 offset 表示开始截取字符串的位置，length 表示截取字符串的长度。

char a[] = {'g', 'o', 'o', 'd'};String s1 = new String(a, 1, 2);

通过类的实例化创建

String str = new String("Hello");String str1 = new String(); // 创建一个空字符串对象

字符串常量的引用赋值给一个字符串变量

String str1;str1 = "Hello";String str2 = "Hello";System.out.println(str1 == str2); // true

str1 和 str2 引用相同的字符串常量，具有相同的实体。

## 连接字符串

对于已声明的字符串，可以对其进行相应的操作。可以对多个字符串进行连接，也可以使字符串与其他数据类型进行连接。

使用“+”运算符可实现连接多个字符串的功能，并最终产生一个 String 对象。

Java 中一句相连的字符串不能分开在两行中书写，如果一个字符串太长，为了便于阅读，可以将这个字符串分在两行上书写。使用“+”将字符串串联起来，并在加号处换行。

System.out.println("Hello" +                "Java");

当字符串与其他基本数据类型进行连接时，其他基本数据类型会自动调用 toString() 方法转换为字符串形式，然后参与连接。因为运算符是有优先级的，所以字符串与其他数据类型连接时会因情况不同而不同。

## 字符串常量

字符串常量池：程序当中直接写上的双引号字符串，就在字符串常量池中。

![](assets/document_image_rId4.png)

## 字符串操作

字符串作为对象，可通过相应方法获取字符串的有效信息。

判断字符串是否相等

对字符串对象进行比较不能简单地使用比较运算符“==”，因为比较运算符比较的是两个字符串的地址是否相同。即使两个字符串的内容相同，两个对象的内存地址也是不同的，使用比较运算符仍然会返回 false。

String str1 = new String("Hello");String str2 = new String("Hello");System.out.println(str1 == str2); // false

要比较两个字符串内容是否相等，应使用 equals() 或 equalsIgnoreCase()。

String str  = "abc"; 与 String str1 = new String("abc"); 的区别？

String s1 = "atguigu";String s2 = "java";String s4 = "java";String s3 = new String("java");System.out.println(s2 == s3); // falseSystem.out.println(s2 == s4); // trueSystem.out.println(s2.equals(s3)); // trueString s5 = "atguigujava";String s6 = (s1 + s2).intern();System.out.println(s5 == s6); // trueSystem.out.println(s5.equals(s6)); // true

## 字符串与基本数据的相互转化

字符串转换为基本数据类型

Integer包装类的public static int parseInt(String s)：可以将由“数字”字符组成的字符串转换为整型。

类似地,使用java.lang包中的Byte、Short、Long、Float、Double类调相应的类方法可以将由“数字”字符组成的字符串，转化为相应的基本数据类型。

基本数据类型转换为字符串

调用String类的public String valueOf(int n)可将int型转换为字符串

相应的valueOf(byte b)、valueOf(long l)、valueOf(float f)、valueOf(double d)、valueOf(boolean b)可由参数的相应类到字符串的转换

字符串与字符数组

String 类的构造方法：String(char[]) 和 String(char[]，int offset，int length) 分别用字符数组中的全部字符和部分字符创建字符串对象

String类提供了将字符串存放到数组中的方法：

public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)

将字符串中的全部字符存放在一个字符数组中的方法：

public char[] toCharArray()

字符串与字节数组

String(byte[])用指定的字节数组构造一个字符串对象。String(byte[]，int offset，int length) 用指定的字节数组的一部分，即从数组起始位置offset开始取length个字节构造一个字符串对象。

public byte[] getBytes() 方法使用平台默认的字符编码，将当前字符串转化为一个字节数组。

public byte[] getBytes(String charsetName) 使用参数指定字符编码，将当前字符串转化为一个字节数组。

## 内存分析

![](assets/document_image_rId4.png)

## 练习

模拟一个trim方法，去除字符串两端的空格。

public static String myTrim(String str) {    int start = 0;    int end = str.length() - 1;    // 为什么只能用单引号    while (start < end && str.charAt(start) == ' ') {        start++;    }    while (start < end && str.charAt(end) == ' ') {        end--;    }    return str.substring(start, end + 1);}

将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”

方法一：

public static String reverseString(String str, int start, int end) {    char[] c = str.toCharArray(); // 字符串 ---> 字符数组    return reverseArray(c, start, end);}public static String reverseArray(char[] c, int start, int end) {    for (int i = start, j = end; i < j; i++, j--) {        char temp = c[i];        c[i] = c[j];        c[j] = temp;    }    // 字符数组 ---> 字符串    return new String(c);}

方法二：

再考虑使用 StringBuffer 将此算法优化。

public static String reverseString1(String str, int start, int end) {    String str1 = str.substring(0, start);    for (int i = end; i >= start; i--) {        char c = str.charAt(i);        str1 += c;    }    str1 += str.substring(end + 1);    return str1;}

获取一个字符串在另一个字符串中出现的次数。比如：获取“ ab”在 “abkkcadkabkebfkabkskab”中出现的次数。

public static int getTime(String str1, String str2) {    int count = 0;    int len;    while ((len = str1.indexOf(str2)) != -1) {        count++;        str1 = str1.substring(len + str2.length());    }    return count;}

获取两个字符串中最大相同子串。比如：str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"

提示：将短的那个串进行长度依次递减的子串与较长的串比较。

public static List<String> getMaxSubString(String str1, String str2) {    String maxStr = (str1.length() > str2.length()) ? str1 : str2;    String minStr = (str1.length() < str2.length()) ? str1 : str2;    int len = minStr.length();    List<String> list = new ArrayList<>();    for (int i = 0; i < len; i++) {        for (int x = 0, y = len - i; y <= len; x++, y++) {            String str = minStr.substring(x, y);            if (maxStr.contains(str)) {                list.add(str);            }        }        if (list.size() != 0) {            return list;        }    }    return null;}

对字符串中字符进行自然顺序排序。

提示：

1）字符串变成字符数组。

2）对数组排序，选择，冒泡，Arrays.sort();

3）将排序后的数组变成字符串。

public static String sort(String str) {    char[] c = str.toCharArray();    Arrays.sort(c);    return new String(c);}
# StringBuffer 类

java.lang.StringBuffer代表可变的字符序列，可以对字符串内容进行增删。

很多方法与String相同，但StingBuffer是可变长度的。

StringBuffer是一个容器。

# 构造方法

StringBuffer()初始容量为16的字符串缓冲区

StringBuffer(int size)构造指定容量的字符串缓冲区

StringBuffer(String str)将内容初始化为指定字符串内容

# 常用方法

StringBuffer append(String s),   StringBuffer append(int n) ,

StringBuffer append(Object o) ,  StringBuffer append(char n),

StringBuffer append(long n),  StringBuffer append(boolean n),

StringBuffer insert(int index, String str)

public StringBuffer reverse()

StringBuffer delete(int startIndex, int endIndex)

public char charAt(int n )

public void setCharAt(int n ,char ch)

StringBuffer replace( int startIndex ,int endIndex, String str)

public int indexOf(String str)

public String substring(int start,int end)

public int length()
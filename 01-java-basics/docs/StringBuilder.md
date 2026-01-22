# StringBuilder

创建成功的字符串对象，其长度是固定的，内容不能被改变。虽然可以使用 + 拼接字符串，但是这个操作会在内存中创建新的字符串对象。如果重复对字符串进行修改，将极大地增加系统开销。

StringBuilder 和 StringBuffer 非常类似，均代表可变的字符序列，而且方法也一样

String：不可变字符序列

StringBuffer：可变字符序列、效率低、线程安全

StringBuilder(JDK1.5)：可变字符序列、效率高、线程不安全

String使用陷阱：

string s="a"; //创建了一个字符串  s=s+"b"; //实际上原来的"a"字符串对象已经丢弃了，现在又产生了一个字符串s+"b"（也就是"ab")。如果多次执行这些改变串内容的操作，会导致大量副本字符串对象存留在内存中，降低效率。如果这样的操作放到循环中，会极大影响程序的性能。

效率比较：

String text = "";
long startTime = 0L;
long endTime = 0L;
StringBuffer buffer = new StringBuffer("");
StringBuilder builder = new StringBuilder("");
startTime = System.currentTimeMillis();
for (int i = 0; i < 20000; i++) {
    buffer.append(String.valueOf(i));
}
endTime = System.currentTimeMillis();
System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
startTime = System.currentTimeMillis();
for (int i = 0; i < 20000; i++) {
    builder.append(String.valueOf(i));
}
endTime = System.currentTimeMillis();
System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
startTime = System.currentTimeMillis();
for (int i = 0; i < 20000; i++) {
    text = text + i;
}
endTime = System.currentTimeMillis();
System.out.println("String的执行时间：" + (endTime - startTime));
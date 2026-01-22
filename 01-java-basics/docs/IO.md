# IO

## File

java.io.File 类，文件和目录路径的抽象表示形式，与平台无关。

File 能新建、删除、重命名文件和目录，但不能访问文件内容本身。如果需要访问文件内容本身，则需要使用“输入/输出流”。

File 对象可以作为参数传递给流的构造函数。

File 实例的几种创建方式：

File dir1 = new File("d:\\dir1");File dir2 = new File(dir1, "dir2");File dir4 = new File(dir1, "dir3/dir4");File file = new File(dir4, "hello.txt");

小练习：

File dir1 = new File("d:\\dir1");File file = new File(dir1, "1.txt");if (!dir1.exists()) {    boolean mkdir = dir1.mkdir();    if (mkdir) {        System.out.println("成功创建目录：d:\\dir1");    } else {        System.out.println("创建目录 d:\\dir1 失败");    }}if (!file.exists()) {    try {        boolean newFile = file.createNewFile();        if (newFile) {            System.out.println("成功创建文件：1.txt");        } else {            System.out.println("创建文件 1.txt 失败");        }    } catch (Exception e) {        e.printStackTrace();    }}

File.separator 属性值为当前系统的路径分隔符。在 Linux 中为 /，在 Windows 中为 \。

## FileReader

文件流。

读取文件：

FileReader fr = null;try {    // 1. 建立一个流对象，将已存在的文件加载进流。    fr = new FileReader("hello.txt");    // 2. 创建一个临时存放数据的数组。    char[] buf = new char[1024];    int len = 0;    // 3. 将流中的数据读入到数组中。    while ((len = fr.read(buf)) != -1) {        System.out.println(new String(buf, 0, len));    }    System.out.println(buf);//buf中有乱码} catch (IOException e) {    e.printStackTrace();} finally {    if (fr != null) {        try {            fr.close();        } catch (IOException e) {            e.printStackTrace();        }    }}

写入文件：

FileWriter fw = null;try {    // 1. 创建流对象以及数据存放的文件    fw = new FileWriter("hello.txt");    // 2. 将数据写入流    fw.write("abc");} catch (IOException e) {    e.printStackTrace();} finally {    if (fw != null) {        try {            // 3. 关闭流资源，并将流中的数据清空到文件中。            fw.close();        } catch (IOException e) {            e.printStackTrace();        }    }}

只有执行 fw.close() 才会真正写入数据。

注意：

定义文件路径时，可以使用 / 或者 \\ 分隔。

在写入文件时，如果目录下有同名文件，将会把其覆盖掉。

在读取文件时，必须保证该文件已存在，否则抛出异常。

## 处理流

### 缓冲流

为了提高数据读写的速度，Java API 提供了带缓冲功能的流类。在使用这些流类时，会创建一个内部缓冲区数组。

根据数据操作单位的不同，可以把缓冲流分为：

BufferedInputStream 和 BufferedOutputStream

BufferedReader 和 BufferedWriter

缓冲流要“套接”在相应的节点流之上，对读写的数据提供了缓冲的功能，提高了读写的效率，同时增加了一些新的方法。

对于输出的缓冲流，写出的数据会先在内存中缓存，使用 flush() 将会使内存中的数据立刻写出。

### 转换流

转换流提供了在字节流和字符流之间的转换。

Java API 提供了两个转换流：

InputStreamReader：用于将字节流中读取到的字节按指定字符集解码成字符。

OutputStreamWriter：用于将要写入到字节流中的字符按指定字符集编码成字节。

### 标准输入/输出流

System.in 和 System.out 分别代表了系统标准的输入和输出设备。默认输入设备是键盘，输出设备是显示器。

System.out 返回的是 PrintStream 类的实例。

通过 System 类的 setIn() 和 setOut() 可以对默认设备进行更改。

### 打印流

在整个 IO 包中，打印流是输出信息最方便的类，一共存在两种打印流类：

PrintStream，字节打印流。

PrintWriter，字符打印流。

这两个类都有自动 flush 功能。

### 数据流

为了方便地操作 Java 语言的基本数据类型的数据，可以使用数据流。一共存在两种数据流类：

DataInputStream

DataOutputStream
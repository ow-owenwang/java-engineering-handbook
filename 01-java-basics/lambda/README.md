# Lambda 表达式知识点总结

## 1. 简介

Lambda 是 JDK8 中的一个语法糖，它可以对某些匿名内部类的写法进行简化。它是函数式编程思想的一个重要体现。让我们不用关注是什么对象，而是更关注我们对数据进行了什么操作。

## 2. 核心概念

### 2.1 核心原则
可推导可省略。

### 2.2 基本格式
(参数列表)->{方法体}

## 3. 基本使用

### 3.1 案例一：创建线程
创建线程时使用匿名内部类的写法：
```java
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println(123);
    }
}).start();
```

修改为 Lambda 的格式：
```java
new Thread(() -> {
    System.out.println(456);
}).start();
```

### 3.2 案例二：使用 IntBinaryOperator
现有方法定义如下，其中`IntBinaryOperator`是一个接口。
```java
public static int calculateNum(IntBinaryOperator operator) {
    int a = 10;
    int b = 20;
    return operator.applyAsInt(a, b);
}
```

匿名内部类调用方法：
```java
int i = calculateNum(new IntBinaryOperator() {
    @Override
    public int applyAsInt(int left, int right) {
        return left + right;
    }
});
System.out.println(i);
```

使用 Lambda 表达式：
```java
int i1 = calculateNum((int left, int right) -> {
    return left + right;
});
System.out.println(i1);
```

### 3.3 案例三：使用 IntPredicate
现有方法定义如下，其中`IntPredicate`是一个接口。
```java
public static void printNum(IntPredicate predicate) {
int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

for (int i : arr) {
    if (predicate.test(i)) {
        System.out.println(i);
    }
}
}
```

使用匿名内部类的写法调用该方法。
```java
printNum(new IntPredicate() {
    @Override
    public boolean test(int value) {
        return value % 2 == 0;
    }
});
```

```java
printNum((int value) -> {
    return value % 2 == 0;
});
```

### 3.4 案例四：使用 Function
现有方法如下，其中`Function`是一个接口。
```java
public static <R> R typeConvert(Function<String, R> function) {
    String str = "1235";
    return function.apply(str);
}
```

先使用匿名内部类的写法调用该方法。
```java
Integer integer = typeConvert(new Function<String, Integer>() {
    @Override
    public Integer apply(String s) {
        return Integer.valueOf(s);
    }
});
System.out.println(integer);
```

```java
Integer integer1 = typeConvert((String s) -> {
    return Integer.valueOf(s);
});
System.out.println(integer1);
```

### 3.5 案例五：使用 IntConsumer
现有方法定义如下，其中`IntConsumer`是一个接口。
```java
public static void foreachArr(IntConsumer consumer) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    for (int i : arr) {
        consumer.accept(i);
    }
}
```

先使用匿名内部类的写法调用该方法。
```java
foreachArr(new IntConsumer() {
    @Override
    public void accept(int value) {
        System.out.println(value);
    }
});
```

```java
foreachArr((int value) -> {
    System.out.println(value);
});
```

## 4. 省略规则
- 参数类型可以省略
- 方法体中只有一句代码时，大括号 return 和唯一一句代码的分号可以省略。
- 方法只有一个参数时，小括号可以省略。


## 5. Stream 流

### 5.1 概述
java8 的 stream 使用的是函数式编程模式，如同它的名字一样，它可以被用来对集合或者数组进行链状流式的操作。可以更方便地让我们对集合或者数组进行操作。

## 6. 示例代码

请参考本目录下的 `code/lambda-demo/src/main/java/org/example/lambda/` 路径下的代码示例：
- `Demo01.java`: 展示了 Lambda 表达式与匿名内部类的对比，使用 `IntBinaryOperator` 接口。
- `Demo02.java`: 展示了 Lambda 表达式在集合操作中的应用，包括 `removeIf` 和方法引用。

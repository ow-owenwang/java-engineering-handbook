# 单元测试知识点总结

## 1. 简介

单元测试是软件开发过程中的重要环节，用于验证代码的各个单元（方法、类）是否按预期工作。JUnit 是 Java 中最流行的单元测试框架。

## 2. JUnit 版本差异

在使用 JUnit 进行单元测试时，需要注意使用的版本，不同的版本导入的包是不同的。

### 2.1 JUnit 4.x 版本

当使用的是 4.* 版本时：

```java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MpTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryList(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
```

### 2.2 JUnit 5.x 版本

当使用 5.* 版本时：

```java
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MpTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryList() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
```

**注意：** 导入的 jar 包是不同的。

## 3. 核心概念

### 3.1 常用注解

#### JUnit 4.x
- `@Test`: 标记测试方法
- `@Before`: 在每个测试方法执行前运行
- `@After`: 在每个测试方法执行后运行
- `@BeforeClass`: 在所有测试方法执行前运行（静态方法）
- `@AfterClass`: 在所有测试方法执行后运行（静态方法）
- `@RunWith`: 指定测试运行器

#### JUnit 5.x
- `@Test`: 标记测试方法
- `@BeforeEach`: 在每个测试方法执行前运行
- `@AfterEach`: 在每个测试方法执行后运行
- `@BeforeAll`: 在所有测试方法执行前运行（静态方法）
- `@AfterAll`: 在所有测试方法执行后运行（静态方法）

### 3.2 断言

JUnit 提供了多种断言方法用于验证测试结果：
- `Assert.assertEquals(expected, actual)`: 断言两个值相等
- `Assert.assertTrue(condition)`: 断言条件为真
- `Assert.assertFalse(condition)`: 断言条件为假
- `Assert.assertNull(object)`: 断言对象为 null
- `Assert.assertNotNull(object)`: 断言对象不为 null

## 4. 示例代码

请参考本目录下的 `code/unit-test-demo/src/test/java/org/example/CalculatorTest.java` 路径下的代码示例，展示了：
- `@Before` 和 `@After` 注解的使用
- `@Test` 注解的使用
- `Assert.assertEquals()` 断言方法的使用


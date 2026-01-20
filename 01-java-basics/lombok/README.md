# Lombok 知识点总结

Lombok 是一种 Java 库，可以通过简单的注解来帮助消除 Java 代码中的冗长。

## 1. 简介
Lombok 提供了一组注解，在编译期自动生成 Getter、Setter、toString、hashCode、equals 等方法，使代码更加简洁，提高开发效率。

## 2. 优点
- **简洁性**：减少了样板代码（Boilerplate Code），让核心业务逻辑更清晰。
- **可维护性**：修改类属性时，不需要手动更新 Getter/Setter 等方法。
- **一致性**：自动生成的代码符合 Java 规范，避免手动编写时出现的错误。

## 3. 常用注解
- `@Data`：最常用的复合注解，包含了 `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode` 和 `@RequiredArgsConstructor`。
- `@Getter` / `@Setter`：单独生成字段的 Getter 和 Setter 方法。
- `@ToString`：生成 `toString()` 方法。
- `@EqualsAndHashCode`：生成 `equals` 和 `hashCode` 方法。
- `@NoArgsConstructor`：生成无参构造函数。
- `@AllArgsConstructor`：生成全参构造函数。
- `@Builder`：提供建造者模式（Builder Pattern），方便链式赋值。
- `@Slf4j`：自动生成 SLF4J 的日志对象 `log`，方便记录日志。
- `@NonNull`：在参数上使用，会自动生成空值检查代码，抛出 `NullPointerException`。
- `@Cleanup`：自动管理资源关闭（如 IO 流），相当于 `try-with-resources`。

## 4. 安装与配置
- **IDE 插件**：在 IntelliJ IDEA 中，需安装 "Lombok" 插件。
- **Maven 依赖**：
  ```xml
  <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.24</version>
      <scope>provided</scope>
  </dependency>
  ```

## 5. 示例代码
请参考本目录下的 `code/lombok-demo/src/main/java/com/example/lombok/` 路径下的代码：
- `User.java`: 展示了 `@Data`, `@Builder`, `@NoArgsConstructor`, `@AllArgsConstructor` 的使用。
- `LombokExample.java`: 展示了 `@Slf4j` 和 Builder 模式的实际调用。

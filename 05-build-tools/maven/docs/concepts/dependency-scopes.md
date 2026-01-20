# Maven 核心概念：依赖范围 (Dependency Scope)

在 Maven 中，`scope` 标签用于控制依赖在构建的各个阶段（编译、测试、运行）的可见性，以及它是否会被包含在最终的发布包（如 JAR,
WAR）中。

## 1. 详细 Scope 列表

| Scope        | 编译 (Compile) | 测试 (Test) | 运行 (Runtime) | 传递性 (Transitive) | 说明                                         | 典型场景                         |
|:-------------|:------------:|:---------:|:------------:|:----------------:|:-------------------------------------------|:-----------------------------|
| **compile**  |      ✅       |     ✅     |      ✅       |        是         | **默认范围**。全阶段有效。                            | 大多数业务类库 (Spring Core, Log4j) |
| **test**     |      ❌       |     ✅     |      ❌       |        否         | 仅测试代码可见，不随包发布。                             | 单元测试框架 (JUnit, Mockito)      |
| **provided** |      ✅       |     ✅     |      ❌       |        否         | 编译测试需要，运行时由容器(如 Tomcat)提供。                 | Servlet API, Lombok          |
| **runtime**  |      ❌       |     ✅     |      ✅       |        是         | 编译不需要（通过接口编程），运行才需要。                       | JDBC 驱动实现, SLF4J 绑定          |
| **system**   |      ✅       |     ✅     |      ❌       |        否         | 类似 provided，但需显式指定本地路径（不推荐）。               | 引用本地未入库的旧 JAR 包              |
| **import**   |      -       |     -     |      -       |        -         | 仅用于 `dependencyManagement`，引入其他 POM 的依赖配置。 | Spring Cloud BOM             |

## 2. 深入解析与场景

### 2.1 compile (默认值)

这是最常用的 scope。如果你不写 `<scope>`，Maven 默认就是 compile。

- **场景**：项目运行必不可少的包，比如常用的工具类 `commons-lang3`。

### 2.2 test

- **为什么需要**：我们不希望将单元测试代码和测试框架打包到生产环境的 JAR 包中，这会增大包体积。
- **场景**：`junit`、`assertj`。

### 2.3 provided

- **为什么需要**：某些包在开发时需要它的 API 进行编译，但在运行时，目标服务器（如 Tomcat, JBoss）或者 JDK
  已经内置了这些包。如果打包进去，可能会产生类冲突。
- **典型代表**：`servlet-api`。
- **特殊用法**：`lombok`。编译时需要生成代码，但运行时 JVM 不需要 lombok 本身。

### 2.4 runtime

- **为什么需要**：解耦。代码中只使用了接口（在编译路径下），具体的实现类在运行时通过反射或其他机制加载。
- **典型代表**：`mysql-connector-java`。你的代码里写的是 `java.sql.*`，那是 JDK 提供的。

### 2.5 import (BOM)

- **为什么需要**：当项目非常大，依赖版本极多时，可以将版本号集中在一个单独的 POM 中维护。子项目通过 `import` 范围引入该
  POM，从而统一版本。
- **示例**：Spring Boot 和 Spring Cloud 的版本管理。

## 3. 依赖传递性中的 Scope 影响

如果项目 A 依赖项目 B，项目 B 依赖项目 C。

- 如果 B 依赖 C 的 scope 是 `compile`，则 A 也会拥有 C。
- 如果 B 依赖 C 的 scope 是 `test` 或 `provided`，则 A **不会** 拥有 C。

## 4. 专家技巧

使用 `mvn dependency:analyze` 可以检查是否有“已使用但未声明”的依赖，或者“已声明但未使用”的依赖，帮助优化 scope 设定。

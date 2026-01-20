# Java Engineering Handbook (Java 技术工程手册)

这是一个 Java 技术栈的知识库，用于记录不同技术的特性以及代码案例。

## 项目结构

该项目按技术领域归类，每个子模块都是一个独立的 Maven 项目，方便展示各自的技术特性：

- `01-java-basics/`: Java 基础技术（Lombok、集合、多线程等）。
- `02-java-ee/`: Java 企业级开发（Servlet、JSP、JWT 等）。
- `03-database-access/`: 数据库访问技术（JDBC、JPA 等）。
- `04-frameworks/`: 常用开发框架（Spring、SpringMVC、MyBatis 等）。
- `05-build-tools/`: 构建及项目管理工具（Maven、Gradle 等）。
- `06-middleware/`: 中间件技术（Redis、RabbitMQ、ZooKeeper 等）。

## 如何使用

每个模块都是独立的，您可以进入具体的技术目录（如 `01-java-basics/lombok`），直接使用 IDE 导入该目录作为 Maven 项目，或者通过命令行运行 `mvn` 命令。

每个模块下都有对应的 `README.md` 文件，详细解释了该技术的使用方法、优点以及核心注解/配置。同时，在 `src/main/java` 下提供了可运行的代码示例。

## 技术概览

### 1. Lombok
- **简介**: 简化 POJO 编写，消除冗长代码。
- **核心注解**: `@Data`, `@Getter`, `@Setter`, `@Slf4j`, `@Builder` 等。
- **详见**: [Lombok 模块 README](01-java-basics/lombok/README.md)

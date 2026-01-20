# Maven 核心概念：聚合与继承 (Aggregation vs Inheritance)

在大型项目中，我们通常将项目拆分为多个模块。Maven 提供了**聚合**和**继承**两种机制来管理这些模块，它们经常一起使用，但解决的问题不同。

## 1. 聚合 (Aggregation)

聚合是为了**方便快速构建项目**。通过在一个父模块中定义多个子模块，你可以只通过一个命令就构建所有的子模块。

### 1.1 特点

- **父模块的 packaging 必须是 `pom`**。
- 父模块通过 `<modules>` 标签列出子模块。
- 执行命令时，在父模块根目录运行（如 `mvn clean install`），Maven 会自动计算构建顺序（Reactor Order）。

### 1.2 场景

- 你有 10 个微服务模块，不想一个个进去 `mvn install`。
- **配置示例**：
  ```xml
  <packaging>pom</packaging>
  <modules>
      <module>user-service</module>
      <module>order-service</module>
  </modules>
  ```

---

## 2. 继承 (Inheritance)

继承是为了**消除配置重复**。子模块可以复用父模块中定义的配置（依赖、插件、属性等）。

### 2.1 特点

- 子模块通过 `<parent>` 标签指向父模块。
- **子模块会继承父模块的**：`groupId` (如果不显式指定)、`version` (如果不显式指定)、`dependencies`、`plugins`、`properties`
  等。
- **重点：`dependencyManagement` 和 `pluginManagement`**。它们被继承后，子模块不会直接引入依赖，而是统一了版本号。

### 2.2 场景

- 确保所有模块使用的 Spring 版本、日志版本完全一致。
- 抽取公共的编译插件配置（如 JDK 17 设置）。

---

## 3. 聚合 vs 继承：对比总结

| 特性             | 聚合 (Aggregation) | 继承 (Inheritance)               |
|:---------------|:-----------------|:-------------------------------|
| **主要目的**       | 方便一组模块的同时构建。     | 减少 POM 配置的冗余，统一管理。             |
| **父模块配置**      | 使用 `<modules>`。  | 使用 `<dependencyManagement>` 等。 |
| **子模块配置**      | 无需感知父模块。         | 使用 `<parent>` 指向父模块。           |
| **目录关系**       | 通常父在顶层，子在子目录。    | 逻辑上的父子关系，不强制目录结构。              |
| ** packaging** | 必须是 `pom`。       | 必须是 `pom`。                     |

## 4. 最佳实践：合二为一

在实际开发中，我们通常会创建一个“根项目 (Root POM)”，它**既是聚合器又是父工程**。

1. **Root POM**：
    - 定义 `<modules>`（聚合）。
    - 定义 `<dependencyManagement>`（管理版本）。
    - 定义公共 `properties` 和 `build` 插件。
2. **Sub Modules**：
    - 定义 `<parent>`。
    - 在 `<dependencies>` 中引入需要的包，**不需要写版本号**。

## 5. 常见困惑

- **Q: 为什么我在父 POM 写了依赖，子 POM 没写但也出现了？**
    - A: 因为你在父 POM 用的是 `<dependencies>`。这会被强制继承。建议改用 `<dependencyManagement>`。
- **Q: 聚合模块必须是继承关系的父模块吗？**
    - A: 不一定。你可以建一个没有任何逻辑关系的聚合项目，只是为了批量编译。但 90% 的场景下它们是同一工程。

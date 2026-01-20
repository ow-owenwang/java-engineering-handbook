# Maven 学习知识库 (Maven Learning Repository)

欢迎来到 Maven 学习知识库！本项目旨在通过理论（Markdown 文档）与实践（代码案例）相结合的方式，深入浅出地讲解 Maven 的各项核心特性和高级用法。

## 目录结构 (Organization)

本知识库采用模块化的方式组织内容，每个模块包含特定的 Maven 特性案例。

### 1. 核心概念与配置 (`/docs/concepts`)
包含 Maven 的基础理论知识：
- `coordinates.md`: 坐标（GAV）与命名规范。
- `lifecycle-phases.md`: 生命周期、阶段与目标的详细解释。
- `dependency-scopes.md`: **[详细]** 六大依赖范围（Scope）及其应用场景。
- `aggregation-vs-inheritance.md`: **[详细]** 聚合与继承的区别、联系与最佳实践。
- `settings-xml.md`: `settings.xml` 全局配置指南。

### 2. 代码案例 (`/maven-*`)
每个子目录都是一个可独立运行的 Maven 项目，演示特定特性：
- **`maven-dependency-management`**: 
  - 依赖范围 (`scope`: compile, test, provided, etc.)
  - 依赖传递与冲突解决 (`exclusion`, `dependencyManagement`)
  - 属性定义与版本统一管理。
- **`maven-build-lifecycle`**:
  - 演示 Default, Clean, Site 生命周期的不同阶段。
- **`maven-multi-module`**:
  - 聚合 (Aggregation) 与 继承 (Inheritance) 的最佳实践。
  - 多模块项目构建顺序。
- **`maven-plugins-extensions`**:
  - 常用插件配置 (`compiler`, `surefire`, `shade`, `assembly`)。
  - 自定义插件开发入门。
- **`maven-repo-distribution`**:
  - 私服仓库配置 (`distributionManagement`)。
  - 镜像 (`mirrors`) 与 仓库 (`repositories`) 的优先级。

## 如何使用 (How to use)

1. **阅读文档**：从 `docs/` 目录开始，了解 Maven 的基本工作原理。
2. **运行案例**：进入具体的案例目录（如 `maven-dependency-management`），使用以下命令观察效果：
   ```bash
   mvn clean install
   mvn dependency:tree
   ```
3. **查阅指南**：在 `docs/guides/` 中查看最佳实践和常见问题。

---
*作为 Java 专家，我建议在学习过程中始终关注 `mvn dependency:tree` 和 `mvn help:effective-pom` 这两个命令，它们是理解 Maven 行为的钥匙。*

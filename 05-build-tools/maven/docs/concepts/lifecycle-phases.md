# Maven 核心概念：生命周期 (Lifecycle)

Maven 的核心设计思想是基于生命周期的。生命周期定义了构建过程的步骤，而具体的任务则由插件目标（Plugin Goals）完成。

## 三大标准生命周期

Maven 拥有三个独立的生命周期：

### 1. Clean 生命周期
用于清理项目。
- **pre-clean**: 执行清理前的工作。
- **clean**: 移除所有上次构建生成的输出（通常是 `target` 目录）。
- **post-clean**: 执行清理后的工作。

### 2. Default (Build) 生命周期
这是最核心的生命周期，负责项目的编译、测试、打包和部署。
常用阶段：
- **validate**: 验证项目是否正确，所有必要信息是否可用。
- **compile**: 编译项目的源代码。
- **test**: 使用单元测试框架运行测试。
- **package**: 将编译后的代码打包成可分发的格式（如 JAR）。
- **verify**: 运行集成测试。
- **install**: 将包安装到本地仓库。
- **deploy**: 将包发布到远程仓库。

### 3. Site 生命周期
用于生成项目文档和站点。
- **pre-site**
- **site**: 生成项目站点文档。
- **post-site**
- **site-deploy**: 将生成的站点发布到服务器。

## 关键点
- **阶段的连续性**：当你执行 `mvn install` 时，Maven 会按顺序执行 `install` 阶段之前的所有阶段（validate, compile, test, package, verify）。
- **插件绑定**：生命周期的阶段本身不具备任何功能，它们必须绑定到具体的插件目标上才能执行任务。

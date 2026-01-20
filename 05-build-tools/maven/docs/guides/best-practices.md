# Maven 最佳实践指南

## 1. 依赖管理
- **优先使用 `dependencyManagement`**：在多模块项目的根 POM 中定义依赖版本，确保所有模块版本一致。详细见 [聚合与继承](../concepts/aggregation-vs-inheritance.md)。
- **避免依赖冲突**：定期使用 `mvn dependency:tree` 检查依赖图，排除不必要的传递依赖。
- **合理使用 `scope`**：
  - 明确区分 `compile`, `test`, `provided`, `runtime`。
  - 详细用法和场景请参考 [依赖范围详解](../concepts/dependency-scopes.md)。

## 2. 插件使用
- **锁定插件版本**：始终在 `pluginManagement` 中显式声明插件版本，避免因 Maven 默认插件版本变化导致构建不稳。
- **绑定插件到生命周期**：利用插件将生成源码、文档、代码检查等任务自动化。

## 3. 多模块组织
- **聚合 (Aggregation)**：在根项目中使用 `<modules>` 标签，一次命令构建所有子项目。
- **继承 (Inheritance)**：子项目通过 `<parent>` 标签复用父项目的配置。

## 4. 仓库与镜像
- **使用中央仓库镜像**：在中国大陆，建议配置阿里云镜像以加速下载。
- **私服部署**：企业级开发必须使用 Nexus 或 Artifactory 管理内部组件。

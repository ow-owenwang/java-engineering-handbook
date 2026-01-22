# gradle-wrapper.properties 和 gradle.properties

gradle-wrapper.properties 和 gradle.properties 是完全不同作用的两个配置文件，它们分别属于 Gradle 构建系统的不同层级。下面是它们的区别：

## 📁 gradle-wrapper.properties

### ✅ 作用

配置项目使用的 Gradle 版本 和 下载地址，由 Gradle Wrapper 使用。

### 🏠 默认位置

<project-root>/gradle/wrapper/gradle-wrapper.properties

### 🧩 典型内容示例

distributionBase=GRADLE_USER_HOMEdistributionPath=wrapper/distsdistributionUrl=https\://services.gradle.org/distributions/gradle-8.5-bin.zipzipStoreBase=GRADLE_USER_HOMEzipStorePath=wrapper/dists

### 📌 用途

指定项目使用哪一版本的 Gradle（比如 8.5）

保证团队或 CI/CD 环境中用的是相同 Gradle 版本

不依赖本地安装的 Gradle，而是自动下载

## 📁 gradle.properties

### ✅ 作用

定义项目或用户级别的 Gradle 构建参数 和属性，常用于：

JVM 参数

项目自定义属性

环境变量（如 API 密钥、版本号等）

### 🏠 默认位置

有两个层级（都可以有）：

类型

路径

说明

项目级

<project-root>/gradle.properties

当前项目有效

用户级

~/.gradle/gradle.properties

所有项目有效

### 🧩 典型内容示例

# JVM 内存设置org.gradle.jvmargs=-Xmx2048m# 允许并行构建org.gradle.parallel=true# 自定义版本号变量appVersion=1.0.0# 设置 Maven 仓库用户名密码（不推荐明文）mavenUser=yournamemavenPassword=secret

## 🧠 总结对比

特性

gradle-wrapper.properties

gradle.properties

主要用途

指定 Gradle 版本

定义构建参数/变量

所在目录

gradle/wrapper/

项目根目录或用户根目录

控制谁使用的 Gradle

项目本身的 Gradle

构建时的环境参数

修改频率

较少（只在切换 Gradle 版本时）

常见（如调 JVM 内存）

常见使用场景

CI/CD 保证一致版本

设置内存、代理、变量

## ✅ 最佳实践

每个项目都保留 gradle-wrapper.properties，确保团队构建环境一致

将通用设置（如 JVM 内存、并行构建）写入 gradle.properties

如果项目构建依赖敏感参数，推荐搭配 .env 或 Gradle 加密插件避免明文暴露
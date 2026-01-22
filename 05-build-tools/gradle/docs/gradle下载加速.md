# gradle下载加速

这是一个 常见问题，尤其在国内或网络有代理限制的情况下，IDEA 初始化 Kotlin 或 Java 项目时默认使用 Gradle，从 https://services.gradle.org 或 https://downloads.gradle.org 拉取资源，可能会 因为网络不畅、被墙、DNS 问题或代理配置不当 导致 connect timed out。

## ✅ 解决方案汇总

你可以从以下几个方向入手：

### 🚀 1. 使用国内镜像加速 Gradle 下载

#### 手动下载 Gradle Wrapper：

IDEA 创建项目时会自动使用 Gradle Wrapper (gradle-wrapper.properties) 下载对应版本的 Gradle，可以手动配置镜像源。

#### 修改 gradle-wrapper.properties：

在项目目录下找到路径：

./gradle/wrapper/gradle-wrapper.properties

修改为如下内容：

distributionUrl=https\://mirrors.cloud.tencent.com/gradle/gradle-8.5-bin.zip

也可以用清华、中科大镜像，例如：

distributionUrl=https\://mirrors.tuna.tsinghua.edu.cn/gradle/gradle-8.5-bin.zip

👉 你可以访问这些网址测试下 Gradle 是否能下载成功。

### 🧰 2. 预先下载 Gradle 并配置 IDE 使用本地版本

手动从镜像网站下载 Gradle：

清华镜像站 Gradle 下载

腾讯云 Gradle 镜像

解压后，在 IDEA 设置中指定：

Preferences / Settings → Build, Execution, Deployment → Build Tools → Gradle

将 Gradle 配置为使用 本地安装，比如：

/Users/yourname/gradle-8.5

### 🌐 3. 设置 HTTP/HTTPS 代理（如你在公司或教育网络环境）

在 IDEA 中设置代理：

Preferences / Settings → Appearance & Behavior → System Settings → HTTP Proxy

如果你使用代理软件（如 Clash、Surge、v2ray），确保已开启系统代理，IDEA 配置为 “使用系统代理” 或填写你的代理端口（如 127.0.0.1:7890）。

### 🧱 4. 离线方式初始化 Gradle 项目

如果你只是想初始化项目而不是联网构建，可以：

先使用 gradle init 命令（在已有 Gradle 环境下）初始化项目

或将别人已有的项目（含 .gradle 和 .idea）复制后导入

### 🐘 5. Gradle 初始化后网络构建依赖超时怎么办？

那是依赖拉取问题，可在 build.gradle.kts 中配置镜像仓库，例如：

repositories {    maven { url = uri("https://maven.aliyun.com/nexus/content/groups/public/") }    mavenCentral()}

## 📌 小结

场景

解决方案

下载 Gradle Wrapper 超时

修改 gradle-wrapper.properties 使用国内镜像

不想联网

本地安装 Gradle，IDEA 指定本地路径

网络限制

配置 IDEA 的代理

构建依赖慢

使用国内 Maven 镜像
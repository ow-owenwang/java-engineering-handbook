# Elasticsearch 知识点总结

Elasticsearch 是一个基于 Lucene 的分布式搜索和分析引擎，提供了强大的全文搜索、实时分析和数据存储能力。

## 1. 简介

Elasticsearch 是一个开源的分布式搜索和分析引擎，具有以下特点：
- **分布式架构**：支持水平扩展，可以轻松处理大规模数据
- **实时搜索**：近实时的搜索和分析能力
- **RESTful API**：提供简单易用的 RESTful 接口
- **多种数据类型**：支持结构化、非结构化、地理位置等多种数据类型

## 2. 核心概念

### 2.1 索引（Index）
索引类似于关系型数据库中的数据库，是文档的集合。

### 2.2 类型（Type）
在 Elasticsearch 7.x 之前，类型类似于关系型数据库中的表。从 7.x 开始，一个索引只能包含一个类型 `_doc`。

### 2.3 文档（Document）
文档是索引中的基本数据单元，类似于关系型数据库中的一行记录。

### 2.4 字段（Field）
文档中的属性，类似于关系型数据库中的列。

## 3. 常用操作

### 3.1 创建索引
```java
CreateIndexRequest request = new CreateIndexRequest("my_index");
client.indices().create(request, RequestOptions.DEFAULT);
```

### 3.2 添加文档
```java
IndexRequest request = new IndexRequest("my_index")
    .id("1")
    .source(jsonMap, XContentType.JSON);
client.index(request, RequestOptions.DEFAULT);
```

### 3.3 搜索文档
```java
SearchRequest request = new SearchRequest("my_index");
SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
sourceBuilder.query(QueryBuilders.matchQuery("field", "value"));
request.source(sourceBuilder);
SearchResponse response = client.search(request, RequestOptions.DEFAULT);
```

### 3.4 删除文档
```java
DeleteRequest request = new DeleteRequest("my_index", "1");
client.delete(request, RequestOptions.DEFAULT);
```

## 4. 查询类型

- **Match Query**：全文搜索
- **Term Query**：精确匹配
- **Range Query**：范围查询
- **Bool Query**：布尔查询（组合多个查询条件）
- **Wildcard Query**：通配符查询

## 5. 聚合分析

Elasticsearch 提供了强大的聚合功能：
- **Metrics Aggregations**：统计聚合（sum, avg, max, min 等）
- **Bucket Aggregations**：分组聚合（terms, date_histogram 等）
- **Pipeline Aggregations**：管道聚合

## 6. 安装与配置

### 6.1 安装 Elasticsearch
- 下载地址：https://www.elastic.co/downloads/elasticsearch
- docker 镜像：https://www.elastic.co/docs/deploy-manage/deploy/self-managed/install-elasticsearch-with-docker
- 运行：`bin/elasticsearch`（Linux/Mac）或 `bin\elasticsearch.bat`（Windows）

### 6.2 Maven 依赖
请参考本目录下的 `code/elasticsearch-demo/pom.xml` 文件。

## 7. 示例代码

请参考本目录下的 `code/elasticsearch-demo/src/main/java/com/example/elasticsearch/` 路径下的代码示例。

## 8. 最佳实践

- **索引设计**：合理设计索引结构，避免过度索引
- **分片策略**：根据数据量和查询需求设置合适的分片数
- **映射优化**：合理设置字段类型和映射，提高查询效率
- **批量操作**：使用 Bulk API 进行批量操作，提高性能
- **监控与调优**：定期监控集群状态，优化查询性能

# 02-请求映射与参数绑定

## 请求映射

使用 `@RequestMapping` 及其简写形式：
- `@GetMapping`
- `@PostMapping`
- `@PutMapping`
- `@DeleteMapping`
- `@PatchMapping`

## 参数获取

### 1. 路径变量 (`@PathVariable`)
```java
@GetMapping("/users/{id}")
public User getUser(@PathVariable("id") Long id) { ... }
```

### 2. 查询参数 (`@RequestParam`)
```java
@GetMapping("/search")
public List<User> search(@RequestParam(name = "q", required = false) String query) { ... }
```

### 3. 请求体 (`@RequestBody`)
通常用于 JSON 数据。
```java
@PostMapping("/users")
public User createUser(@RequestBody User user) { ... }
```

### 4. POJO 绑定
Spring 会自动将请求参数匹配到对象的属性。
```java
@GetMapping("/save")
public String saveUser(User user) { ... }
```

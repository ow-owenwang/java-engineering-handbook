# #{} 和 ${} 的区别

## 主要区别

`#{}` 方式可以防止 SQL 注入，`${}` 方式无法防止 SQL 注入。



`${}` 可以用于动态参数，如：有两张表 `emp_2017` 和 `emp_2018`，可以动态指定表名。

```xml
<select>
  select * from emp_${year}
</select>
```

排序时：

```xml
<select>
  select * from dept order by ${name}
</select>
```

用 `#{}` 进行模糊查询：

```xml
<select id="queryUserByUsername" parameterType="string" resultType="org.example.pojo.User">
	select * from `user` where username like #{username}
</select>
```

`List<Object> list = sqlSession.selectList("queryUserByUsername", "%王%");`



用 `${}` 进行模糊查询：

```xml
<select id="queryUserByUsername" parameterType="string" resultType="org.example.pojo.User">
	select * from `user` where username like '%${value}%'
</select>
```

`List<Object> list = sqlSession.selectList("queryUserByUsername2", "王");`






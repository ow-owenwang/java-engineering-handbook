package com.example.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data 注解：包含 @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
 * @Builder 注解：提供 建造者模式 链式编程
 * @NoArgsConstructor: 无参构造
 * @AllArgsConstructor: 全参构造
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String email;
    private Integer age;
}

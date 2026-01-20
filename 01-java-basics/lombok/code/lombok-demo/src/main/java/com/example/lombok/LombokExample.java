package com.example.lombok;

import lombok.extern.slf4j.Slf4j;

/**
 * @Slf4j 注解：自动生成 log 日志对象
 */
@Slf4j
public class LombokExample {

    public static void main(String[] args) {
        // 使用 @Builder
        User user = User.builder()
                .id(1L)
                .username("Junie")
                .email("junie@example.com")
                .age(18)
                .build();

        // 使用 @Data 自动生成的 toString()
        log.info("User details: {}", user);

        // 使用 @Getter/@Setter
        user.setAge(20);
        log.info("Updated User age: {}", user.getAge());
    }
}

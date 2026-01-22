package org.example.beanutils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

public class CommonUtils {

    /**
     * 生成不重复的32位长的大写字符串
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    /**
     * 把 map 转换成指定类型的 javaBean 对象
     *
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toBean(Map<String, Object> map, Class<T> clazz) {
        try {
            T bean = clazz.newInstance();
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

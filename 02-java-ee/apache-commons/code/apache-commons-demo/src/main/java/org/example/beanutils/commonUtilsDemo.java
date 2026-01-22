package org.example.beanutils;


import org.example.domain.Person;
import org.junit.Test;

import java.util.HashMap;

/*
    依赖的jar包：commons-beanutils.jar 、commons-logging.jar

 */
public class commonUtilsDemo {

    /**
     * 生成长度32的随机字符，通常用来做实体类的ID。底层使用了UUID类完成；
     *
     * 1.用来做id ,数据库表中的主键是不能重复的,它就是不重复的!
     * 2.激活码也是不能重复的,也可以用到这个小工具!
     */
    @Test
    public void testUUID() {
        String uuid = CommonUtils.uuid();
        System.out.println(uuid);
    }

    /**
     * 把 Map 转换成指定类型的 Bean 对象。通常用来获取表单数据（ request.getParameterMap() ）封装到 JavaBean 中，底层使用了 common-beanutils 。
     * 注意，本方法要求 map 中键的名称要与 Bean 的属性名称相同才能完成映射，否则不能完成映射。
     *
     */
    @Test
    public void testToBean() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 18);
        map.put("sex", "男");

        Person person = CommonUtils.toBean(map, Person.class);
        System.out.println(person);
    }


}

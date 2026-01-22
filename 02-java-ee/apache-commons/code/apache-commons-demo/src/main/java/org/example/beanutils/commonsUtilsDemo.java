package org.example.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.example.domain.User;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class commonsUtilsDemo {

    @Test
    public void fun1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        String className = "org.example.Person";
        Class<?> clazz = Class.forName(className);
        Object o = clazz.newInstance();
        BeanUtils.setProperty(o, "name", "张三");
        BeanUtils.setProperty(o, "age", "20");
        BeanUtils.setProperty(o, "sex", "男");

        System.out.println(o);

        String age = BeanUtils.getProperty(o, "age");
        System.out.println(age);
    }

    /**
     * 开发中可能会有这样的需求：将表单提交过来的请求参数封装在一个javaBean中，这个时候我们再使用BeanUtils的setProperty()和getProperty()方法就会很麻烦；
     * 因此BeanUtils又为我们提供了一个静态方法populate(Object bean,Map properties)，其中第二个参数就是封装请求参数的Map，
     * 我们可以通过request.getParameterMap()方法获取一个封装了所有请求参数的Map对象。
     */
    @Test
    public void fun2() throws InvocationTargetException, IllegalAccessException {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "Doe");
        map.put("password", "123");
        map.put("job", "coder");

        User user = new User();
        BeanUtils.populate(user, map);
        System.out.println(user);
    }


}

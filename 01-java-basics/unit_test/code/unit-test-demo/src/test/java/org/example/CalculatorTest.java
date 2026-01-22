package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    /**
     * 用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init() {
        System.out.println("init...");
    }

    /**
     * 在所有测试方法执行完后，都会自动执行该方法
     */
    @After
    public void close() {
        System.out.println("close...");
    }

    @Test
    public void add() {
        Calculator c = new Calculator();
        int result = c.add(1, 2);
        //断言  我断言这个结果是3
        Assert.assertEquals(3, result);
    }

    @Test
    public void sub() {
        Calculator c = new Calculator();
        int result = c.sub(1, 2);
        Assert.assertEquals(-1, result);
    }
}
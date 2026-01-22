package org.example.util_arrays;

import org.junit.Test;

import java.util.Arrays;

public class ArraysTest {

    /**
     * 返回数组的字符串形式
     */
    @Test
    public void testToString() {
        int[] nums = {2, 5, 0, 4, 6, -10};
        String s = Arrays.toString(nums);
        System.out.println(s);
    }

    /**
     * 返回多维数组的字符串形式
     */
    @Test
    public void testDeep(){
        int[][] nums = {{1,2,3}, {4,5}};
        String s = Arrays.deepToString(nums);
        System.out.println(s);
    }

    /**
     * 对数组进行升序排序
     */
    @Test
    public void testSort() {
        int[] nums = {2, 5, 0, 4, 6, -10};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 对数组指定范围的元素进行排序
     */
    @Test
    public void testSort1() {
        int[] nums = {2, 5, 0, 4, 6, -10};
        Arrays.sort(nums, 0, 4);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void testFill() {
        int[] nums = {2, 5, 0, 4, 6, -10};
        Arrays.fill(nums, 0);
        System.out.println(Arrays.toString(nums));
    }


}

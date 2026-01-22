package annotation.annotationclass;

import java.util.Arrays;

public class DataHolderTest {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3};

        DataHolder<Integer[]> holder = new DataHolder<>();
        holder.setData(nums);
        String s = Arrays.toString(holder.getData());
        System.out.println(s);
    }
}

package org.example.common.Runtime;

public class Demo01 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        long maxMemory = runtime.maxMemory();

        System.out.println(freeMemory);
        System.out.println(totalMemory);
        System.out.println(maxMemory);

    }
}

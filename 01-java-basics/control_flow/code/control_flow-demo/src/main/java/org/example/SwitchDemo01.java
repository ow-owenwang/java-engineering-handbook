package org.example;

/*
 * 因为与 i 匹配的地方没有 break，所以程序会继续向下执行，直到某个 case 出现 break 为止。
 * 如果没有与 i 匹配的 case，那么程序只执行 default 中的代码。
 * */
public class SwitchDemo01 {
    public static void main(String[] args) {
        int i = 5;
        switch (i) {
            case 0:
                System.out.println("执行case0");
            case 1:
                System.out.println("执行case0");
            case 5:
                System.out.println("执行case5");
            case 10:
                System.out.println("执行case10");
                //break;
            default:
                System.out.println("执行default");
        }
    }
}

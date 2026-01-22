package org.example.oop.final_keyword;

/**
 * 当成员变量没有赋值时，默认会有默认值。
 * 但是，当 final 修饰成员变量时，此变量必须得手动赋值。赋值的方式可以是声明变量时直接赋值或者构造函数赋值。
 * 如果存在多个构造函数，每个构造方法中必须都对此变量赋值。
 */
public class FinalDemo03 {
    private final String str;

    public FinalDemo03() {
        this.str = "默认值";
    }

    public FinalDemo03(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}

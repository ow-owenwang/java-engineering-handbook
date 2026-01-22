# BigDecimal 类

一般的Float类和Double类可以用来做科学计算或工程计算，但在商业计算中，要求数字精度比较高，故用到java.math.BigDecimal类。BigDecimal类支持任何精度的定点数。

# 构造器

public BigDecimal(double val)

public BigDecimal(String val)

# 常用方法

方法

功能描述

add(BigDecimal augend)

subtract(BigDecimal subtrahend)

multiply(BigDecimal multiplicand)

divide(BigDecimal divisor, int scale, int roundingMode)
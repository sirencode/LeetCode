package com.syh.algorithm.leetcode.normal;

/**
 * 定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */
public class Math_Divide {
    public static void main(String[] args) {
//        System.out.println(divide(-2147483648, -1));
//        System.out.println(divide(44444444, 4));
        System.out.println(divide(10, 3));
//        System.out.println(divide(15, 4));
//        System.out.println(divide(16, 4));
//        System.out.println(divide(15, -4));
//        System.out.println(divide(-15, -4));
//        System.out.println(divide(-15, 0));
//        System.out.println(divide(0, 4));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
            return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        int res = (int) div(a, b);
        if (sign > 0) return res > Integer.MAX_VALUE ? Integer.MAX_VALUE :  res;
        return -res;
    }

    public static long div(long a, long b) {  // 似乎精髓和难点就在于下面这几句
        if (a < b) return 0;
        long count = 1;
        long tb = b; // 在后面的代码中不更新b
        while ((tb + tb) <= a) {
            count = count + count; // 最小解翻倍
            tb = tb + tb; // 当前测试的值也翻倍
        }
        return count + div(a - tb, b);
    }

}

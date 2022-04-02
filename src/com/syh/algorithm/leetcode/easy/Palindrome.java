package com.syh.algorithm.leetcode.easy;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 示例
 * 121 是回文，而 123、-121 不是。
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println("0 is Palindrome:"+isPalindrome(0));
        System.out.println("-121 is Palindrome:"+isPalindrome(-121));
        System.out.println("10 is Palindrome:"+isPalindrome(10));
        System.out.println("121 is Palindrome:"+isPalindrome(121));
    }

    /**
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (revertedNumber < x) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber/10;
    }
}

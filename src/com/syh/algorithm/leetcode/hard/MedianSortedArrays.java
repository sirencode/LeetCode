package com.syh.algorithm.leetcode.hard;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 */
public class MedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        int[] nums3 = new int[]{1, 3};
        int[] nums4 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums3, nums4));
    }

    /**
     * 时间复杂度：O(log（min（m，n））
     * 空吗构建复杂度O(1）
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B,A); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            // 我们把数组 A 和数组 B 分别在 i 和 j 进行切割。
            // 将 i 的左边和 j 的左边组合成「左半部分」，将 i 的右边和 j 的右边组合成「右半部分」。
            // 当 A 数组和 B 数组的总长度是偶数时，左半部分的长度等于右半部分，（左半部分最大值 + 右半部分最小值 ）/ 2。
            // （max ( A [ i - 1 ] , B [  j  - 1 ]）+ min ( A [ i ] , B [ j ]）） /  2
            // 当 A 数组和 B 数组的总长度是奇数时，左半部分的长度比右半部分大 1，左半部分最大值，也就是左半部比右半部分多出的那一个数。
            // max ( A [ i - 1 ] , B [  j - 1 ]）
            int i = (iMin + iMax) / 2; // A len是偶数，i==m/2  A是奇数 i==m/2-1
            int j = (m + n + 1) / 2 - i; // B len是偶数，j==n/2  B是奇数 i==m/2+1
            // j>0 && i < m && B_left > A_right i 需要增大 j减少
            if (j != 0 && i != m && B[j-1] > A[i]){
                iMin = i + 1;
            } else if (i != 0 && j != n && A[i-1] > B[j]) { // j<n && i > 0 && A_left > B_right i 需要减小 j增大
                iMax = i - 1;
            } else {
                // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                // 奇数的话不需要考虑右半部分
                if ( (m + n) % 2 == 1 ) { return maxLeft; }
                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }
                //如果是偶数的话返回结果
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}

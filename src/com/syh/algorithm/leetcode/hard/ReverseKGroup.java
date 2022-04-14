package com.syh.algorithm.leetcode.hard;

import com.syh.algorithm.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 示例 3：
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * 示例 4：
 * 输入：head = [1], k = 1
 * 输出：[1]
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode node = ListNode.buildNode(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(new ReverseKGroup().reverseKGroup(node, 2));
    }

    /**
     * 时间复杂度为 O(n*K) 最好的情况为 O(n) 最差的情况未 O(n^2)
     * 空间复杂度为 O(1) 除了几个必须的节点指针外，我们并没有占用其他空间
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 双指针记录需要反转的头尾
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}

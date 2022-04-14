package com.syh.algorithm.leetcode;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode buildNode(List<Integer> list) {
        ListNode pre = null;
        ListNode head = null;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ListNode cur = new ListNode(list.get(i));
                if (i != 0) {
                    pre.next = cur;
                } else {
                    head = cur;
                }
                pre = cur;
            }
            return head;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(val);
        ListNode listNode= next;
        while (listNode != null) {
            stringBuilder.append("->");
            int value = listNode.val;
            stringBuilder.append(value);
            listNode = listNode.next;
        }
        return stringBuilder.toString();
    }
}

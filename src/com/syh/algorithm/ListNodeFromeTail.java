package com.syh.algorithm;


import com.syh.algorithm.leetcode.LinkList;
import com.syh.algorithm.leetcode.ListNode;

import java.util.ArrayList;

/**
 * Created by shenyonghe on 2020/5/19.
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class ListNodeFromeTail {

    ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode node = listNode;
        while (node != null) {
            arrayList.add(0, node.val);
            node = node.next;
        }
        return arrayList;
    }

    public ArrayList<Integer> printListFromTailToHead_(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead_(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(printListFromTailToHead(LinkList.buildDeleteNode()));
        ListNodeFromeTail listNodeFromeTail = new ListNodeFromeTail();
        System.out.println(listNodeFromeTail.printListFromTailToHead_(LinkList.buildDeleteNode()));
    }
}

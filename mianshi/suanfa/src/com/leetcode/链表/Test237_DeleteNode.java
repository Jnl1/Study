package com.leetcode.链表;

public class Test237_DeleteNode {
    public static void main(String[] args) {
    }
   public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public static void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newList = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newList;
    }
}

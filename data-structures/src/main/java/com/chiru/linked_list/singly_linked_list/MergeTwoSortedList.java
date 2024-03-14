package com.chiru.linked_list.singly_linked_list;

/**
 * @author Chiranjeevi
 */
public class MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    private static ListNode add(ListNode head,int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static ListNode mergeTwoLists(ListNode head,ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                head =add(head,list2.val);
                list2 = list2.next;
            } else {
                head = add(head,list1.val);
                list1 = list1.next;
            }
        }
        while (list1 != null) {
            head = add(head,list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            head = add(head,list2.val);
            list2 = list2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode head1;
        ListNode head2;
        ListNode node1 = new ListNode(2);
        head1 = node1;
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(2);
        head2 = node2;
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(7);
        mergeTwoLists(head,head1, head2);
    }
}

package com.chiru.problems;

/**
 * @author Chiranjeevi
 */
public class AddTwoNumbersInLinkedList {
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum;
        int onesPlaceValue;
        ListNode second = l2;
        while (l1.next != null && second.next != null) {
            sum = l1.val + second.val + carry;
            onesPlaceValue = sum % 10;
            carry = sum / 10;
            second.val = onesPlaceValue;
            l1 = l1.next;
            second = second.next;
        }
        if (l1.next == null && second.next == null) {
            sum = l1.val + second.val + carry;
            onesPlaceValue = sum % 10;
            carry = sum / 10;
            second.val = onesPlaceValue;
        }

        if (l1.next != null) {
            sum = l1.val + second.val + carry;
            onesPlaceValue = sum % 10;
            carry = sum / 10;
            second.val = onesPlaceValue;
            l1 = l1.next;
            while (l1.next != null) {
                sum = l1.val + carry;
                onesPlaceValue = sum % 10;
                carry = sum / 10;
                second.next = new ListNode(onesPlaceValue);
                second = second.next;
                l1 = l1.next;
            }
            sum = l1.val + carry;
            onesPlaceValue = sum % 10;
            carry = sum / 10;
            second.next = new ListNode(onesPlaceValue);
            second = second.next;
            if (carry != 0) {
                second.next = new ListNode(carry);
                carry = 0;
                second = second.next;
            }
        }
        if (second.next != null) {
            sum = l1.val + second.val + carry;
            onesPlaceValue = sum % 10;
            carry = sum / 10;
            second.val = onesPlaceValue;
            second = second.next;
            while (second.next != null) {
                sum = second.val + carry;
                onesPlaceValue = sum % 10;
                carry = sum / 10;
                second.val = onesPlaceValue;
                second = second.next;
            }
            sum = second.val + carry;
            onesPlaceValue = sum % 10;
            carry = sum / 10;
            second.val = onesPlaceValue;
            if (carry != 0) {
                second.next = new ListNode(carry);
                carry = 0;
            }
        }
        if (carry != 0) {
            second.next = new ListNode(carry);
        }
        return l2;
    }
}

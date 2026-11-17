package add.two.numbers.with.linked.lists;

import java.math.BigInteger;
import java.util.ArrayList;


/**
 * 2. Add Two Numbers
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode;

        ArrayList<String> listNode1Arr = this.getIntegerArrayListWithAllValues(l1);
        ArrayList<String> listNode2Arr = this.getIntegerArrayListWithAllValues(l2);

        BigInteger sum = new BigInteger(listNode1Arr.reversed().toString().replaceAll("[^0-9]", "")).add(
                new BigInteger(listNode2Arr.reversed().toString().replaceAll("[^0-9]", "")));

        int[] digits = String.valueOf(sum).chars().map(c -> c - '0').toArray();

        if (digits.length == 1) {
            listNode = new ListNode(digits[0]);
            return listNode;
        }


        listNode = new ListNode(digits[digits.length - 1], new ListNode(digits[digits.length - 2]));

        if (digits.length > 2) {
            ListNode next = listNode.next;

            for (int i = digits.length - 3; i >= 0; i--) {
                next.next = new ListNode(digits[i]);
                next = next.next;
            }
        }


        return listNode;
    }

    private ArrayList<String> getIntegerArrayListWithAllValues(ListNode listNode) {
        ArrayList<String> listNodeArr = new ArrayList<>();
        String value;

        while (listNode.next != null) {
            listNodeArr.add(String.valueOf(listNode.val));
            listNode = listNode.next;
        }

        if ((listNode.next == null)) {
            listNodeArr.add(String.valueOf(listNode.val));
        }

        return listNodeArr;
    }
}

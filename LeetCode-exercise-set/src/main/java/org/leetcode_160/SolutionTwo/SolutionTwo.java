package org.leetcode_160.SolutionTwo;

import org.leetcode_160.ListNode;

import java.util.*;

public class SolutionTwo {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> listASet = new HashSet<ListNode>();
        ListNode curA = headA;
        while(curA != null) {
            listASet.add(curA);
            curA = curA.next;
        }
        ListNode curB = headB;
        while(curB != null) {
            if(!listASet.contains(curB)) curB = curB.next;
            else return curB;
        }
        return null;
    }
}

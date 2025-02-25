package org.leetcode_160.SolutionOne;

import org.leetcode_160.ListNode;

public class SolutionOne {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 两链表从头节点处就相交的特殊情况
        if(headA == headB) return headA;
        // 初始化遍历组合链表的指针
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        // 得到组合链表的总长度
        int length = 0;
        while(cur1 != null) {
            length++;
            cur1 = cur1.next;
        }
        while(cur2 != null) {
            length++;
            cur2 = cur2.next;
        }
        // 遍历组合链表
        // 初始化遍历使用的指针
        cur1 = headA;
        cur2 = headB;
        int count = 0;
        // 当遍历未完成且两节点地址不同时进入循环遍历
        while(count <= length && cur1 != cur2) {
            count++;
            if(cur1 == null) cur1 = headB; // cur1 遍历完链表 A 之后切换到链表 B
            else cur1 = cur1.next;
            if(cur2 == null) cur2 = headA; // cur2 遍历完链表 B 之后切换到链表 A
            else cur2 = cur2.next;
        }
        /*遍历完后有两种情况
        * 两链表相交时，指针停在链表相交处
        * 两链表平行的，指针停在null
        * 因此，可通过判断指针是否停在相交处来判断链表的交点是否存在，若存在则返回交点，否则返回 null
        */
        return cur1 == cur2 ? cur1 : null;
    }
}

package repo.LinkedList.lc160;

public class Solution160 {
     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         ListNode ptrA = headA;
         ListNode ptrB = headB;

         boolean isFirstIterA = true;
         boolean isFirstIterB = true;

         while(true) {
             if (ptrA == null || ptrB == null) {
                 return null;
             }
             if (ptrA == ptrB) {
                 return ptrA;
             }

             if (isFirstIterA && ptrA.next == null) {
                 isFirstIterA = false;
                 ptrA = headB;
             } else {
                 ptrA = ptrA.next;
             }
             if (isFirstIterB && ptrB.next == null) {
                 isFirstIterB = false;
                 ptrB = headA;
             } else {
                 ptrB = ptrB.next;
             }

         }

     }
}
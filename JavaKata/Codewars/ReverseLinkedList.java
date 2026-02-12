package Codewars;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
       ListNode tempNode = head;
       ListNode finalNode;
       while(tempNode != null) {
           while (head != null) {
               tempNode = tempNode.next;
           }
           finalNode = tempNode;
           tempNode = null;
           reverseList(head);
           return head;
       }
       return head;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}

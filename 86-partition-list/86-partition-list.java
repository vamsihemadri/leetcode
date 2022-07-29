/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode one = new ListNode(-101);
        ListNode o = one;
        ListNode two = new ListNode(-102);
        ListNode t = two;
        
        while(head!=null){
            ListNode next = head.next;
            if(head.val<x){
                one.next = head;
                one = one.next;
            }else{
                two.next = head;
                two = two.next;
            }
            head = next;
        }
        two.next = null;
        
        one.next = t.next;
        return o.next;
    }
}
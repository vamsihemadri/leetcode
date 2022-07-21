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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode prev = new ListNode(-1);
        ListNode head1 = prev;
        prev.next =head;
        ListNode curr = head;
        
        while(left>1){
            prev = curr;
            curr = curr.next;
            
            left--;
            right--;
        }
        
        ListNode startPrev = prev;
        ListNode revEnd = curr;
        
        ListNode third = null;
        
        while(right>0){
            third = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = third;
            right--;
        }
        
        revEnd.next = curr;
        startPrev.next = prev;
        return head1.next;
        
        
    }
}
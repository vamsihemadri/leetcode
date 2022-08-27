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
    public boolean isPalindrome(ListNode head) {
       
        ListNode fEnd = getEndOfFirstHalf(head);
        
        ListNode second = reverseList(fEnd.next);
        
        ListNode p1 = head;
        ListNode p2 = second;
        
        boolean ans = true;
        
        while(p2!=null){
            if(p1.val==p2.val){
                p1 = p1.next;
                p2 = p2.next;
                continue;
            }else{
                ans = false;
                break;
            }
        }
        
        second = reverseList(second);
        fEnd.next = second;
        return ans;
        
        
    }
    
    private ListNode reverseList(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        
        ListNode next = null;
        while(curr!=null){
            next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    private ListNode getEndOfFirstHalf(ListNode head){
        ListNode slow = head;
        ListNode fast  = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
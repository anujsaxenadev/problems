package recursion;

public class RemoveElementInLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        else if(head.next == null){
            if(head.val == val){
                return null;
            }
            else {
                return head;
            }
        }
        ListNode remainingList = removeElements(head.next, val);
        if(head.val == val){
            return remainingList;
        }
        else {
            head.next = remainingList;
            return head;
        }
    }
}

package recursion;

public class PalindromeList {
    static ListNode root;

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean isPalindrome(ListNode head) {
        root = head;
        return checkPalindromeRecursively(head);
    }

    public static boolean checkPalindromeRecursively(ListNode head){
        if(head == null){
            return true;
        }
        boolean result = checkPalindromeRecursively(head.next) && (root.val == head.val);
        root = root.next;
        return result;
    }
}

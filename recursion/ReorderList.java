package recursion;

public class ReorderList {
    static ListNode root;
    static ListNode startPtr;

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public static boolean reorderListRecursively(ListNode head) {
        if(head == null){
            return false;
        }
        boolean processDone = reorderListRecursively(head.next);
        if(processDone){
            return true;
        }
        if(head == startPtr || head.next == startPtr){
            startPtr.next = null;
            return true;
        }
        head.next = startPtr.next;
        ListNode next = startPtr.next;
        startPtr.next = head;
        startPtr = next;
        return false;
    }

    public static void createList(){
        root = null;
        startPtr = null;
        for(int i = 1; i <= 5; i++){
            if(root == null){
                startPtr = new ListNode(i);
                root = startPtr;
            }
            else {
                startPtr.next = new ListNode(i);
                startPtr = startPtr.next;
            }
        }
        startPtr = null;
    }

    public static void printList(){
        startPtr = root;
        while(startPtr != null){
            System.out.println(startPtr.val);
            startPtr = startPtr.next;
        }
        startPtr = null;
    }

    public static void main(String[] args){
        createList();
        startPtr = root;
        reorderListRecursively(startPtr);
        printList();
    }
}

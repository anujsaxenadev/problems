package recursion;

public class AddTwoNumbers {
    static ListNode l1;
    static ListNode startPtr;
    static ListNode finalList;
    static ListNode finalListPtr;

    public static class Tuple{
        int value;
        boolean needToDelete;

        Tuple(int val, boolean delete) {
            this.value = val;
            this.needToDelete = delete;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode createList(){
        ListNode root = null;
        startPtr = null;
        for(int i = 1; i <= 3; i++){
            int value = (int) (Math.random()*10);
            if(root == null){
                startPtr = new ListNode(value);
                root = startPtr;
            }
            else {
                startPtr.next = new ListNode(value);
                startPtr = startPtr.next;
            }
        }
        startPtr = null;
        return root;
    }

    public static void printList(ListNode root){
        startPtr = root;
        while(startPtr != null){
            System.out.println(startPtr.val);
            startPtr = startPtr.next;
        }
        startPtr = null;
    }
    
    public static void addNumbersRecursively(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null){
            if(carry != 0){
                finalListPtr.next = new ListNode(carry);
                carry = 0;
            }
            return;
        }
        int l1Value = (l1 != null) ? l1.val : 0;
        int l2Value = (l2 != null) ? l2.val : 0;
        int sum = l1Value + l2Value + carry;
        if(sum >= 10){
            carry = 1;
            sum = sum - 10;
        }
        else {
            carry = 0;
        }

        if(finalList == null){
            finalList = new ListNode(sum);
            finalListPtr = finalList;
        }
        else {
            finalListPtr.next = new ListNode(sum);
            finalListPtr = finalListPtr.next;
        }

        addNumbersRecursively(l1 == null ? null : l1.next , l2 == null ? null : l2.next, carry);
    }

    public static void main(String[] args){
        ListNode l1 = createList();
        ListNode l2 = createList();

        printList(l1);
        System.out.println("----------------");
        printList(l2);
        System.out.println("----------------");
        addNumbersRecursively(l1, l2, 0);
        System.out.println("----------------");
        printList(finalList);
    }
}

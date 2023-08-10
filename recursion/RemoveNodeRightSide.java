package recursion;

public class RemoveNodeRightSide {
    static ListNode root;
    static ListNode startPtr;

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

    public static void createList(){
        root = null;
        startPtr = null;
        for(int i = 1; i <= 5; i++){
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
    }

    public static void printList(){
        startPtr = root;
        while(startPtr != null){
            System.out.println(startPtr.val);
            startPtr = startPtr.next;
        }
        startPtr = null;
    }
    
    public static Tuple removeNodeRecursively(ListNode node){
        if(node == null){
            return new Tuple(-1, false);
        }
        else if(node.next == null){
            return new Tuple(node.val, false);
        }
        Tuple rightResult = removeNodeRecursively(node.next);
        if(rightResult.needToDelete){
            node.next = node.next.next;
        }
        if(rightResult.value > node.val){
            return new Tuple(rightResult.value, true);
        }
        else {
            return new Tuple(node.val, false);
        }
    }

    public static void main(String[] args){
        createList();
        printList();
        System.out.println("----------------");
        Tuple rightResult = removeNodeRecursively(root);
        if(rightResult.needToDelete && root != null){
            root = root.next;
        }
        printList();
    }
}

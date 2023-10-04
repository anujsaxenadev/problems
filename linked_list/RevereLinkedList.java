package linked_list;

public class RevereLinkedList {

    public static void main(String args){
    
    }

    Node reverseLinkedListRecursivly(Node headNode){
        if(headNode == null){
            return null;
        }
        else if(headNode.next == null){
            return headNode;
        }
        else if (headNode.next.next == null){
            Node newHeadNode = headNode.next;
            headNode.next.next = headNode;
            headNode.next = null;
            return newHeadNode;
        }
        else {
            Node newHeadNode = reverseLinkedListRecursivly(headNode.next);
            headNode.next.next = headNode;
            headNode.next = null;
            return newHeadNode;
        }
    }
}

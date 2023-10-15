package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> traversalStack = new Stack<>();

        TreeNode currentNode = root;

        while(true){
            if(currentNode != null){
                traversalStack.push(currentNode);
                currentNode = currentNode.left;
            }
            else{
                if(traversalStack.isEmpty()){
                    break;
                }
                else{
                    currentNode = traversalStack.pop();
                    result.add(currentNode.val);
                    currentNode = currentNode.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        
    }
}

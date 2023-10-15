package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrderTraversal {
    static public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> traversalStack = new Stack<>();

        if(root != null){
            traversalStack.push(root);
        }

        while(!traversalStack.isEmpty()){
            TreeNode currentNode = traversalStack.pop();
            result.add(currentNode.val);
            if(currentNode.right != null){
                traversalStack.add(currentNode.right);
            }
            if(currentNode.left != null){
                traversalStack.add(currentNode.left);
            }
        }
        return result;
    }
       
    public static void main(String[] args) {
        
    }
}

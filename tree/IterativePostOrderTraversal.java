package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> traversalStack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        if(root != null){
            traversalStack.push(root);
            while(!traversalStack.isEmpty()){
                TreeNode node = traversalStack.pop();
                resultStack.push(node.val);
                if(node.left != null){
                    traversalStack.push(node.left);
                }
                if(node.right != null){
                    traversalStack.push(node.right);
                }
            }
        }

        while(!resultStack.isEmpty()){
            resultList.add(resultStack.pop());
        }
        return resultList;
    }
    public static void main(String[] args) {
        
    }
}

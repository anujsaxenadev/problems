package tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    private void traverse(TreeNode node, ArrayList<Integer> resultList){
        if(node == null){
            return;
        }
        traverse(node.left, resultList);
        resultList.add(node.val);
        traverse(node.right, resultList);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    public static void main(String[] args) {
        
    }
}

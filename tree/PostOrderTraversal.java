package tree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    private void traverse(TreeNode node, ArrayList<Integer> resultList){
        if(node == null){
            return;
        }
        traverse(node.left, resultList);
        traverse(node.right, resultList);
        resultList.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    public static void main(String[] args) {
        
    }
}

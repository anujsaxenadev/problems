package tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    private static void traverse(TreeNode node, ArrayList<Integer> resultList){
        if(node == null){
            return;
        }
        resultList.add(node.val);
        traverse(node.left, resultList);
        traverse(node.right, resultList);
    }

    static public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(0, null, null);
        preorderTraversal(head);
    }
}

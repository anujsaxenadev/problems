package tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
    private void traverse(TreeNode node, ArrayList<ArrayList<Integer>> resultList, int level){
        if(node == null){
            return;
        }
        if(level >= resultList.size()){
            resultList.add(new ArrayList<>());
        }
        resultList.get(level).add(node.val);
        traverse(node.left, resultList, level + 1);
        traverse(node.right, resultList, level + 1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        traverse(root, result, 0);
        return new ArrayList<>(result);
    }
    public static void main(String[] args) {
        
    }
}

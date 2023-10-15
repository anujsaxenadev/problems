package tree;

public class DepthOfBinaryTree {
    private int findDepth(TreeNode root, int level){
        if(root == null){
            return -1;
        }
        else if(root.left == null && root.right == null){
            return level;
        }
        else{
            int max = 0;
            if(root.left != null){
                max = Math.max(findDepth(root.left, level + 1), max);
            }
            if(root.right != null){
                max = Math.max(findDepth(root.right, level + 1), max);
            }
            return max;
        }
    }
    public int maxDepth(TreeNode root) {
        return findDepth(root, 0) + 1;
    }
    public static void main(String[] args) {
        
    }
}

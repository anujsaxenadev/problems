package tree;

public class DepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        else{
            int lMax = maxDepth(root.left);
            int rMax = maxDepth(root.right);
            return Math.max(lMax, rMax) + 1;
        }
    }
    public static void main(String[] args) {
        
    }
}

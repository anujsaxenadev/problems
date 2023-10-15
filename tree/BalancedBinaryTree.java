package tree;

public class BalancedBinaryTree {
    class BalancedData{
        int height;
        boolean isBalanced;
        BalancedData(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    private BalancedData isBalancedTree(TreeNode root){
        if(root == null){
            return new BalancedData(0, true);
        }
        else if(root.left == null && root.right == null){
            return new BalancedData(1, true);
        }
        else{
            BalancedData lData = isBalancedTree(root.left);
            BalancedData rData = isBalancedTree(root.right);
            if(!lData.isBalanced || !rData.isBalanced){
                return new BalancedData(0, false);
            }
            else{
                if(Math.abs(lData.height - rData.height) <= 1){
                    return new BalancedData(Math.max(lData.height, rData.height) + 1, true);
                }
                else{
                    return new BalancedData(0, false);
                }
            }
        }
    }
    public boolean isBalanced(TreeNode root) {
        return isBalancedTree(root).isBalanced;
    }
    public static void main(String[] args) {
        
    }
}

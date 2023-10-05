package tree;

public class SymmetricTree {
    
    public static void main(String[] args){

    }



    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        else {
            return isMirror(root.left, root.right);
        }
    }

    private boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        else if(left != null && right != null){
            if(left.val != right.val){
                return false;
            }
            else {
                return isMirror(left.left, right.right) && isMirror(left.right, right.left);
            }
        }
        else {
            return false;
        }
    }
}

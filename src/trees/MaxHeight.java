package trees;

public class MaxHeight {

    private int getMaxHeight(TreeNode root,int depth)
    {
        if(root==null)
        {
            return depth;
        }

        return Math.max(getMaxHeight(root.left,depth+1),getMaxHeight(root.right,depth+1));
    }

    public int maxDepth(TreeNode A) {
        return getMaxHeight(A,0);
    }
}

package trees;

public class MinHeight {

    private static int minHeight(TreeNode root,int depth)
    {

        if(root==null)
        {
            return Integer.MAX_VALUE;
        }

        if(root.left==null&&root.right==null)
        {
            return depth+1;
        }



        return Math.min(minHeight(root.left,depth+1),minHeight(root.right,depth+1));

    }

    public static int minDepth(TreeNode A) {
return minHeight(A,0);
    }

    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        //root.left.right = new TreeNode(3);

        System.out.println(minDepth(root));
    }
}

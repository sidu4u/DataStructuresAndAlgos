package trees;

public class MirrorTree {
    static TreeNode B;

    private static void mirror(TreeNode A)
    {

        if(A==null)
        {
            return;
        }

        B = new TreeNode(A.val);

        mirror(A.left);
        mirror(A.right);
    }

    public static void main(String args[])
    {
        TreeNode A= new TreeNode(1);
        A.left=new TreeNode(2);
        A.right=new TreeNode(3);

        B=null;
        mirror(A);
        inorder(B);

    }

    private static void inorder(TreeNode A)
    {
        if(A==null)
        {
            return;
        }

        System.out.println(A.val);
        inorder(A.left);
        inorder(A.right);
    }


}

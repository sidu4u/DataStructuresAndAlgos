package trees;


public class KthSmallestElementInBST {

    int elementCout;
    int returnValue;

    private void kthSmallest(TreeNode root,int k)
    {
        if(root==null)
        {
            return;
        }

        kthSmallest(root.left,k);
        elementCout++;

        if(elementCout==k)
        {
            returnValue = root.val;
        }

        kthSmallest(root.right,k);
    }
}

package trees;

class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

public class TreeLevelLinker {

    private TreeLinkNode getNextLink(TreeLinkNode parent)
    {
        if(parent==null||parent.next==null)
        {
            return null;
        }
        return parent.next.left;
    }

    private void levelLinker(TreeLinkNode root,TreeLinkNode parent)
    {
        if(root==null)
        {
            return;
        }

        // set the childrens
        if(root.left!=null)
        {
            root.left.next=root.right;
        }

        //set urself

        if(root.next==null)
        {
            root.next=getNextLink(parent);
        }

        //call for children

        levelLinker(root.left,root);
        levelLinker(root.right,root);


    }

    public void connect(TreeLinkNode root) {

    }
}

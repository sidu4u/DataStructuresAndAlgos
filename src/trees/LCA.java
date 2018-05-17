package trees;

import java.util.ArrayList;
import java.util.List;

public class LCA {

    private static boolean getNodePath(int lookupValue,TreeNode root,List<Integer> path)
    {
        if(root==null)
        {
            return false;
        }

        path.add(root.val);

        if(root.val==lookupValue)
        {
            return true;
        }

        if(getNodePath(lookupValue,root.left,path)||getNodePath(lookupValue,root.right,path))
        {
            return true;
        }

        path.remove(path.size()-1);
        return false;

    }

    private static int getLCA(List<Integer> path1,List<Integer> path2)
    {


        for(int i =0;i<Math.min(path1.size(),path2.size());i++)
        {
            if(path1.get(i)!=path2.get(i))
            {
                return path1.get(i-1);
            }
        }

        return path1.size()>path2.size()?path2.get(path2.size()-1):path1.get(path1.size()-1);
    }

    private static TreeNode getTree(TreeNode a)
    {
        a= new TreeNode(5);
        a.left=new TreeNode(2);
        a.right=new TreeNode(12);
        a.left.left=new TreeNode(8);
        a.left.right=new TreeNode(11);
        a.right.left=new TreeNode(3);
        a.right.right=new TreeNode(17);

        return a;
    }

    public static void main(String args[]) {
        List<Integer> path1 = new ArrayList<Integer>();
        List<Integer> path2 = new ArrayList<Integer>();
        TreeNode root = null;
        root = getTree(root);

        if (getNodePath(12, root, path1) && getNodePath(17, root, path2)) {
            System.out.println(getLCA(path1, path2));
        } else {
            System.out.println(-1);
        }
    }
}

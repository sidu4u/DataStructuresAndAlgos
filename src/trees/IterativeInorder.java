package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {

    ArrayList<Integer> inorderTraversal;

    private void inorder(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current=root;

        while(current!=null || !stack.isEmpty())
        {

            while (current!=null)
            {
                stack.push(current);
                current=current.left;
            }

            current = stack.pop();
            inorderTraversal.add(current.val);

            current=current.right;


        }

    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        inorderTraversal = new ArrayList<>();
        inorder(A);
        return inorderTraversal;
    }
}

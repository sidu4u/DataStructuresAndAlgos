package trees;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePostOrder {

    ArrayList<Integer> postorderTraversal;

    private void postorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode top = null;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                if (current.right != null) {
                    stack.push(current.right);
                }

                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            if (current.right != null && !stack.isEmpty()&& stack.peek().val == current.right.val) {
                top = stack.pop();
                stack.push(current);
                current = top;
            } else {
                postorderTraversal.add(current.val);
                current = null;
            }

        }

    }

    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        postorderTraversal = new ArrayList<>();
        postorder(A);
        return postorderTraversal;
    }

    public static void main(String args[]) {
        IterativePostOrder iterativePostOrder = new IterativePostOrder();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(iterativePostOrder.postorderTraversal(root));

    }

}

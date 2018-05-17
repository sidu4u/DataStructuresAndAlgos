package trees;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class ZigZagTraversal {


    private void pushLeftToRight(Stack<TreeNode> A, ArrayList<ArrayList<Integer>> zigzagTraversal) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        Stack<TreeNode> nextCall = new Stack<>();
        TreeNode currentElement;

        while (!A.empty()) {
            currentElement = A.pop();
            row.add(currentElement.val);
            if (currentElement.left != null) {
                nextCall.push(currentElement.left);
            }
            if (currentElement.right != null) {
                nextCall.push(currentElement.right);
            }
        }

        zigzagTraversal.add(row);
        if (!nextCall.empty()) {
            pushRightToLeft(nextCall, zigzagTraversal);
        }
    }

    private void pushRightToLeft(Stack<TreeNode> A, ArrayList<ArrayList<Integer>> zigzagTraversal) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        Stack<TreeNode> nextCall = new Stack<>();
        TreeNode currentElement;

        while (!A.empty()) {
            currentElement = A.pop();
            row.add(currentElement.val);
            if (currentElement.right != null) {
                nextCall.push(currentElement.right);
            }
            if (currentElement.left != null) {
                nextCall.push(currentElement.left);
            }
        }

        zigzagTraversal.add(row);
        if (!nextCall.empty()) {
            pushLeftToRight(nextCall, zigzagTraversal);
        }
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

        ArrayList<ArrayList<Integer>> zigzagTraversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);

        pushLeftToRight(stack,zigzagTraversal);

        return zigzagTraversal;
    }
}


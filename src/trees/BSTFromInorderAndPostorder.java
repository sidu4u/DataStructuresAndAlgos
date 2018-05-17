package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;


public class BSTFromInorderAndPostorder {


    private static void correctPostorder(int[] incorrectPostorder, int[] incorrectInorder) {
        int[] correctInorder = Arrays.copyOf(incorrectInorder, incorrectInorder.length);

        sort(correctInorder);

        for (int i = 0; i < incorrectInorder.length; i++) {
            if (incorrectInorder[i] != correctInorder[i]) {
                arraySwap(incorrectPostorder, incorrectInorder[i], correctInorder[i]);
            }
        }

    }

    private static void arraySwap(int[] incorrectPostorder, int first, int second) {
        // swap first with second

        for (int i = 0; i < incorrectPostorder.length; i++) {
            if (incorrectPostorder[i] == first) {
                //replace with second
                incorrectPostorder[i] = second;
            } else if (incorrectPostorder[i] == second) {
                //replace with second
                incorrectPostorder[i] = first;
            }
        }
    }

    private static TreeNode createTree(int[] inorder, int[] postorder, int start, int end) {

        if (start <= end) {
            int nextRootIndexInInorder = findRoot(inorder, postorder, start, end);

            TreeNode root = new TreeNode(inorder[nextRootIndexInInorder]);
            root.left = createTree(inorder, postorder, start, nextRootIndexInInorder - 1);
            root.right = createTree(inorder, postorder, nextRootIndexInInorder + 1, end);

            return root;
        }

        return null;
    }

    private static int findRoot(int[] inorder, int[] postorder, int start, int end) {
        int inorderElementIndexInPostorder = Integer.MIN_VALUE;
        int nextRootIndexInInorder = 0;

        for (int i = start; i <= end; i++) {
            for (int j = 0; j < postorder.length; j++) {
                if (postorder[j] == inorder[i]) {
                    if (
                            inorderElementIndexInPostorder < j) {
                        inorderElementIndexInPostorder = j;
                        nextRootIndexInInorder = i;
                    }
                }
            }

        }
        return nextRootIndexInInorder;
    }

    private static void printPostorder(TreeNode root) {
        if (root == null)
            return;

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.println(root.val);

    }

    public static void main(String args[]) {
        int[] inorder = new int[]{11, 10, 7, 23, 14, 15, 20, 13};
        int[] postorder = new int[]{11, 7, 23, 14, 10, 20, 13, 15};      //7,11,14,13,10,20,23,15


        correctPostorder(postorder, inorder);
        Arrays.sort(inorder);

        TreeNode root = createTree(inorder, postorder, 0, 7);
        printPostorder(root);
    }
}

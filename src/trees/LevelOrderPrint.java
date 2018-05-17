/*
package trees;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public class LevelOrderPrint {

    static int leftMax = Integer.MAX_VALUE;
    static int rightMax = Integer.MIN_VALUE;

    class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.left = null;
            this.right = null;
            this.val = val;
        }

    }


    private static void getWidth(TreeNode a,int left,int right)
    {
        if(left<leftMax)
        {
            leftMax=left;
        }
        if(right>rightMax)
        {
            rightMax=right;
        }

        if(a.left != null  ) {
            if (right == 0) {
                getWidth(a.left, left - 1, right);
            }
            else
            {
                getWidth(a.left, left , right-1);
            }
        }
        if(a.right!=null ) {
            if (left == 0) {
                getWidth(a.right, left, right + 1);
            }
            else
            {
                getWidth(a.right, left+1, right );
            }
        }
    }

    private void levelPrint(TreeNode node,ArrayList<ArrayList<Integer>> dataArray,int left,int right )
    {
        ArrayList<Integer> dataRow;
        if(right==0) {
            if (dataArray.get(left + leftMax) == null) {
                dataRow = new ArrayList<>();
                dataRow.add(node.val);
                dataArray.set(left + leftMax, dataRow);
            } else {
                dataRow = dataArray.get(left + leftMax);
                dataRow.add(node.val);
                dataArray.set(left + leftMax, dataRow);
            }
        }
        else
        {
            if (dataArray.get(right) == null) {
                dataRow = new ArrayList<>();
                dataRow.add(node.val);
                dataArray.set(right, dataRow);
            } else {
                dataRow = dataArray.get(right);
                dataRow.add(node.val);
                dataArray.set(right, dataRow);
            }
        }

        if(node.left != null  ) {
            if (right == 0) {
                getWidth(node.left, left - 1, right);
            }
            else
            {
                getWidth(node.left, left , right-1);
            }
        }
        if(node.right!=null ) {
            if (left == 0) {
                getWidth(node.right, left, right + 1);
            }
            else
            {
                getWidth(node.right, left+1, right );
            }
        }
    }




    public static void main(String args[])
    {
        ArrayList<Integer> data = new ArrayList<>(10);
        data.set(5,1);
        System.out.println(data);

    }

}
*//*



import javax.swing.tree.TreeNode;
import java.util.ArrayList;

*/
/**
 * //Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }*//*

public class Solution {
    static int leftMax = Integer.MAX_VALUE;
    static int rightMax = Integer.MIN_VALUE;

    private static void getWidth(TreeNode a,int left,int right)
    {
        if(left<leftMax)
        {
            leftMax=left;
        }
        if(right>rightMax)
        {
            rightMax=right;
        }

        if(a.left != null  ) {
            if (right == 0) {
                getWidth(a.left, left - 1, right);
            }
            else
            {
                getWidth(a.left, left , right-1);
            }
        }
        if(a.right!=null ) {
            if (left == 0) {
                getWidth(a.right, left, right + 1);
            }
            else
            {
                getWidth(a.right, left+1, right );
            }
        }
    }

    private void levelPrint(TreeNode node,ArrayList<ArrayList<Integer>> dataArray,int left,int right )
    {
        ArrayList<Integer> dataRow;
        if(right==0) {
            if (dataArray.get(left + leftMax) == null) {
                dataRow = new ArrayList<>();
                dataRow.add(node.val);
                dataArray.set(left + leftMax, dataRow);
            } else {
                dataRow = dataArray.get(left + leftMax);
                dataRow.add(node.val);
                dataArray.set(left + leftMax, dataRow);
            }
        }
        else
        {
            if (dataArray.get(right) == null) {
                dataRow = new ArrayList<>();
                dataRow.add(node.val);
                dataArray.set(right, dataRow);
            } else {
                dataRow = dataArray.get(right);
                dataRow.add(node.val);
                dataArray.set(right, dataRow);
            }
        }

        if(node.left != null  ) {
            if (right == 0) {
                getWidth(node.left, left - 1, right);
            }
            else
            {
                getWidth(node.left, left , right-1);
            }
        }
        if(node.right!=null ) {
            if (left == 0) {
                getWidth(node.right, left, right + 1);
            }
            else
            {
                getWidth(node.right, left+1, right );
            }
        }
    }

    private void init(ArrayList<ArrayList<Integer>> dataArray,int size)
    {
        for(int i=0;i<size;i++)
        {
            dataArray.add(new ArrayList<>());
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        getWidth(A);
        init(levels,rightMax-leftMax+1);
        levelPrint(A,levels,0,0);
        return levels;




    }
}
*/

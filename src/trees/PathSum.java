package trees;

import java.util.ArrayList;

public class PathSum {

    private boolean containsSum(TreeNode root,int currentSum,int requiredSum)
    {
        if(root==null)
            return false;

        if(root.right==null&&root.left==null&&currentSum+root.val==requiredSum)
        {
            return true;
        }

        return containsSum(root.left,currentSum+root.val,requiredSum)
        ||containsSum(root.right,currentSum+root.val,requiredSum);
    }

    private void getAllSumPaths(ArrayList<ArrayList<Integer>> allPaths,ArrayList<Integer> currentPath,TreeNode root,int requiredSum,int currentSum)
    {
        if(root==null)
        {  return;}
        else
        {
            currentSum=currentSum+root.val;
            currentPath.add(root.val);
        }

        if(root.right==null&&root.left==null&&currentSum==requiredSum)
        {
            allPaths.add(currentPath);
        }

        getAllSumPaths(allPaths,new ArrayList<>(currentPath),root.left,requiredSum,currentSum);
        getAllSumPaths(allPaths,new ArrayList<>(currentPath),root.right,requiredSum,currentSum);
    }

}

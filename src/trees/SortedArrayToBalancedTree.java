package trees;

import java.util.List;


public class SortedArrayToBalancedTree {

    private TreeNode createBalancedTreeFromSortedArray(List<Integer> dataArray,int start,int end)
    {
        int mid = (start+end)/2;

        if(mid<start||mid>end)
        {
            return null;
        }

        TreeNode root = new TreeNode(dataArray.get(mid));

        if(start!=end) {
            root.left = createBalancedTreeFromSortedArray(dataArray, start, mid - 1);
            root.right = createBalancedTreeFromSortedArray(dataArray, mid + 1, end);
        }

        return root;
    }


}

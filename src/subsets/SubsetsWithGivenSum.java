package subsets;

import java.util.ArrayList;

public class SubsetsWithGivenSum {

    private static int subsetSum(ArrayList<Integer> subset)
    {
        int sum=0;

        for (int i:subset
             ) {
            sum=sum+i;
        }

        return sum;
    }

    //create subsets
    private static int getSubsets(int index,ArrayList<Integer> currentSet,ArrayList<Integer> set,int sum,int count)
    {
        int setSize = set.size();
        if(subsetSum(currentSet)==sum)
        {
            System.out.println(currentSet);
            count++;
        }

        for(int i=index;i<setSize;i++)
        {
            ArrayList<Integer> copyCurrentSet = new ArrayList<Integer>(currentSet);
            copyCurrentSet.add(set.get(i));
            count = getSubsets(i+1,copyCurrentSet,set,sum,count);
        }
        return count;
    }

    public static void main(String args[])
    {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(6);
        set.add(3);
        set.add(4);
        set.add(23);

        System.out.println(getSubsets(0,new ArrayList(),set,28,0));
    }
}

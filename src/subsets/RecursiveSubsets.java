package subsets;

import java.util.ArrayList;

public class RecursiveSubsets {


    private static void recursiveSubsets(ArrayList<ArrayList<Integer>> subsets,
                                  ArrayList<Integer> currentSet,
                                  int iterator,int dataArraySize,int setSize)
    {
        ArrayList<Integer> copyOffCurrentSet = new ArrayList<>(currentSet);
        // base case add currentSet to subsets
        if(currentSet.size()==setSize)
        {
            // add this to subsets
            subsets.add(currentSet);
        }
        else if(iterator<dataArraySize)
        {
            //include
            currentSet.add(iterator);
            recursiveSubsets(subsets,currentSet,++iterator,dataArraySize,setSize);
            //exclude
            recursiveSubsets(subsets,copyOffCurrentSet,iterator,dataArraySize,setSize);
        }

    }

    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> currentSet = new ArrayList<>();

        recursiveSubsets(subsets,currentSet,1,5,2);

        System.out.println(subsets);

    }

}

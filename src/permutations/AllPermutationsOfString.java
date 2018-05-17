package permutations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class AllPermutationsOfString {

    private static ArrayList<Integer> swap(int startIndex,int endIndex,ArrayList<Integer> swapData)
    {
        ArrayList<Integer> copyData = new ArrayList<Integer>(swapData);
        int temp = copyData.get(startIndex);
        copyData.set(startIndex,swapData.get(endIndex));
        copyData.set(endIndex,temp);
        return copyData;
    }


    private static int nextUnigueNumber(ArrayList<Integer> data,int currentIndex)
    {
        int element = data.get(currentIndex);
        while(currentIndex<data.size() && data.get(currentIndex)==element)
        {
            currentIndex++;
        }

        return currentIndex;
    }

    private static void permute(int startIndex,ArrayList<Integer> set,ArrayList<ArrayList<Integer>> permutations)
    {
        if(startIndex==set.size()-1)
        {
         permutations.add(set);
         return;
        }

        for (int iterator = startIndex;iterator<set.size();iterator=nextUnigueNumber(set,iterator))
        {

            permute(startIndex+1, swap(startIndex,iterator,set),permutations);

        }
    }
    private static void permute(ArrayList<Integer> str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(l,i,str);
                permute(str, l+1, r);
                str = swap(l,i,str);
            }
        }
    }

    public static void main(String args[])
    {
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        set.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();

        permute(0,set,permutations);

        //permute(set,0,set.size()-1);
       System.out.println(permutations);

    }
}

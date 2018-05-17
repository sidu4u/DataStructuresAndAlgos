package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AndSum {

    public static void main(String args[])
    {
        int[] a = new int[]{1,2,3,4 };
        System.out.println(subsetAnd(a,-1,1));
    }

    public static int getsubsetAndSum(int[] A) {
        Arrays.sort(A);
        return generateRecursiveSubsets(new ArrayList<>(), -1,A);
    }

    private static int duplicateElementCount(int iterator,int[] dataArray) {
        int startElement = dataArray[iterator];

        while (iterator < dataArray.length && dataArray[iterator] == startElement) {
            iterator++;
        }

        return iterator;
    }

    private static int subsetAndSum(int[] A)
    {

        if(A.length<1)
        {
            return 0;
        }

        int temp = A[0];

        for(int i=1;i<A.length;i++)
        {
            temp = temp&A[i];
        }

        return temp;

    }

    public static int generateRecursiveSubsets(ArrayList<Integer> data, int iterator,int[] dataArray) {

       int sum = subsetAndSum(data.stream().mapToInt(i->i).toArray());


        for(int i = iterator+1;i<dataArray.length;i=duplicateElementCount(i,dataArray))
        {
            data.add(dataArray[i]);
           sum = sum + generateRecursiveSubsets(new ArrayList<>(data) ,i,dataArray);
            data.remove(data.size()-1);
        }

        return sum;

    }

    public static int subsetAnd(int[] data,int it,int sum) {

        if(it>=0) {
        sum = sum & data[it];
        }

        for(int i = it+1;i<data.length;i++)
        {
            sum = sum+subsetAnd(data,i,sum);

        }

        return sum;

    }

}

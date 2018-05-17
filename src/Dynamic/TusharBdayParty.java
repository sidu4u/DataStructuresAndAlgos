package Dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TusharBdayParty {

    private static int minCostForFriend(int capacityOfFriend,int[] fillingCapacityOfDish,int[] dishCost)
    {
        int[][] dataMatrix = new int[fillingCapacityOfDish.length][capacityOfFriend+1];

        for(int[] temp:dataMatrix)
        {
            Arrays.fill(temp,Integer.MAX_VALUE);
        }

        for(int i=0;i<fillingCapacityOfDish.length;i++)
        {
            for(int j=0;j<=capacityOfFriend;j++)
            {
                if(j!=0) {
                    if (i == 0) {
                        //only one dish is present then select that only
                        if (fillingCapacityOfDish[i] < j) {
                            dataMatrix[i][j] = dishCost[i];
                        }

                    } else {
                        if (fillingCapacityOfDish[i] > j) {
                            // exclude this
                            dataMatrix[i][j] = dataMatrix[i - 1][j];
                        } else {
                            //find the max
                            dataMatrix[i][j] = Math.min(dataMatrix[i - 1][j],
                                    dishCost[i] +dataMatrix[i - 1][j - fillingCapacityOfDish[i]]);
                        }

                    }
                }
            }
        }

        return dataMatrix[fillingCapacityOfDish.length-1][capacityOfFriend-1];
    }

    public static int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {

        int totalCost = 0;

        for (int friendCapacity:A
             ) {
            totalCost=totalCost+minCostForFriend(friendCapacity,B.stream().mapToInt(i->i).toArray(),C.stream().mapToInt(i->i).toArray());

        }

        return totalCost;
    }

    public static void main(String args[])
    {
        Integer[] a = new Integer[]{ 2, 3, 1, 5, 4 };
        Integer[] b = new Integer[]{ 3, 2, 4, 1};
        Integer[] c = new Integer[]{ 1, 2, 5, 10 };

        solve(Arrays.asList(a),Arrays.asList(b),Arrays.asList(c));

    }
}

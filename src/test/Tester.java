package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Tester {
    static ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
    public static void main()
    {
        int[][] dp = new int[permutations.size()][];
        int i=0,j=0;
        for(ArrayList<Integer> temp :permutations)
        {
            j=0;

            for(Integer a:temp)
            {

                dp[i][j]=a;
                j++;
            }
            i++;
        }
    }
}

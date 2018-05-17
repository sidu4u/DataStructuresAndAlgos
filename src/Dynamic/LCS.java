package Dynamic;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LCS {

    private static int[][] longestCommonSubsequenceStringGenerator(int[] input1,int[] input2)
    {
        int[][] data = new int[input1.length+1][input2.length+1];
       for(int i=0;i<=input1.length;i++)
       {
           for(int j=0;j<=input2.length;j++)
           {
               if(i==0||j==0)
               {
                   data[i][j]=0;
               }
               else if(input1[i-1]==input2[j-1])
               {
                   data[i][j]=data[i-1][j-1]+1;
               }
               else
               {
                   data[i][j]=Math.max(data[i-1][j],data[i][j-1]);
               }
           }
       }

       return data;
    }

    private static void findLongestCommonSubsequence(int[][] data,int[] input1,int[] input2,int i,int j,List<Integer> sequence)
    {
        if(i<1||j<1)
        {
            return;
        }

       if(input1[i-1]==input2[j-1])
       {
           sequence.add(input1[i-1]);
           findLongestCommonSubsequence(data,input1,input2,i-1,j-1,sequence);
       }
       else if(data[i-1][j]>data[i][j-1])
       {
           findLongestCommonSubsequence(data,input1,input2,i-1,j,sequence);
       }
       else
       {
           findLongestCommonSubsequence(data,input1,input2,i,j-1,sequence);
       }



    }

    static int[] longestCommonSubsequence(int[] a, int[] b) {
        // Complete this function
        List<Integer> sequence = new ArrayList<>();

        findLongestCommonSubsequence(longestCommonSubsequenceStringGenerator(a,b),a,b,a.length,b.length,sequence);
        Collections.reverse(sequence);
        return sequence.stream().mapToInt(i->i).toArray();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int[] result = longestCommonSubsequence(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}

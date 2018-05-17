package Dynamic;

public class Knapsack {

   /* knapsack(w,k)=

    {
        if (w(k) > w) {
            // if the wait of item greater than the total weight
            knapsack(w, k - 1)
        }
        else
        {
            // select the last item once and not select the last item once : find the max of these two
            max(knapsack(w,k-1),knapsack(w-w(k),k-1))
        }

    }*/


   private static int[][]  generateKnapsackMatrix(int totalWeight,int[] weights,int[] values)
   {
       int[][] dataMatrix = new int[weights.length][totalWeight];
        int nextvalue=0;

       for(int i=0;i<weights.length;i++)
       {
           for(int j=0;j<totalWeight;j++)
           {
               if(j!=0) {
               if (i == 0) {
                       //only one element is present then select that only
                       if (weights[i] < totalWeight) {
                           nextvalue = values[i];
                       }

                   } else {
                       if (weights[i] > totalWeight) {
                           nextvalue = dataMatrix[i - 1][j];
                       } else {
                           nextvalue = Math.max(dataMatrix[i - 1][j], values[i] + dataMatrix[i - 1][j - weights[i]]);
                       }

                   }
                   dataMatrix[i][j] = nextvalue;
               }


           }
       }

       return dataMatrix;
   }
}

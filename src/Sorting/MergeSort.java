package Sorting;

public class MergeSort {

    public static void main(String args[])
    {
        int[] data = new int[]{2,8,12,-3,6,5,8,-45,108,53,22,34,8};
        mergeSort(data,0,12);
        for (int i:data
             ) {
            System.out.println(i);
        }
    }

    private static void mergeSort(int[] data,int start,int end)
    {
        if(start<end)
        {
            int mid = (start+end)/2;

            mergeSort(data,start,mid);
            mergeSort(data,mid+1,end);
            merge(data,start,end,mid);
        }


    }

    private static void merge(int[] data,int start,int end ,int mid)
    {
        int[] auxArray = new int[end-start+1];
        int left = start;
        int right = mid+1;
        int auxIndex = 0;

        while(left<=mid&&right<=end)
        {
            if(data[left]<data[right])
            {
                auxArray[auxIndex] = data[right];
                right++;
            }
            else
            {
                auxArray[auxIndex] = data[left];
                left++;
            }
            auxIndex++;
        }

        while(left<=mid)
        {
            auxArray[auxIndex] = data[left];
            left++;
        }

        while(right<=end)
        {
            auxArray[auxIndex] = data[right];
            right++;
        }

        auxIndex=0;
        for(int i=start;i<=end;i++,auxIndex++)
        {
            data[i]=auxArray[auxIndex];
        }
    }
}

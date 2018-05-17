package Sorting;

public class QuickSort {

public static void main(String args[])
{
    int[] data = new int[]{2,8,12,-3,6,5,8,-45,108,53,22,34,8};
    quickSort(data,0,12);
    for (int i:data
            ) {
        System.out.println(i);
    }

}

private static void quickSort(int[] data,int start,int end)
{

    if(start<end)
    {
        int partitionIndex =partition(data,start,end);
        quickSort(data,start,partitionIndex-1);
        quickSort(data,partitionIndex+1,end);
    }


}

private static int partition(int[] data,int start,int end)
{
    int pivot = data[end];
    int partitionIndex = start;
    int temp;

    for(int i=start;i<=end;i++)
    {
        if(data[i]<pivot)
        {
            temp = data[i];
            data[i]=data[partitionIndex];
            data[partitionIndex]=temp;
            partitionIndex++;
        }
    }
    data[end]=data[partitionIndex];
    data[partitionIndex]=pivot;

    return partitionIndex;
}
}

package subsets;

import java.util.ArrayList;
import java.util.Collections;

public class RecursiveSubsetsWithDuplicates {
    ArrayList<ArrayList<Integer>> subsets;
    ArrayList<Integer> dataArray;

    public static void main(String args[]) {
        RecursiveSubsetsWithDuplicates recursiveSubsetsWithDuplicates = new RecursiveSubsetsWithDuplicates();

        ArrayList<Integer> dataToPass = new ArrayList<>();
        dataToPass.add(1);
        dataToPass.add(2);
        dataToPass.add(2);
        dataToPass.add(3);
        dataToPass.add(3);
        dataToPass.add(4);

        System.out.println(recursiveSubsetsWithDuplicates.subsetsWithDup(dataToPass));

    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        this.subsets = new ArrayList<>();
        Collections.sort(A);
        this.dataArray = A;
        generateRecursiveSubsets(new ArrayList<>(), -1);
        return this.subsets;
    }

    private int duplicateElementCount(int iterator) {
        int startElement = dataArray.get(iterator);

        while (iterator < dataArray.size() && dataArray.get(iterator) == startElement) {
            iterator++;
        }

        return iterator;
    }

    public void generateRecursiveSubsets(ArrayList<Integer> data, int iterator) {

        if (iterator >= dataArray.size()) {
            return;
        }

        this.subsets.add(new ArrayList<>(data));

        for(int i = iterator+1;i<dataArray.size();i=duplicateElementCount(i))
        {
            data.add(dataArray.get(i));
            generateRecursiveSubsets(new ArrayList<>(data) ,i);
            data.remove(data.size()-1);
        }

    }
}

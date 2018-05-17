package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum2 {
    // stores the element and its index
    Map<Integer, Integer> array;

    // this method populates the hashmap with the closest index in array

    private void populateHashMap(List<Integer> arrayToHash) {
        int currentArrayElement;
        for (int currentArrayElementIndex = 0; currentArrayElementIndex < arrayToHash.size(); currentArrayElementIndex++
                ) {
            currentArrayElement = arrayToHash.get(currentArrayElementIndex);
            if (this.array.get(currentArrayElement) == null) {
                //add this to the map
                this.array.put(currentArrayElement, currentArrayElementIndex);

            }
        }
    }

    private ArrayList<Integer> twoSum(final List<Integer> A, int B) {

        ArrayList<Integer> data = new ArrayList<Integer>();
        this.array = new HashMap<Integer, Integer>();
        populateHashMap(A);

        for (int currentElementIndex=0;currentElementIndex<A.size();currentElementIndex++) {

            if (this.array.get(B - A.get(currentElementIndex)) != null)
            {
                data.add(currentElementIndex);
                data.add(this.array.get(B - A.get(currentElementIndex)) );
            }

        }

        return data;
    }

}

package Greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {

    private int maximalCountInMap(HashMap<Integer,Integer> elementCount)
    {
        int maximalCount = Integer.MIN_VALUE;
        for (Map.Entry<Integer,Integer> entry:elementCount.entrySet())
        {
            if(entry.getValue()>maximalCount)
            {
                maximalCount=entry.getKey();
            }
        }

        return maximalCount;
    }

    private HashMap<Integer,Integer> createElementCountMap(List<Integer> data)
    {
        HashMap<Integer,Integer> dataMap = new HashMap<>();

        for(Integer currentElement:data)
        {
            if(dataMap.get(currentElement)==null)
            {
                //add
                dataMap.put(currentElement,1);
            }
            else {
                dataMap.put(currentElement,dataMap.get(currentElement)+1);
            }
        }

        return dataMap;
    }

    public int majorityElement(final List<Integer> A) {


        return maximalCountInMap(createElementCountMap(A));
    }
}

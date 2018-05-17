package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DistributeCandy {

    private Map<Integer,Integer> getElementCount(ArrayList<Integer> A)
    {
        Map<Integer,Integer> elementCount = new HashMap<>();
        int currentElementCount;

        for (Integer currentElement:A)
        {
            currentElementCount=0;
            if(elementCount.get(currentElement)==null)
            {
                //add it
                elementCount.put(currentElement,++currentElementCount);
            }
            else
            {
                currentElementCount=elementCount.get(currentElement);
                elementCount.put(currentElement,++currentElementCount);
            }
        }

        return elementCount;
    }

    public int candy(ArrayList<Integer> A) {

        Map<Integer,Integer> elementCount = getElementCount(A);
        Collections.sort(A);
        int evenSum=0,oddSum=0;
        int sumOfStartAndEndElement = A.get(0)+2*A.get(A.size()-1);


        for(int i=1;i<A.size()-1;i++)
        {
            if(i%2==0)
            {
                evenSum=evenSum+2*elementCount.get(A.get(i));
                oddSum=oddSum+elementCount.get(A.get(i));
            }
            else
            {
                oddSum=oddSum+2*elementCount.get(A.get(i));
                evenSum=evenSum+elementCount.get(A.get(i));
            }

        }

        return Math.max(evenSum,oddSum)+sumOfStartAndEndElement;

    }

}

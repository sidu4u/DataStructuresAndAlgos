package strings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;



/*this code is incomplete*/


public class Versions {

    public static int compareVersion(String A, String B) {

        int it=0;
        List<String> versionsA= Arrays.asList(A.split("\\."));
        List<String> versionsB= Arrays.asList(B.split("\\."));

        Stack<BigInteger> numbersA = new Stack<>();
        Stack<BigInteger> numbersB = new Stack<>();

        for (String number:versionsA
             ) {
            numbersA.add(new BigInteger(number));

        }

        for (String number:versionsB
                ) {
            numbersB.add(new BigInteger(number));

        }

        while(numbersA.size()>it && numbersB.size()>it)
        {
            if(numbersA.get(it).compareTo(numbersB.get(it))==1)
            {
                return 1;
            }
            if(numbersA.get(it).compareTo(numbersB.get(it))==-1)
            {
                return -1;
            }
            it++;
        }

        if(it==numbersA.size()&&it==numbersB.size())
        {
            return 0;
        }

        if(it<numbersA.size()&&it>=numbersB.size())
        {
            return 1;
        }


            return -1;


    }

    public static void main(String args[])
    {

        System.out.println(compareVersion("13.0","13.0.8.9.8"));
    }
}

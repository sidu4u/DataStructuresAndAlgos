package Greedy;

import java.util.ArrayList;

public class Bulbs {
        public int bulbs(ArrayList<Integer> A) {
        int count=0;

        for (Integer current:A)
        {
            if(count%2==0)
            {

                if(current==0)
                {
                    // it remains same hence on it
                    count++;
                }
            }
            else
            {

                if(current==1)
                {
                    // it was on now its off hence switch it on
                    count++;
                }
            }


        }

        return count;


        }

}

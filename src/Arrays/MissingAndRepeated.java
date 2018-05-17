package Arrays;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MissingAndRepeated {

        private static BigInteger getAminusB (List<Integer> A)
        {
            BigInteger aMinusB=BigInteger.valueOf(0);

            for(int i=1;i<=A.size();i++)
            {
                aMinusB = aMinusB.add(BigInteger.valueOf(i).subtract(BigInteger.valueOf(A.get(i))));
            }

            return aMinusB;
        }

        private static BigDecimal getAbyB (List<Integer> A)
        {
            BigDecimal abyB=BigDecimal.valueOf(1);

            for(int i=1;i<=A.size();i++)
            {
                abyB = abyB.multiply(BigDecimal.valueOf(i).divide(BigDecimal.valueOf(A.get(i))));
            }

            return abyB;
        }

        public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {

            BigInteger repeated=  getAminusB(A).divide(getAbyB(A).subtract(BigDecimal.valueOf(1)).toBigInteger());                      //b=(a-b)/(a/b)-1

            BigInteger missing =  getAminusB(A).add(repeated);                            //a-b+b

            ArrayList<Integer> returnData=new ArrayList<Integer>();

            returnData.add( repeated.intValue());
            returnData.add(missing.intValue());
            return returnData;
        }

        public static void main(String args[])
        {
            repeatedNumber(List.of(1,2,2));
        }
}

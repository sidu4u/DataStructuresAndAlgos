package strings;

public class ATOI {
    public static void main(String args[])
    {

        System.out.println(atoi("-5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393"));

    }

    private static int getIntValue(char currentChar)
    {
        switch (currentChar)
        {
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
        }

        return 10;
    }

    public static int atoi(final String A) {

        boolean isNegative=false;
        int currentInt;
        int iterator=0;
        int intValueOfString=0;
        char[] charValuesOfString = A.trim().split(" ")[0].toCharArray();

        if(charValuesOfString==null)
        {
            return 0;
        }

        if(charValuesOfString[0]=='-')
        {
            isNegative=true;
            iterator=1;
        }

        if(charValuesOfString[0]=='+')
        {
            iterator=1;
        }

        for(;iterator<charValuesOfString.length;iterator++)
        {
            currentInt = getIntValue(charValuesOfString[iterator]);

            if(currentInt == 10 )
            {
                break;
            }

            else {

             if(intValueOfString<0 || intValueOfString >Integer.MAX_VALUE/10) // check overflow due to multiplication and addition
             {
                if(isNegative)
                {
                    return Integer.MIN_VALUE;
                }

                return Integer.MAX_VALUE;
             }

                intValueOfString = intValueOfString*10 +currentInt;
            }
        }

        return isNegative?intValueOfString*-1:intValueOfString;
    }
}

package strings;

/*this class decodes the string using the median values
*
* wrien  - erwin
* reen   - eren
*
* */

public class MedianDecode {

private static String decode(String encodedString)
{
    int length = encodedString.length();
    char[] charString = encodedString.toCharArray();
    String decodedString="";
    boolean toogle=true;
    if(length%2==0)
    {
        // even length string
        for (int i=0;i<encodedString.length();i++) {
            if (!toogle) {
                decodedString = decodedString + charString[i];

            }
            else
            {
                decodedString = charString[i]+decodedString;
            }

            toogle=!toogle;
        }
    }
    else
    {
        for (int i=0;i<encodedString.length();i++) {
            if (!toogle) {
                decodedString = charString[i]+decodedString;

            }
            else
            {
                decodedString = decodedString + charString[i];
            }
            toogle=!toogle;
        }
    }

    return decodedString;
}

public static void main(String args[])
{
    System.out.println(decode("reen"));
}


}

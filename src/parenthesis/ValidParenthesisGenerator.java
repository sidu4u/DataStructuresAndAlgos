package parenthesis;

import java.util.ArrayList;

public class ValidParenthesisGenerator {
    ArrayList<String> validParenthesis = new ArrayList<>();

    public static void main(String args[])
    {
        ValidParenthesisGenerator validParenthesisGenerator = new ValidParenthesisGenerator();
        validParenthesisGenerator.validParenthesis("{",1,0,3);
        System.out.println(validParenthesisGenerator.validParenthesis);
    }

    private void validParenthesis(String currentString ,int openBracketCount,int closeBracketCount,int size)
    {
        if(openBracketCount+closeBracketCount == 2*size)
        {
            validParenthesis.add(currentString);
        }
        else {
                if(openBracketCount<size)
                {
                    //add one more
                    validParenthesis(currentString+"{" , openBracketCount+1, closeBracketCount, size);
                }
                if(openBracketCount>closeBracketCount)
                {
                    //add close
                    validParenthesis(currentString+"}",openBracketCount,closeBracketCount+1,size);
                }

        }
    }

}

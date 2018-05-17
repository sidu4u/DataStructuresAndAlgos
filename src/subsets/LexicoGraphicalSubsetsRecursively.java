package subsets;

import java.util.ArrayList;

public class LexicoGraphicalSubsetsRecursively {

    ArrayList<String> lexicalSubsets = new ArrayList<>();

    public static void main(String args[])
    {
         LexicoGraphicalSubsetsRecursively lexicoGraphicalSubsetsRecursively = new LexicoGraphicalSubsetsRecursively();
         lexicoGraphicalSubsetsRecursively.lexoRecursiveSubsets("",-1,4,"abcd");
        System.out.println(lexicoGraphicalSubsetsRecursively.lexicalSubsets);
    }

    private void lexoRecursiveSubsets(String currentString, int index, int size, String set)
    {
        if(index == size)
        {
            return;
        }

        lexicalSubsets.add(currentString);

        for(int iterator = index+1;iterator<size;iterator++)
        {

            lexoRecursiveSubsets( currentString+set.charAt(iterator),iterator,size,set);

        }


    }

}

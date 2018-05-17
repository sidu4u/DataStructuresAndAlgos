package Dynamic;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class LongestPallindromicSubstring {

   /* this can be solved by using longest common substring
   * the second string should be the reverse of the first string
   *
   *
   * LCS(x,y) = if(a[x]==b[y])
   *            {
   *               LCS(x,y)=LCS(x-1,y-1)+1;
   *            }
   *            else
   *            {
   *                LCS(x,y)=0;
   *            }
   * */

   private static String LCS(String first,String second)
   {
       int[][] data = new int[first.length()+1][second.length()+1];
       int maxValue = Integer.MIN_VALUE;
       int maxValueIindex=Integer.MIN_VALUE;
       int maxValueJindex=Integer.MIN_VALUE;

       for(int i=1;i<=first.length();i++)
       {
           for(int j=1;j<=second.length();j++)
           {
               if(first.charAt(i-1)==second.charAt(j-1))
               {
                   data[i][j]=data[i-1][j-1]+1;
                   if(data[i][j]>maxValue)
                   {
                       maxValue = data[i][j];
                       maxValueIindex = i;
                       maxValueJindex = j;
                   }
               }

           }
       }

       // find the maxvalue
       Stack<Character> temp = new Stack<>();
       while(maxValueIindex>0&&maxValueJindex>0 && data[maxValueIindex][maxValueJindex]>0&& data[maxValueIindex][maxValueJindex] > data[maxValueIindex-1][maxValueJindex-1])
       {

           temp.push(first.charAt(maxValueIindex-1));
           maxValueIindex--;
           maxValueJindex--;
       }

       StringBuilder build = new StringBuilder();

       while (!temp.empty())
       {
           build.append(temp.pop());
       }

       return build.toString();
   }

   public static void main(String args[])
   {
Scanner scan = new Scanner(System.in);
String first = scan.next();
String second = new StringBuilder(first).reverse().toString();

       System.out.println(LCS(first,second));
   }
}

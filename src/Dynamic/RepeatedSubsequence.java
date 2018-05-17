package Dynamic;

 /* RepeatedSubsequence(a)=LCS(A,A)

     under the condition that you cannot match a character to itself

    RSS(a) = if(a[i]==b[j] && i!=j){
                    // match with someother character
                    data[i][j] = data[i-1][j-1]+1;
                else
                {
                data[i][j] = max(data[i-1][j],data[i][j-1]);
                }

    }

    */


public class RepeatedSubsequence {
    public int anytwo(String A) {
        int[][] data = new int[A.length() + 1][A.length() + 1];
        char[] sequence = A.toCharArray();

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= A.length(); j++) {

                if (sequence[i - 1] == sequence[j - 1] && i != j) {

                    data[i][j] = data[i - 1][j - 1] + 1;

                } else {

                    data[i][j] = Math.max(data[i - 1][j], data[i][j - 1]);

                }

                if( data[i][j] >=2)
                {
                    return 1;
                }
            }
        }

        return 0;

    }

    public static void main(String args[]) {

    }

}

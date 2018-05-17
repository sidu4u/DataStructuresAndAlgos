import java.math.BigInteger;
import java.util.ArrayList;

public class TestBigInteger {

    public static void main(String args[]) {

        System.out.println(generateSets(4,2));
    }

    private static ArrayList<ArrayList<Integer>> generateSets(int A, int B) {
        BigInteger zero = BigInteger.valueOf(0);
        BigInteger one = BigInteger.valueOf(1);
        BigInteger subsets = one.shiftLeft(A);
        BigInteger it = BigInteger.valueOf(0);
        ArrayList<ArrayList<Integer>> allSets = new ArrayList<>();
        ArrayList<Integer> set;


        for (; it.compareTo(subsets) == -1; it=it.add(one)) {
            set = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                if (it.and(one.shiftLeft(j)).compareTo(zero) == 1) {
                    set.add(j+1);
                }

            }
            if (set.size() == B) {
                allSets.add(set);
            }
        }

        return allSets;
    }
}

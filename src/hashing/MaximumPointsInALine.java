package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumPointsInALine {

    public static void main(String args[]) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(-2);
        b.add(0);
        a.add(-1);
        b.add(3);

        System.out.println( maxPoints(a,b));
    }

    private static float getSlope(int x1, int x2, int y1, int y2) {
        return (y2 - y1) / (x2 - x1);
    }

    public static int maxPoints(List<Integer> a, List<Integer> b) {
        int maxPoints = 0;
        int pointCountForCurrentSlope;
        Map<Float, Integer> pointsPerSlope;
        int x1, x2, y1, y2;
        float slope;

        for (int outerIterator = 0; outerIterator < a.size(); outerIterator++) {
            x1 = a.get(outerIterator);
            y1 = b.get(outerIterator);
            pointsPerSlope = new HashMap<>();
            for (int innerIterator = outerIterator + 1; innerIterator < a.size(); innerIterator++) {
                pointCountForCurrentSlope = 1;

                x2 = a.get(innerIterator);
                y2 = b.get(innerIterator);


                // calculate slope
                slope = getSlope(x1, x2, y1, y2);
                if (pointsPerSlope.get(slope) == null) {
                    pointCountForCurrentSlope++;
                    pointsPerSlope.put(slope, pointCountForCurrentSlope);
                } else {
                    pointCountForCurrentSlope = pointsPerSlope.get(slope);
                    pointCountForCurrentSlope++;
                    pointsPerSlope.put(slope, pointCountForCurrentSlope);

                }

                if (pointCountForCurrentSlope > maxPoints) {
                    maxPoints = pointCountForCurrentSlope;
                }


            }
        }
        return maxPoints;
    }
}

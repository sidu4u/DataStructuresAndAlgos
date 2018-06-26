package trees;

import java.util.*;

public class DiameterOfNarrayTree {

    static int diameter = -1;
    //If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this
    //            0
    //          / | \
    //         1  2  3
    //                \
    //                 4


    private static void getAdjList(List<Integer> parents,Map<Integer,List<Integer>> adjList,int root)
    {
        List<Integer> children = getChildern(root,parents);
        adjList.put(root,children);

        for (int currentChild:children
             ) {
            getAdjList(parents,adjList,currentChild);
        }
    }


    private static List<Integer> getChildern(int parent, List<Integer> parents) {
        // return all the indexes that have the value as parent
        List<Integer> children = new ArrayList<>();

        for (int i = 0; i < parents.size(); i++
                ) {
            if (parents.get(i) == parent) {
                children.add(i);
            }
        }

        return children;

    }

    private static int getDiameter(Map<Integer,List<Integer>> adjList, int root) {
        // for each child recurr this method
        // each child returns its maximum height
        // diameter:max + 2nd max +1

        int diameterAtThisNode = -1;
        List<Integer> childHeights = new ArrayList<>();

        for (Integer child : adjList.get(root)
                ) {
            childHeights.add(getDiameter(adjList, child));
        }

        if (childHeights.size() ==0) {
            diameter=diameter<1?1:diameter;
            return 1;
        }

        if(childHeights.size() ==1)
        {
            diameter = childHeights.get(0)+1>diameter?childHeights.get(0)+1:diameter;
            return childHeights.get(0)+1;
        }

        Collections.sort(childHeights);

        diameterAtThisNode = childHeights.get(childHeights.size() - 1) + childHeights.get(childHeights.size() - 2) + 1;

        diameter = diameterAtThisNode > diameter ? diameterAtThisNode : diameter;

        return childHeights.get(childHeights.size() - 1) + 1;
    }

    public static void main(String[] args) {

        Map<Integer,List<Integer>> adjList = new HashMap<>();
        getAdjList(Arrays.asList(-1),adjList,-1);

        getDiameter(adjList,-1);

        System.out.println(diameter-1);
    }
}

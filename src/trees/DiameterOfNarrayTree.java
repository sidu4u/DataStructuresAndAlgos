package trees;

import java.util.*;

public class DiameterOfNarrayTree {
    //If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this
    //            0
    //          / | \
    //         1  2  3
    //                \
    //                 4


    private static List<Integer>  getChildern(int parent,List<Integer> parents)
    {
         // return all the indexes that have the value as parent
          List<Integer> children = new ArrayList<>();

        for (int i=0;i<parents.size();i++
             ) {
            if(parents.get(i)==parent)
            {
                children.add(i);
            }
        }

        return children;

    }

    private static int getDiameter(List<Integer> parents,int root)
    {
        // for each child recurr this method
        Set<Integer> children = new SortedSet<Integer>() {
            @Override
            public Comparator<? super Integer> comparator() {
                return null;
            }

            @Override
            public SortedSet<Integer> subSet(Integer fromElement, Integer toElement) {
                return null;
            }

            @Override
            public SortedSet<Integer> headSet(Integer toElement) {
                return null;
            }

            @Override
            public SortedSet<Integer> tailSet(Integer fromElement) {
                return null;
            }

            @Override
            public Integer first() {
                return null;
            }

            @Override
            public Integer last() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        }

        for (Integer child:getChildern(root,parents)
             ) {

        }
    }
}

package hashing;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
     int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

public class CopyList {

    private RandomListNode linearListCopy(RandomListNode node,Map<Integer,RandomListNode> nodeReference)
    {
        // copy linearly and store hashMap
        RandomListNode head=null,iterator;
        if(node!=null)
        {
            head = new RandomListNode(node.label);
            head.next=null;
            head.random =null;

            node=node.next;
        }
        iterator = head;
        nodeReference.put(head.label,head);

        while(node!=null)
        {
            iterator.next = new RandomListNode(node.label);
            iterator=iterator.next;
            iterator.next=null;
            iterator.random=null;

            nodeReference.put(iterator.label,iterator);
            node=node.next;
        }
        return head;
    }

    private void assignRandomPointers(RandomListNode originalHead,
                                      RandomListNode copyListHead,Map<Integer,RandomListNode> nodeReferences)
    {
        RandomListNode originalListIterator=originalHead,copyListIterator=copyListHead;

        while(originalListIterator!=null) {

            if (originalHead.random != null) {
                copyListIterator.random = nodeReferences.get(originalListIterator.random.label);

            }
            else
            {
                copyListIterator.random = null;
            }

            originalListIterator=originalListIterator.next;
            copyListIterator = copyListIterator.next;
        }

    }

    public RandomListNode copyRandomList(RandomListNode head) {

        Map<Integer,RandomListNode> nodeReferences = new HashMap<>();
        RandomListNode copyListHead = linearListCopy(head,nodeReferences);
        assignRandomPointers(head,copyListHead,nodeReferences);
        return copyListHead;
    }
}

package LinkedLists;

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }

public class CopyList {

    private void duplicateNextNode(RandomListNode current)
    {
        RandomListNode next=null;

        while(current!=null)
        {
            next = current.next;

            current.next=new RandomListNode(current.label);
            current.next.next=next;
            current=next;
        }

    }

    private void assignRandomPoiters(RandomListNode current)
    {
        RandomListNode next=null;

        while(current!=null)
        {

            current.next.random=current.random==null?null:current.random.next;
            current=current.next.next;
        }

    }

    private RandomListNode seperateLists(RandomListNode current)
    {
        RandomListNode head = current.next;
        RandomListNode next = head;

        while (current!=null)
        {
            current.next = next.next;
            current=current.next;
            next.next=current.next==null?null:current.next;
            next=next.next==null?null:next.next;
        }

        return head;
    }

    public RandomListNode copyRandomList(RandomListNode head) {

       duplicateNextNode(head);
       assignRandomPoiters(head);

       return seperateLists(head);
    }
}

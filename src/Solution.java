
 class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }


public class Solution {

    private static ListNode reverse(ListNode A)
    {
        System.out.println("inside reverse");
        int length = findLength(A);
        ListNode previous,current,next;

        if(length==1)
        {
            return null;
        }
        else if(length==2)
        {
            return A.next;
        }
        else
        {
            previous = A.next;
            current=previous.next;
            next=current.next;
            previous.next = null;

            while(current!=null)
            {
                current.next=previous;
                previous=current;
                current=next;
                next = next!=null?next.next:null;
            }

            return previous;
        }
    }

    private static int findLength(ListNode A)
    {
        int length =0;

        while(A!=null)
        {
            length++;
            A=A.next;
        }

        return length;
    }

    /*private int subtractOffset(ListNode A,int offset)
    {

        int value=A.val;

        while(offset>0)
        {
            offset--;
            A=A.next;
        }

        return A.val-value;
    }*/

    public static ListNode subtract(ListNode A) {

        System.out.println("inside subtract");
        ListNode left=A,right,savedListReference=A;
        int listLength = findLength(A);
        int halfLength = listLength%2==0?(listLength/2)-1:listLength/2;
        /*int offset = listLength-1;*/

        for(int i=0;i<halfLength;i++)
        {

            A=A.next;
        }

        A.next = reverse(A);
        System.out.println("reversed");
        right = A.next;

        while(right!=null)
        {
            left.val = right.val-left.val;
            right=right.next;
            left=left.next;
        }
        return savedListReference;
    }

    public  static void main(String args[])
    {
        //make a list
        int temp = 2;
        int count = 1;
        ListNode listNode = new ListNode(count);
        ListNode store = listNode;

        while(temp>0)
        {
             listNode.next = new ListNode(++count);
             listNode = listNode.next;
             temp--;
        }


        listNode.next=null;

        subtract(store);

    }
}

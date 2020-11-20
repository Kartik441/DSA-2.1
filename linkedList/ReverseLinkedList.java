package linkedList;


public class ReverseLinkedList {
	static void reverse(LinkedList list)
	{
		LNode prevNode,currNode,nextNode;
		prevNode=null;
		currNode=list.head;
		while(currNode!=null)
		{
			nextNode=currNode.next;     // because of this we will not lose next node
			currNode.next=prevNode;     
			prevNode=currNode;
			currNode=nextNode;
			
		}
		list.head=prevNode;
		
	}
	public static void main(String []args)
	{
		
		LinkedList list=new LinkedList();
		
		list.insert(1);
		list.insert(2);
	    list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		
		
		LinkedList.printList(list.head);
		
	   reverse(list);
	   LinkedList.printList(list.head);
	}
	

}

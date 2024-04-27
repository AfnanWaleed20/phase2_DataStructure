package application;

	//this class to node of doublelinked list thats contains a data 
	public class Node {
		Brand element;
		Linkedlist list=new Linkedlist();
		Node next;
		Node prev;
	    
	      
	public Node(Object x) {
	element=(Brand) x;
	}

	public Node() {
		super();
		
	}


	public Linkedlist getList() {
		if (list == null) {
			return new Linkedlist();
		}
		else
		return list;
	}

	public void setList(Linkedlist list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Node [element=" + element + ", next=" + next + "]";
	}


	}



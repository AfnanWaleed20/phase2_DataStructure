package application;

public class Queue {
	Order_list list2 = new Order_list();

	public Queue() {

	}
	
	

	public boolean isEmpty()
	{
		return (list2.isEmptyQ());
	}
	
	
	public void enqueue (Orders order) {
		list2.insertFirstQ(order);
	}
	
	public Orders dequeue() {
		return list2.deleteLastQ();
	}



	public boolean isEmpty2()

	{
		return (list2.isEmptyQ());
	}
}

package application;


public class Stack {
		private Order_list list3= new Order_list();

		public void push(Orders costamers)
		{
			list3.insertFirstS(costamers);
		}
		
		
		public Orders pop()
		{
			return (list3.deleteFirstS());
		}
		public boolean isEmpty() {
			return (list3.isEmptyS());
		}

}

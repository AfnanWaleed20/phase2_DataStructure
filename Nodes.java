package application;
	public class Nodes {
		
			Cars element;
		      Nodes next;
		     
		      
		public Nodes(Cars x) {
		element=x;
		}


		public Nodes() {

		}


		public Cars getElement() {
			return element;
		}


		public void setElement(Cars element) {
			this.element = element;
		}


		@Override
		public String toString() {
			return "Node [element=" + element + ", next=" + next + "]";
		}
		}




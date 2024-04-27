package application;
	public class Order_list {
	    private Onode StackrNode;
	    private Onode queueNode;
	    
	   
		Order_list(){
	    	
	    }


		public Order_list(Onode stackrNode, Onode queueNode) {
			super();
			StackrNode = stackrNode;
			this.queueNode = queueNode;
		}


		public Onode getStackrNode() {
			return StackrNode;
		}


		public void setStackrNode(Onode stackrNode) {
			StackrNode = stackrNode;
		}


		public Onode getQueueNode() {
			return queueNode;
		}


		public void setQueueNode(Onode queueNode) {
			this.queueNode = queueNode;
		}

		public boolean isEmptyQ() {
			return (queueNode == null);
		}
		
		public void insertFirstQ(Orders data) {
			Onode newNode = new Onode(data);
	        if (queueNode == null) {
	        	queueNode = newNode;
	        } else {
	        	newNode.next=(queueNode);
	            queueNode = newNode;
	        }
	    }
		
		
		
		
		
		public Orders deleteLastQ() // delete last item
		{
			Orders temp;
		    Onode current = queueNode;
		 if (queueNode == null)
		      return null;
		 
		 if (queueNode.next == null)
		 {
		      temp = queueNode.getData();
		      queueNode = null;
		      return (temp);
		}
		 
		while (current.next.next != null)
		     current = current.next;
		   temp = current.next.getData();
		   current.setNext(null);;
		   return temp;
		}
		
		
		
		
		
		
		public void insertFirstS(Orders data) {
			Onode newNode = new Onode(data);
	        if (StackrNode == null) {
	        	StackrNode = newNode;
	        } else {
	        	newNode.setNext(StackrNode);
	        	StackrNode = newNode;
	        }
	    }
		
		public Orders deleteFirstS() {
			if(StackrNode != null) {
				Onode temp = StackrNode;
				StackrNode = StackrNode.next;
				return temp.getData();
				
			}
			else 
				return null;
		
		}

		public boolean isEmptyS() {
			return (StackrNode == null);
		}
		
	}



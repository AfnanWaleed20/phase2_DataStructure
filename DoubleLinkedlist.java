package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DoubleLinkedlist {
		private Node first;
		private Node last;
		private int count;

		public DoubleLinkedlist() {
			super();
		}

		public Node getFirst() {
			if (count == 0)
				return null;
			else
				return first;

		}

		public Object getLast() {
			if (count == 0)
				return null;
			else
				return last.element;
		}

		public void addFirst(Object x) {
			if (count == 0)
				first = last = new Node(x);
			else {
				Node temp = new Node(x);
				first.prev = temp;
				temp.next = first;
				first = temp;
			}
			count++;

		}

		public Node addLast(Object x) {
			if (count == 0)
				first = last = new Node(x);
			else {
				Node temp = new Node(x);
				temp.prev = last;
				last.next = temp;
				last = temp;
			}
			count++;
	return last;
		}

		public void add(Object x, int index) {
			if (index == 0)
				addFirst(x);
			if (index >= count)
				addLast(x);
			else {
				Node temp = new Node(x);
				Node current = first;
				for (int i = 0; i < index; i++) {
					current = current.next;
					temp.next = current;
					temp.prev = current.prev;
					current.prev = temp;
					(temp.prev).next = temp;
					temp.next = current.next;
					current.next = temp;
				}
				count++;

			}
		}

		public boolean removeFirst() {
			if (count == 0)
				return false;
			else if (count == 1)
				first = last = null;
			else
				first = first.next;
			first.prev = null;
			count--;
			return true;

		}

		public boolean removeLast() {
			if (last == null)
				return false;
			else if (count == 1)
				first = last = null;
			else {
				Node current = first;
				for (int i = 0; i < count - 1; i++) {
					last = current.prev;
					last = null;

				}

				count--;
			}
			return true;
		}
		// this method to show all martyr information in the location you select
				 public void textArea(Brand brandName) { 
			    	 Stage stage = new Stage(); // create a new stage 
			    	 TextArea textArea = new TextArea(); // create a new TextArea
			    	 GridPane pane = new GridPane (); 
					 Button back = new Button ("Back");  // this button to back to a before screen 
					 StringBuilder stringBuilder = new StringBuilder(); // StringBuilder to save all information 
					 
					 textArea.setMinWidth(600);
					 textArea.setMaxHeight(500);


			    	 pane.setAlignment(Pos.CENTER);
			    	 pane.add(textArea, 0, 0);
			    	 pane.add(back, 3, 7);
			         Font newFont = ((Font.font("Time New Roman" , FontWeight.BOLD , FontPosture.ITALIC ,15)));

						if (search(brandName) != null) { // if the location is exist
						Nodes curr2 = search(brandName).getList().getFirst() ; // first node in single list
						 
					     	for ( ; curr2 != null ; curr2 = curr2.next) { // for loop to get information from each node  
					     		 stringBuilder.append(curr2.element.toString()).append("\n"); // and the information to stringBuilder
					     		textArea.setText(stringBuilder.toString());	// Add all information to a text Area as string 
					     		textArea.setFont(newFont);
						}
						
					     	
						}
						
						else {
							textArea.setText(" The given Brand is Not found "); // if the location does not exist
						}
				     
						 back.setOnAction(e->{ // back button action 
							 Main main = new Main();
						//	main.adminStage();
							 
						 });
						 Scene scene = new Scene(pane , 700 , 600); // create a new scene 
						 stage.setScene(scene); // add the scene to the stage 
						 stage.setTitle("Report for Location "); // set a title to  the stage 
						 stage.show();
						
			    	 
			    	 }
		public boolean remove(int index) {
			if (index == 1) {
				if (count == 1) {
					first = last = null;
					count = 0;
					return true;
				}
				first = first.next;
				first.prev = null;
				count--;
				return true;
			}
			if (index == count) {
				last = last.prev;
				last.next = null;
				count--;
			}
			Node temp = first.next;
			for (int i = 2; i <= count; i++) {
				if (i == index) {
					Node p = temp.prev;
					Node n = temp.next;
					p.next = n;
					n.prev = p;
					count--;
					return true;
				}
				temp = temp.next;
			}
			return true;
		}	
				
	//this method to remove location from your list
		public void removeobj(Brand element) {
			if (first == null) {
	            return;
	        }

	        Node current =first;

	        
	        while (current != null && !current.element.getBrand().equals(element.getBrand())) {
	            current = current.next;
	        }

	        if (current == null) {
	            return; 
	        }

	        if (current == first) {
	            first = current.next;
		}
	        if (current.prev != null) {
	            current.prev.next = current.next; 
	        }

	        if (current.next != null) {
	            current.next.prev = current.prev; 
	        }
	    }
		
		
		
	//this method to make a insert and sort to double linked  list
		public Node insertAndSort(Brand point) {
		    Node newNode = new Node(point);
		    if (first == null) {
		        first = last = newNode;
		        count++;
		        return newNode;
		    } else if (first.element.getBrand().compareTo(point.getBrand()) >= 0) {
		        newNode.next = first;
		        first.prev = newNode;
		        first = newNode;
		        count++;
		        return newNode;

		    } else if (last.element.getBrand().compareTo(point.getBrand()) >= 0) {
		        return addLast(point);
		    } else {
		        Node current = first;

		        while (current.next != null && current.next.element.getBrand().compareTo(point.getBrand()) < 0) {
		            current = current.next;
		            
		        }
		        
		        newNode.next = current.next;
		        if (current.next != null) {
		            newNode.next.prev= newNode;
		            
		        }
		        current.next = newNode;
		        newNode.prev = current;
		        count++;
		        return newNode;
		    }
		}
		// this method to search in linked list to find the object
		public Node search(Brand brand) {
			Node current = first;
			if (current == null) {
				return null;
			} else {
				while (current != null) {
					if (current.element.getBrand().trim().equalsIgnoreCase(brand.getBrand().trim())){
						return current;
					}
					current = current.next;
				}
			}
			return null;
		}
	//this method to make a update to location
		public void update(String oldBrand, String newBrand) {
			Node current = first;
			Node index = current.next;
			while (current != null) {
				if (current.element.getBrand().equals(oldBrand)) {
					current.element.setBrand(newBrand);
				
				}
				current = current.next;
			}
		}
	//this method to print the data
		public void printList() {
			if (count == 0) {
				System.out.print("empty");
				return;
			}
			if (first.next == null) {
				System.out.println(first.element);
				return;
			}
			Node temp = first;
			System.out.println(first.element + " ");
			temp = first.next;
			while (temp.next != null) {
				System.out.print(temp.element + " ");
				temp = temp.next;
			}
			System.out.print(temp.element);
		
		}

	}



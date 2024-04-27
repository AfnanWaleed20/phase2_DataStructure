package application;

public class Linkedlist {
	private Nodes first;
	private Nodes last;
	private int count;

	public Linkedlist() {

	}

	public Nodes getFirst() {
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

	public void addFirst(Orders x) {
		if (count == 0)
			first = last = new Nodes(x);
		else {
			Nodes temp = new Nodes(x);
			temp.next = first;
			first = temp;
		}
		count++;

	}

	public void addLast(Orders x) {
		if (count == 0)
			first = last = new Nodes(x);
		else {
			Nodes temp = new Nodes(x);
			last.next = temp;
			last = temp;
		}
		count++;

	}

	public Nodes search(String brand, String model, int year, String color, Double price) {
		Nodes curent = first;
		while (curent != null) {

			if (curent.element.getBrand().trim().equalsIgnoreCase(brand.trim())
					&& curent.element.getModel().trim().equalsIgnoreCase(model.trim())
					&& curent.element.getYear() == (year) && curent.element.getColor().equals(color)
					&& curent.element.getPrice() == (price)) {
				return curent;

			} else {
				curent = curent.next;
			}
		}
		return null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

//to insert and sort to my list 
	public void addAndSort(Cars data) {
		Nodes newNode = new Nodes(data);
		if (first == null || data.getYear() - (first.element.getYear()) < 0) {
			newNode.next = first;
			first = newNode;
			count++;
		} else {
			Nodes current = first;
			while (current.next != null && data.getYear() - (current.next.element.getYear()) >= 0) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			count++;
		}
	}

	public Nodes searhName(String name) {
		Nodes current = first;
		if (current == null)
			return null;
		while (current != null) {
			if (name.equals(current.getElement().getModel())) {
				return current;

			}
			current = current.next;
		}
		return null;

	}

	public Nodes searhYear(int year) {
		Nodes current = first;
		if (current == null)
			return null;
		while (current != null) {
			if (year == (current.getElement().getYear())) {
				return current;

			}
			current = current.next;
		}
		return null;

	}

	public Nodes searhcolor(String color) {
		Nodes current = first;
		if (current == null)
			return null;
		while (current != null) {
			if (color.equals(current.getElement().getColor())) {
				return current;

			}
			current = current.next;
		}
		return null;

	}

	public Nodes searhprice(double price) {
		Nodes current = first;
		if (current == null)
			return null;
		while (current != null) {
			if (price == (current.getElement().getPrice())) {
				return current;

			}
			current = current.next;
		}
		return null;

	}

	public Nodes removeFirst() {
		if (first == null) {
			return null;
		}

		Nodes removedData = first;
		first = first.next;
		return removedData;

	}

	public boolean removeLast() {
		if (last == null)
			return false;
		else if (count == 1)
			first = last = null;
		else {
			Nodes current = first;
			for (int i = 0; i < count - 2; i++) {
				current = current.next;
				last = current;
				current.next = null;
			}

		}
		count--;
		return true;
	}

//this method to remove Cars
	public boolean remove(Cars element) {
		Nodes previous = first;
		Nodes current;
		if (first != null) {
			if (element.getModel().equals(first.element.getModel())) {
				if (first == last)
					first = last = first.next;
				else
					first = first.next;
				count--;
				return true;
			} else
				current = first.next;
		}

		else
			return false;
		for (int i = 0; i < count - 1; i++) {
			if (element.getModel().equals(current.element.getModel())) {
				previous.next = current.next;
				count--;
				return true;
			} else
				previous = current;
			current = current.next;
		}
		return false;
	}

	public Nodes searchList(Cars obj) {
		Nodes current = first;
		while ((current != null) && (current.element.equals(obj)))
			current = current.next;
		return current;

	}

	@Override
	public String toString() {
		return "Linkedlist [first=" + first + ", last=" + last + ", count=" + count + "]";
	}

	public String getLinkedListAsString() {
		StringBuilder sb = new StringBuilder();
		Nodes currentNode = first;
		while (currentNode != null) {
			sb.append(currentNode.element).append(" ");
			currentNode = currentNode.next;
		}
		return sb.toString().trim();
	}

	public void delete(Cars data) {
		if (first == null) {
			// Linked list is empty, nothing to delete
			return;
		}

		Nodes curr = first;
		Nodes prev = null;

		while (curr != null) {
			if (curr.element.getModel().trim().equalsIgnoreCase(data.getModel().trim())
					&& curr.element.getColor().trim().equalsIgnoreCase(data.getColor().trim())
					&& curr.element.getBrand().trim().equalsIgnoreCase(data.getBrand().trim())
					&& curr.element.getPrice() == data.getPrice() && curr.element.getYear() == data.getYear()) {

				if (prev != null) {
					prev.next = curr.next;
				} else {
					first = curr.next;
				}

				return;
			}

			prev = curr;
			curr = curr.next;
		}
	}

	public void print() {
		Nodes curr = first;

		while (curr != null) {
			System.out.println(curr.element + " ");
			curr = curr.next;
		}
	}

}

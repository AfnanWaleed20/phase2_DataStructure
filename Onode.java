package application;

public class Onode {
	Orders data;
    Onode next;
   
    
public Onode(Orders x) {
data=x;
}


public Onode() {

}


public Orders getData() {
	return data;
}


public void setData(Orders element) {
	this.data= data;
}


@Override
public String toString() {
	return "Node [element=" + data + ", next=" + next + "]";
}


public Onode getNext() {
	return next;
}


public void setNext(Onode next) {
	this.next = next;
}




}



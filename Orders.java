package application;

public class Orders extends Cars {
private String customerName;
private int customerNumber;
private String orderDate;
private String orderStatut;
public Orders() {
	super();
	
}

public Orders(String customerName, int customerNumber,String brand, String model, int year, String color, Double price, String orderDate, String orderStatut) {
	super(brand,model, year, color,price);
	this.customerName = customerName;
	this.customerNumber = customerNumber;
	this.orderDate = orderDate;
	this.orderStatut = orderStatut;
}

public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public long getCustomerNumber() {
	return customerNumber;
}
public void setCustomerNumber(int customerNumber) {
	this.customerNumber = customerNumber;
}

public String getOrderDate() {
	return orderDate;
}
public void setOrderDate(String orderDate) {
	this.orderDate = orderDate;
}
public String getOrderStatut() {
	return orderStatut;
}
public void setOrderStatut(String orderStatut) {
	this.orderStatut = orderStatut;
}

@Override
public String toString() {
	return "" + customerName + " , " + customerNumber+" , "+ super.getBrand()+" , "+ super.getModel()+" , "+ super.getColor()+" , "
             + super.getYear()+ " ,"+orderDate + "  , " +super.getPrice() + " , "+ getOrderStatut()	;
}

}

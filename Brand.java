package application;

public class Brand {
String brand;

public Brand() {
	super();
	// TODO Auto-generated constructor stub
}

public Brand(String brand) {
	super();
	this.brand = brand;
}

public String getBrand() {
    return brand != null ? brand : "";
}
public void setBrand(String brand) {
	this.brand = brand;
}

}

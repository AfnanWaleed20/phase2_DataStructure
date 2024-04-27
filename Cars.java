package application;

public class Cars extends Brand{
private String model;
private int year;
private String color;
private Double price;


public Cars() {
	super();
}


public Cars(String brand, String model) {
	super(brand);
	this.model = model;
}


public Cars(String brand, String model, int year, String color, Double price) {
	super(brand);
	this.model = model;
	this.year = year;
	this.color = color;
	this.price = price;
}



public String getModel() {
	return model;
}


public void setModel(String model) {
	this.model = model;
}


public int getYear() {
	return year;
}


public void setYear(int year) {
	this.year = year;
}


public String getColor() {
	return color;
}


public void setColor(String color) {
	this.color = color;
}


public Double getPrice() {
	return price;
}


public void setPrice(Double price) {
	this.price = price;
}


@Override
public String toString() {
	return (brand+","+ model+","+year+","+color+","+price);
}

}

package Practice_POJO_Deserialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataClass 
{
private String color;
@JsonProperty("capacity GB")
private String capacityGB;
private double price;
private String Capacity;
@JsonProperty("Screen size")
private String screenSize;
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getCapacityGB() {
	return capacityGB;
}
public void setCapacityGB(String capacityGB) {
	this.capacityGB = capacityGB;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getCapacity() {
	return Capacity;
}
public void setCapacity(String capacity) {
	Capacity = capacity;
}
public String getScreenSize() {
	return screenSize;
}
public void setScreenSize(String screenSize) {
	this.screenSize = screenSize;
}

}

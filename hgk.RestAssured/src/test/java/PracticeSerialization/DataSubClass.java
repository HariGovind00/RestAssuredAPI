package PracticeSerialization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataSubClass 
{
	
	private int year;
	private double price;
	@JsonProperty("CPU model")
	private String cpumodel;
	@JsonProperty("Hard disk size")
	private String hardDiskSize;
	
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCpumodel() {
		return cpumodel;
	}
	public void setCpumodel(String cpumodel) {
		this.cpumodel = cpumodel;
	}
	public String getHardDiskSize() {
		return hardDiskSize;
	}
	public void setHardDiskSize(String hardDiskSize) {
		this.hardDiskSize = hardDiskSize;
	}
	
}

	
	

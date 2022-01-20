package com.mobilesalesapp.model;

public class ProductPojo {
	private int id;

	public ProductPojo(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductPojo(int id, double standard_cost, double list_cost) {
		super();
		this.id = id;
		this.standard_cost = standard_cost;
		this.list_cost = list_cost;
	}

	private String product_name;
	private String description;
	private double standard_cost;
	private double list_cost;

	@Override
	public String toString() {
		return "AddProductDao [product_name=" + product_name + ", description=" + description + ", standard_cost="
				+ standard_cost + ", list_cost=" + list_cost + "]";
	}

	public ProductPojo(String product_name, String description, double standard_cost, double list_cost) {
		super();
		this.product_name = product_name;
		this.description = description;
		this.standard_cost = standard_cost;
		this.list_cost = list_cost;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getStandard_cost() {
		return standard_cost;
	}

	public void setStandard_cost(double standard_cost) {
		this.standard_cost = standard_cost;
	}

	public double getList_cost() {
		return list_cost;
	}

	public void setList_cost(double list_cost) {
		this.list_cost = list_cost;
	}

}

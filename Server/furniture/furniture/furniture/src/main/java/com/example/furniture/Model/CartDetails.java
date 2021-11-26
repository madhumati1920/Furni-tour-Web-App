package com.example.furniture.Model;

public class CartDetails {
	String productImage;
	String productname;
	int productprice;
	int qty;
	int price;
	int total;
	int productid;
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	@Override
	public String toString() {
		return "CartDetails [productImage=" + productImage + ", productname=" + productname + ", productprice="
				+ productprice + ", qty=" + qty + ",price=" +price + ", total=" + total
				+ ", productid=" + productid + "]";
	} 
	public CartDetails(String productImage, String productname, int productprice, int orderqty, int orderprice,
			int total, int productid) {
		super();
		this.productImage = productImage;
		this.productname = productname;
		this.productprice = productprice;
		this.qty = qty;
		this.price = price;
		this.total = total;
		this.productid = productid;
	}
	public CartDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}

package com.kh.practice.list.library.model.vo;

import java.util.Objects;

public class Book implements Comparable<Object>{
	private String title;
	private String auther;
	private String category;
	private int price;
	
	public Book() {
		
	}
	public Book(String title, String auther, String category,int price) {
		this.title= title;
		this.auther= auther;
		this.category= category;
		this.price= price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", auther=" + auther + ", category=" + category + ", price=" + price + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(auther, other.auther) && Objects.equals(category, other.category) && price == other.price
				&& Objects.equals(title, other.title);
	}
	
	@Override
	public int compareTo(Object b) {
		if(this.title.compareTo(((Book)b).title)>=1) return 1;
		else if (this.title.compareTo(((Book)b).title)<=-1) return -1;
		return 0;
		
	}
}

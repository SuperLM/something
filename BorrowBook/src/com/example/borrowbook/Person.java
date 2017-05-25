package com.example.borrowbook;

public class Person {
	private String name;
	private String sex;
	private int age;
	private String borrowTime;
	private Book book;
	
	public Person(){
		
	}
	
	public Person(String name,String sex,int age,String borrowTime,Book book){
		this.setBook(book);
		this.setName(name);
		this.setSex(sex);
		this.setAge(age);
		this.setBorrowTime(borrowTime);
	}
	
	public String getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public String toString() {

		return "    借书人："+name+"   性别: "+sex+"    年龄："+age+"    借书时间： "+borrowTime;
	}
}

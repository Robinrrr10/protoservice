package com.github.protoservice.entities;

import java.util.List;

public class User {

	private int id;
	private String name;
	private float salary;
	private List<String> siblings;
	private Account account;
	private List<Marks> marks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public List<String> getSiblings() {
		return siblings;
	}
	public void setSiblings(List<String> siblings) {
		this.siblings = siblings;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	
}

package com.ssafy.bigstep.model.dto;


public class User {
	String id;
	String pw;
	String name;
	
	String address; // 차후 고려 (시, 구, 동 나눌지 안나눌지)
	
	String UID;		// 네이버 고유 식별자
	
	int height;
	int weight;
	int age;
	
	
	
	public User(String id, String pw, String name, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
	}
	
	
	public User(String id, String pw, String name, String address, int height, int weight, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.height = height;
		this.weight = weight;
		this.age = age;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + ", address=" + address + ", UID=" + UID
				+ ", height=" + height + ", weight=" + weight + ", age=" + age + "]";
	}
	
}

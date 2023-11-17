package com.ssafy.bigstep.model.dto;


public class User {
	String id;
	String pw;
	String name;
	
	String nickname;
	
	String email;
	String phone;
	String address; // 차후 고려 (시, 구, 동 나눌지 안나눌지)
	
	String UID;		// 네이버 고유 식별자
	
	int height;
	int weight;
	int age;
	
	int gender;
	
	boolean isPublic;
	
	
	public User() {}

	

	public User(String id, String pw, String name, String nickname, String email, String phone, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public User(String id, String pw, String name, String nickname, String email, String phone, String address,
			String uID, int height, int weight, int age, int gender) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		UID = uID;
		this.height = height;
		this.weight = weight;
		this.age = age;
		this.gender = gender;
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

	public String getNickname() {
		return nickname;
	}
	
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	public int getGender() {
		return gender;
	}
	
	
	public void setGender(int gender) {
		this.gender = gender;
	}

	
	public boolean isPublic() {
		return isPublic;
	}


	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + ", nickname=" + nickname + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", UID=" + UID + ", height=" + height + ", weight="
				+ weight + ", age=" + age + ", gender=" + gender + ", isPublic=" + isPublic + "]";
	}
}

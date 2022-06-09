package br.com.college.model;

import java.util.Date;
import java.util.Objects;

public class Student {
	private int id;	
	private String name;
	private int age;
	private Date birthDate;
	private String address;
	private Long phone;
	private String email;
	
	
	public Student() {
		super();
	}


	public Student(int id, String name, int age, Date birthDate, String address, Long phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthDate = birthDate;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}


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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Long getPhone() {
		return phone;
	}


	public void setPhone(Long phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", birthDate=" + birthDate + ", address="
				+ address + ", phone=" + phone + ", email=" + email + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(address, age, birthDate, email, id, name, phone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}
	
	
	
}

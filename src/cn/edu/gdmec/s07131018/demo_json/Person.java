package cn.edu.gdmec.s07131018.demo_json;

import java.util.List;

public class Person {
	public String name;
	public int age;
	public List<String> phones;
	public Person(String name, int age, List<String> phones) {
		super();
		this.name = name;
		this.age = age;
		this.phones = phones;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", phones=" + phones
				+ "]";
	}
	
}

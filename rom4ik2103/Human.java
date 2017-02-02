package ru.bk.rom4ik2103;

public class Human {
	private String name;
	private String surName;
	private int age;
	private double weight;
	private String sex;

	public Human(String name, String surName, int age, double weight, String sex) {
		super();
		this.name = name;
		this.surName = surName;
		this.age = age;
		this.weight = weight;
		this.sex = sex;
	}

	public Human() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String humanInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t Human Info:");
		sb.append("\n\t Name - " + name);
		sb.append("\n\t Surname - " + surName);
		sb.append("\n\t Age - " + age);
		sb.append("\n\t Weight - " + weight);
		sb.append("\n\t Sex - " + sex);
		return sb.toString();

	}
}

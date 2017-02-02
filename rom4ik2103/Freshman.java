package ru.bk.rom4ik2103;

public class Freshman extends Human{
	private double schoolProgress;
	private boolean captain = false;
	private boolean presence = false;
	public Freshman(String name, String surName, int age, double weight, String sex, double schoolProgress) {
		super(name, surName, age, weight, sex);
		this.schoolProgress = schoolProgress;
	}
	public Freshman() {
		super();
	}
	public double getSchoolProgress() {
		return schoolProgress;
	}
	public void setSchoolProgress(double schoolProgress) {
		this.schoolProgress = schoolProgress;
	}
	public boolean isCaptain() {
		return captain;
	}
	public void setCaptain(boolean captain) {
		this.captain = captain;
	}
	public boolean isPresence() {
		return presence;
	}
	public void setPresence(boolean presence) {
		this.presence = presence;
	}
	
	
	@Override
	public String humanInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t Sudent Info:");
		sb.append("\n\t Name - " + getName());
		sb.append("\n\t Surname - " + getSurName());
		sb.append("\n\t Age - " + getAge());
		sb.append("\n\t Sex - " + getSex());
		sb.append("\n\t Progress - " + schoolProgress);
		if(captain == true){
		sb.append("\n\t Captain " );
		}else{
			sb.append("\n\t ");
		}
		
		return sb.toString();
	}
	
	

}

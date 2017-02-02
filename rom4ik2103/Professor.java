package ru.bk.rom4ik2103;

import java.util.Scanner;

public class Professor extends Human {
 private String rank;

public Professor(String name, String surName, int age, double weight, String sex, String rank) {
	super(name, surName, age, weight, sex);
	this.rank = rank;
}

public Professor() {
	super();
}

public String getRank() {
	return rank;
}

public void setRank(String rank) {
	this.rank = rank;
}

//проверка посещаемости студентами группы
public void presenceActivity(IPresence presence){
	int atTheLesson = 0;
	int notAtTheLesson = 0;
	Freshman [] studentArray = presence.getFreshmanArray();
	Scanner sc = new Scanner(System.in);
	StringBuilder sb = new StringBuilder();
	sb.append("Checking attending by "+ getName()+System.lineSeparator());
	System.out.println(" When Teacher calle your surname and you are present in the classroom\n"
				+ "print \"Yes\" or if you aren`t present - \"No\"");
	for (int i = 0; i < studentArray.length; i++) {
		
		System.out.println(studentArray[i].getSurName());
			try {
				String answer = sc.nextLine().toUpperCase();
				if (answer.equals("YES")) {
					studentArray[i].setPresence(true);
					atTheLesson += 1;
				}else{
					notAtTheLesson+=1;
				}
			} catch (NullPointerException e) {
				e.getMessage();
			}

		}
	sb.append("There are "+ atTheLesson + " students are at the lesson\n"
			+ "There are " + notAtTheLesson +" students are absent");
	
	sc.close();
	System.out.println(sb.toString());
	
}

@Override
public String humanInfo() {
	StringBuilder sb = new StringBuilder();
	sb.append("\t Professor Info:");
	sb.append("\n\t Name - " + getName());
	sb.append("\n\t Surname - " + getSurName());
	sb.append("\n\t Age - " + getAge());
	sb.append("\n\t Sex - " + getSex());
	sb.append("\n\t Rank - " + rank);
	return sb.toString();
}
 
}

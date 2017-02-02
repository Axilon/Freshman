package ru.bk.rom4ik2103;

public class Main {

	public static void main(String[] args) {
		Group group = new Group();
		try {
			group.addStudent(new Freshman("Lora", "Kostromichova", 19, 45.3, "female", 95.2));
			group.addStudent(new Freshman("Doran", "Kyky", 19, 45.3, "male", 90.2));
			group.addStudent(new Freshman("Sofa", "Soska", 17, 40.3, "female", 98.2));
			group.addStudent(new Freshman("Many", "Fyfoska", 25, 50.3, "female", 85.2));
			group.addStudent(new Freshman("Dima", "Ivasishun", 26, 83.3, "male", 60.2));
			group.addStudent(new Freshman("Klara", "Brykva", 18, 45.3, "female", 95.2));
			group.addStudent(new Freshman("Roma", "Super", 28, 99.3, "male", 75.2));
			group.addStudent(new Freshman("Morgana", "Kortneva", 77, 40.3, "female", 60.2));
			group.addStudent(new Freshman("Svetogor", "Kosterov", 88, 67.3, "male", 99.2));
			group.addStudent(new Freshman("Lora", "Kostromichova", 19, 45.3, "female", 95.2));

		} catch (MyException e) {

			e.getMessage();
		}
		group.chooseCaptain();
		System.out.println(group.toString());
		Professor prof = new Professor("Petr","Zelinskiy",45,73.2,"male","Professor");
		prof.presenceActivity(group);
	}

}

package ru.bk.rom4ik2103;

public class Group implements IPresence {
	private String groupName;
	private Freshman[] studentArray = new Freshman[10];

	public Group(String groupName, Freshman[] studentArray) {
		super();
		this.groupName = groupName;
		this.studentArray = studentArray;
	}

	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Freshman[] getStudentArray() {
		return studentArray;
	}

	public void setStudentArray(Freshman[] studentArray) {
		this.studentArray = studentArray;
	}
 //добавление студента в группу
	public void addStudent(Freshman student) throws MyException {
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i] == null) {

				studentArray[i] = student;
				break;
			} else if (i == (studentArray.length - 1) && studentArray[studentArray.length - 1] != null)
				throw new MyException();

		}
	}
	//удаление студента из группы по фамилии
	public void deleteStudentBySurname(String surName) {
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i] == null) {
				continue;
			} else if (studentArray[i].getSurName().equalsIgnoreCase(surName)) {
				studentArray[i] = null;
				System.out.println(surName + " was deleted from the group " + groupName);
				break;
			} else if (i == (studentArray.length - 1)) {
				System.out.println("There is no such student in the group with Surname - " + surName);
			}
		}
	}
	//удаление студента из группы по индексу
	public void deleteStudentByIndex(int index) {
		String surName = studentArray[index].getSurName();
		studentArray[index] = null;
		System.out.println(surName + " was deleted from the group " + groupName);
	}

	public String findStudent(String surName) {
		String info = "";
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i].getSurName().equalsIgnoreCase(surName)) {
				info = studentArray[i].humanInfo();
			} else {
				info = "There is no such student in the group with Surname " + surName;
			}
		}
		return info;
	}

	private Freshman[] arraySort() {
		int n = 0;
		Freshman[] groupCopy = studentArray;

		for (int i = groupCopy.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (groupCopy[j].getSurName() != null && groupCopy[j + 1].getSurName() != null) {
					n = groupCopy[j].getSurName().compareToIgnoreCase(groupCopy[j + 1].getSurName());
					if (n > 0) {
						Freshman st = groupCopy[j];
						groupCopy[j] = groupCopy[j + 1];
						groupCopy[j + 1] = st;
					}

				} else if (groupCopy[j].getSurName() != null && groupCopy[j + 1].getSurName() == null) {
					Freshman st = groupCopy[j];
					groupCopy[j] = groupCopy[j + 1];
					groupCopy[j + 1] = st;
				} else if (groupCopy[j].getSurName() == null && groupCopy[j + 1].getSurName() != null) {
					Freshman st = groupCopy[j + 1];
					groupCopy[j + 1] = groupCopy[j];
					groupCopy[j] = st;
				}
			}

		}
		return groupCopy;
	}

	// выбор старосты группы
	public void chooseCaptain() {
		int length = 0;
		Freshman[] captainArray = new Freshman[10];
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i].getSex().equalsIgnoreCase("female")) {
				captainArray[length] = studentArray[i];
				length += 1;

			}
		}
		int[] points = new int[length];
		int maxPoint=0;
		for (int i = 0; i < length; i++) {
			if (captainArray[i].getSchoolProgress() >= 90) {
				points[i] += 3;
			} else if (captainArray[i].getSchoolProgress() >= 80) {
				points[i] += 2;
			} else if (captainArray[i].getSchoolProgress() >= 70) {
				points[i] += 1;
			} else {
				points[i] += 0;

			}
			if (captainArray[i].getWeight() <= 45) {
				points[i] += 3;
			} else if (captainArray[i].getWeight() <= 55) {
				points[i] += 2;
			} else if (captainArray[i].getWeight() <= 65) {
				points[i] += 1;
			} else {
				points[i] += 0;
			}
			if (captainArray[i].getAge() <= 18) {

				points[i] += 2;
			} else if (captainArray[i].getAge() <= 21) {
				points[i] += 3;
			} else if (captainArray[i].getAge() <= 25) {
				points[i] += 1;
			} else {
				points[i] += 0;
			}
		}for (int i = 0; i < (points.length-1); i++) {
			if(points[i]>points[i+1]){
				maxPoint=i;
			}
		}for (int i = 0; i < studentArray.length; i++) {
			if(studentArray[i].getSurName().equalsIgnoreCase(captainArray[maxPoint].getSurName())){
				studentArray[i].setCaptain(true);
				System.out.println(studentArray[i].getName()+" "+studentArray[i].getSurName()+
						" is the Captain of the group");
			}
		}
	}
	
	//Описание состава группы
	@Override
	public String toString() {
		Freshman[] groupCopy = arraySort();
		StringBuilder sb = new StringBuilder();
		sb.append(
				"\t" + groupName + ":" + System.lineSeparator() +
				"-------------------------" + System.lineSeparator());
		for (int i = 0; i < groupCopy.length; i++) {
			if (groupCopy[i] != null) {
				sb.append((i + 1) + groupCopy[i].humanInfo() + System.lineSeparator());
				sb.append(System.lineSeparator());
			} else {
				sb.append((i + 1) + " free" + System.lineSeparator());
				sb.append(System.lineSeparator());
			}
		}

		return sb.toString();
	}

	@Override
	public Freshman[] getFreshmanArray() {
		return this.studentArray;
	}
	
}

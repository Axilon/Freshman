package ru.bk.rom4ik2103;

public class MyException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 744033254308711227L;

	@Override
	public String getMessage() {
		
		return "Add Error. The group is full";
	}
}

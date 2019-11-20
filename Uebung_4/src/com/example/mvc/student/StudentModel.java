package com.example.mvc.student;

import java.util.ArrayList;
import java.util.List;

public class StudentModel implements IModel {
	private String name;
	private String number;
	private int semester=0;
	
	private List<IView> viewList = new ArrayList<IView>();

	
	public StudentModel(String sname, String snumber, int ssemester)
	{
		name = sname;
		number = snumber;
		semester = ssemester;

	}
	
	public void increaseSemester()
	{
		semester++;
		benachrichtigen();
		
	}
	
	public void anmelden(IView view) {
		viewList.add(view);
	}
	
	@Override
	public void abmelden(IView view) {
		viewList.remove(view);
		
	}

	
	private void benachrichtigen() {
		
		for (IView view : this.viewList) {
			view.aktualisieren(this);
		}
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
	public String getSemester()
	{
		return new String(this.semester + "");
		
	}

	
}
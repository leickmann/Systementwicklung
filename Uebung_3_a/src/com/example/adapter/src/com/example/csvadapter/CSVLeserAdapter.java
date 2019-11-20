package com.example.adapter.src.com.example.csvadapter;
import java.util.Vector;


public class CSVLeserAdapter implements IPersonenLeser {
	private String file;
	private CSVLeser csvleser = new CSVLeser();
	
	public CSVLeserAdapter(String file)
	{
		this.file = file;
	}
	
	@Override
	public Vector<Person> lesePersonen() {
		
		
		Vector<Person> persVec = new Vector<Person>();
		Vector<String[]> strVec = csvleser.lesePersonenDatei(file);
		
		for (String[] s : strVec) {
			persVec.add(new Person(s[0], s[1]));
		}
		return persVec;
		
	}

}

package com.example.adapter.src.com.example.csvadapter;
import java.util.Vector;

/***
 * 
 * Tester f�r die AdapterL�sung
 * 
 *
 */

public class TestAdapter {

	public static void main (String[] args)
	{
		IPersonenLeser leser = new CSVLeserAdapter("/Users/lucas/Desktop/personen.csv");
		Vector<Person> personen = leser.lesePersonen();
		
		for (Person person : personen)
		{
			person.print();
		}
	}
}

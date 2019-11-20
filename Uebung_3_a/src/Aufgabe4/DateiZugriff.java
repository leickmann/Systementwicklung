package Aufgabe4;

import java.io.*;


public class DateiZugriff implements IDateiZugriff {
	private String name;
	private File file;
	BufferedReader br;
	
	public DateiZugriff(String name, File file){
		this.name = name;
		this.file = file;
		System.out.println("Echtes Objekt instanziiert.");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void getInhalt() {
		
		try {
			 br = new BufferedReader(new FileReader(file));
		
			 String zeile = null;
		
			 while ((zeile = br.readLine()) != null) {
				 System.out.println(zeile);
			 }
			 		 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

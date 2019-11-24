package VorlesungsVerzeichnis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String strasseHNr;
	private String plzOrt;
	@OneToOne(mappedBy = "adresse")
	private Student student;
	
	public Adresse() {
	}
	
	public Adresse(String strasseHNr, String plzOrt) {
		this.strasseHNr = strasseHNr;
		this.plzOrt = plzOrt;
	}

	public String getStrasseHNr() {
		return strasseHNr;
	}

	public void setStrasseHNr(String strasseHNr) {
		this.strasseHNr = strasseHNr;
	}

	public String getPLZOrt() {
		return plzOrt;
	}

	public void setPLZOrt(String pLZOrt) {
		plzOrt = pLZOrt;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
		student.setAdresse(this);
	}
	
	public String toString() {
		return getStrasseHNr() + " " + getPLZOrt();
	}
	
	
	

}

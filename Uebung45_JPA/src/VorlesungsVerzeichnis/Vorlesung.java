package VorlesungsVerzeichnis;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Vorlesung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String beschreibung;
	@ManyToMany(mappedBy = "vorlesungen")
	private Set<Student> studenten;
	@ManyToOne()
	@JoinColumn(name = "fk_professor")
	private Professor prof;
	
	public Vorlesung() {
		studenten = new HashSet<Student>();
	}
	
	public Vorlesung(String name, String beschreibung) {
		this();
		this.name = name;
		this.beschreibung = beschreibung;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Set<Student> getStudenten() {
		return studenten;
	}

	public void addStudent(Student student) {
		this.studenten.add(student);
		if (student.getVorlesungen().contains(this)){
			return;
		}else {
			student.addVorlesung(this);
		}
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
		if (prof.getVorlesungen().contains(this))
			return;
		else {
		prof.addVorlesungen(this);
		}
	}
	
	

}

package VorlesungsVerzeichnis;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Student {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String vorname;
	private String nachname;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_adresse")
	private Adresse adresse;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "STUD_VORLESUNG", joinColumns = {@JoinColumn(name="student")}, inverseJoinColumns = {@JoinColumn(name="vorlesung")})
	private Set<Vorlesung> vorlesungen;
	
	
	
	public Student() {
		vorlesungen = new HashSet<Vorlesung>();
	}
	public Student(String vorname, String nachname) {
		this();
		this.vorname = vorname;
		this.nachname = nachname;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
		if (adresse.getStudent() != this) {
		adresse.setStudent(this);
		}
	}
	public Set<Vorlesung> getVorlesungen() {
		return vorlesungen;
	}
	public void addVorlesung(Vorlesung vorlesung) {
		this.vorlesungen.add(vorlesung);
		if (vorlesung.getStudenten().contains(this)) {
			return;
		}else {
			vorlesung.addStudent(this);
		}
	}
	
	
	
	
}

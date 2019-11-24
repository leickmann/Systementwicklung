package VorlesungsVerzeichnis;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	@OneToMany(mappedBy = "prof")
	private Set<Vorlesung> vorlesungen;
	
	public Professor() {
		this.vorlesungen = new HashSet<Vorlesung>();
	}
	public Professor(String name) {
		this.vorlesungen = new HashSet<Vorlesung>();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Vorlesung> getVorlesungen() {
		return vorlesungen;
	}

	public void addVorlesungen(Vorlesung vorlesung) {
		if (vorlesung.getProf() == this) {
			return;
		}else {
			vorlesung.setProf(this);
		}
	}
	
	
}

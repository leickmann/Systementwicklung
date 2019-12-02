package OnlineModegeschaeft;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mitarbeiter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String benutzername;
	private Date einstellungsdatum;
	@Column(unique = true)
	private String email;
	private String nachname;
	private String vorname;
	private String passwort;
	
	
	public Mitarbeiter() {
	}


	public Mitarbeiter(String benutzername) {
		this();
		this.benutzername = benutzername;
	}


	public Date getEinstellungsdatum() {
		return einstellungsdatum;
	}


	public void setEinstellungsdatum(Date einstellungsdatum) {
		this.einstellungsdatum = einstellungsdatum;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNachname() {
		return nachname;
	}


	public void setNachname(String nachname) {
		this.nachname = nachname;
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public String getPasswort() {
		return passwort;
	}


	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}


	public String getBenutzername() {
		return benutzername;
	}
	
	
	
	

}

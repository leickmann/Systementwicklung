import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PhoneBookEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String phoneNumber;
	private boolean isBusiness;

	public PhoneBookEntry(String name, String phoneNumber, boolean isBusiness) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.isBusiness = isBusiness;
	}

	public PhoneBookEntry() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoneNumber(String number){
		this.phoneNumber = number;
	}

	public void setBusiness(boolean isBusiness) {
		this.isBusiness = isBusiness;
	}
	
}
package Ue2_Online_Modegeschaeft;

public class GoldKunde implements IKunde {

	private int kundenID;
	private String nachname;
	private String vorname;
	private Warenkorb waren = new Warenkorb(this);
	private final int rabatt = 20;
	
	public GoldKunde(String s){
		String[] teil = s.split(";");
		this.kundenID = Integer.parseInt(teil[0]);
		this.nachname = teil[1];
		this.vorname = teil[2];	
	}
	
	/* (non-Javadoc)
	 * @see Ue2_Online_Modegeschaeft.IKunde#getKundenID()
	 */
	@Override
	public int getKundenID() {
		return kundenID;
	}

	
	@Override
	public void setKundenID(int kundenID) {
		this.kundenID = kundenID;
	}

	
	@Override
	public String getNachname() {
		return nachname;
	}

	
	@Override
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	
	@Override
	public String getVorname() {
		return vorname;
	}

	
	@Override
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	
	@Override
	public Warenkorb getWarenkorb() {
		return waren;
	}

	public int getRabatt() {
		return rabatt;
	}

	
}

package Aufgabe9;

/**
* Nutzer des Modegesch�fts. Haben einen Warenkorb in den
* sie Artikel hinzuf�gen und l�schen k�nnen. K�nnen aus 
* dem Warenkorb Bestellungen ausl�sen.
*/
public class Kunde implements IKunde {

	private int kundenID;
	private String nachname;
	private String vorname;
	private Warenkorb waren = new Warenkorb(this);
	
	public Kunde(String s){
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

	/* (non-Javadoc)
	 * @see Ue2_Online_Modegeschaeft.IKunde#setKundenID(int)
	 */
	@Override
	public void setKundenID(int kundenID) {
		this.kundenID = kundenID;
	}

	/* (non-Javadoc)
	 * @see Ue2_Online_Modegeschaeft.IKunde#getNachname()
	 */
	@Override
	public String getNachname() {
		return nachname;
	}

	/* (non-Javadoc)
	 * @see Ue2_Online_Modegeschaeft.IKunde#setNachname(java.lang.String)
	 */
	@Override
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/* (non-Javadoc)
	 * @see Ue2_Online_Modegeschaeft.IKunde#getVorname()
	 */
	@Override
	public String getVorname() {
		return vorname;
	}

	/* (non-Javadoc)
	 * @see Ue2_Online_Modegeschaeft.IKunde#setVorname(java.lang.String)
	 */
	@Override
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/* (non-Javadoc)
	 * @see Ue2_Online_Modegeschaeft.IKunde#getWarenkorb()
	 */
	@Override
	public Warenkorb getWarenkorb() {
		return waren;
	}
	
}

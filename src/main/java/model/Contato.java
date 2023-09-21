package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Contato.
 */
public class Contato {

	/** The tel fixo. */
	private String telFixo;
	
	/** The tel movel. */
	private String telMovel;
	
	/**
	 * Instantiates a new contato.
	 *
	 * @param telFixo the tel fixo
	 * @param telMovel the tel movel
	 */
	public Contato (String telFixo, String telMovel) {
		this.telFixo = telFixo;
		this.telMovel = telMovel;
	}

	/**
	 * Instantiates a new contato.
	 */
	public Contato() {
		super();
	}
	
	/**
	 * Gets the tel fixo.
	 *
	 * @return the tel fixo
	 */
	public String getTelFixo() {
		return telFixo;
	}

	/**
	 * Sets the tel fixo.
	 *
	 * @param telFixo the new tel fixo
	 */
	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo;
	}

	/**
	 * Gets the tel movel.
	 *
	 * @return the tel movel
	 */
	public String getTelMovel() {
		return telMovel;
	}

	/**
	 * Sets the tel movel.
	 *
	 * @param telMovel the new tel movel
	 */
	public void setTelMovel(String telMovel) {
		this.telMovel = telMovel;
	}
}

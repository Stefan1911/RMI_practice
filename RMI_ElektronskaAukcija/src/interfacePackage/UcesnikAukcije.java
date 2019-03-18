package interfacePackage;

import java.io.Serializable;

public class UcesnikAukcije implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String surname;
	
	public UcesnikAukcije(long id,String name,String surname) {
		this.id=id;
		this.name=name;
		this.surname=surname;
	}
	
	public long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	

}

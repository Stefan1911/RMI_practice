package eBanka;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Korisnik extends UnicastRemoteObject implements IKorisnik{

	private IStanje stanje;
	private String jbk;
	
	public Korisnik(String jbk, float iznosDinarski, float iznosDevizni) throws RemoteException {
		super();
		stanje = new Stanje(iznosDinarski, iznosDevizni);
		this.jbk=jbk;
	}

	@Override
	public IStanje vratiStanje() throws RemoteException {
		return stanje;
	}

	@Override
	public void transferDinarskiNaDevizni(float iznos, float kurs) throws RemoteException {
		if(this.stanje.vratiDinarskiIznos()<iznos)
			throw new Error("nemas tolko para");
		this.stanje.updateDevizniIznos(iznos*kurs);
		this.stanje.updateDinarskiIznos(-iznos);
	}

	@Override
	public void transferDevizniNaDinarski(float iznos, float kurs) throws RemoteException {
		if(this.stanje.vratiDevizniIznos()<iznos)
			throw new Error("nemas tolko para");
		this.stanje.updateDinarskiIznos(iznos*kurs);
		this.stanje.updateDevizniIznos(-iznos);
		
	}

	@Override
	public String vratiJbk() throws RemoteException {
		return this.jbk;
	}
	

}

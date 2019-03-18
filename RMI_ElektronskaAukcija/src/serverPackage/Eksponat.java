package serverPackage;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import interfacePackage.ICallback;
import interfacePackage.IEksponat;
import interfacePackage.UcesnikAukcije;

public class Eksponat extends UnicastRemoteObject implements IEksponat{
	
	private long id;
	private String naziv;
	private int cena;
	ArrayList<UcesnikAukcije> ucesnici;
	ArrayList<ICallback> calls;
	UcesnikAukcije highestBidder;
	
	public Eksponat(long id, String naziv, int cena) throws RemoteException {
		super();
		this.id=id;
		this.naziv=naziv;
		this.cena=cena;
		this.ucesnici = new ArrayList<UcesnikAukcije>();
		this.highestBidder = null ;
	}

	@Override
	public void prijaviLicitaciju(UcesnikAukcije ucesnik) {
		if(!this.inList(ucesnik))
			this.ucesnici.add(ucesnik);
		this.highestBidder = ucesnik;
	}

	@Override
	public UcesnikAukcije getUcesnik() {
		return this.highestBidder;
	}

	@Override
	public void odustani(long ucesnikID) {
		for(UcesnikAukcije ucesnik : this.ucesnici) {
			if(ucesnik.getId() ==  ucesnikID) {
				ucesnici.remove(ucesnik);
			}
		}
	}

	@Override
	public String getNaziv() {
		return this.naziv;
	}

	@Override
	public int getCenu() {
		return this.cena;
	}
	public long getId() {
		return this.id;
	}

	@Override
	public void povecajCenu(int iznos) throws RemoteException {
		this.cena+=iznos;
		System.out.println("cena povecana za item: "+this.id +"\nNovacena je :" + this.cena);
	}
	private boolean inList(UcesnikAukcije novUcesnik) {
		for(UcesnikAukcije ucesnik : this.ucesnici) {
			if(novUcesnik.getId() == ucesnik.getId())
				return  true;
		}
		return false;
	}
	


}

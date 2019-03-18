package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import shared.IKorisnik;
import shared.IStanje;

public class Korisnik extends UnicastRemoteObject implements IKorisnik {

	String broj;
	int minTarifa;
	int porTarifa;
	int internetTarifa;
	Stanje stanje;
	
	public Korisnik(String broj,int minuti,int poruke,int internet, int minTarifa, int porTarifa,int internetTarifa) throws RemoteException {
		this.broj = broj;
		this.minTarifa = minTarifa;
		this.porTarifa = porTarifa;
		this.internetTarifa = internetTarifa;
		this.stanje = new Stanje(broj, minuti,poruke, internet, (minTarifa*minuti)+(porTarifa*poruke)+(internet*internetTarifa));
	}
	
	@Override
	public void uplatiMinute(int iznos) throws RemoteException {
		this.stanje.dodajMinute(iznos);
		this.stanje.povecajRacun(iznos*minTarifa);
	}

	@Override
	public void uplatiPoruke(int iznos) throws RemoteException {
		this.stanje.dodajPoruke(iznos);
		this.stanje.povecajRacun(iznos*porTarifa);
	}

	@Override
	public void uplatiInternet(int iznos) throws RemoteException {
		this.stanje.dodajInternet(iznos);
		this.stanje.povecajRacun(iznos*internetTarifa);
	}

	@Override
	public IStanje vratiStanje() throws RemoteException {
		return this.stanje;
	}
	
	public boolean proveriBroj(String broj) {
		return this.broj.equals(broj);
	}
	
	@Override
	public String sayHi(String Name) throws RemoteException {
		return "Hello "+Name;
	}
}

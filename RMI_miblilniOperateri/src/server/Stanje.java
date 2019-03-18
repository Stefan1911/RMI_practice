package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import shared.IStanje;

public class Stanje extends UnicastRemoteObject implements IStanje {
	
	String broj;
	int minuti;
	int poruke;
	int internet;
	float racun;
	
	public Stanje(String broj, int minuti, int poruke, int internet , float Racun) throws RemoteException {
		this.broj = broj;
		this.minuti = minuti;
		this.poruke = poruke;
		this.internet = internet;
		this.racun = Racun;
	}

	@Override
	public int vratiMinute() throws RemoteException {
		return this.minuti;
	}
	public void dodajMinute(int kolicina) {
		this.minuti += kolicina;
	}

	@Override
	public int vratiPoruke() throws RemoteException {
		return this.poruke;
	}
	public void dodajPoruke(int kolicina) {
		this.poruke += kolicina;
	}

	@Override
	public int vratiInternet() throws RemoteException {
		return this.internet;
	}
	public void dodajInternet(int kolicina) {
		this.internet+= kolicina;
	}
	@Override
	public float vratiRacun() throws RemoteException {
		return this.racun;
	}
	public void povecajRacun(int kolicina) {
		this.racun+= kolicina;
	}
	@Override
	public String sayHi(String Name) throws RemoteException {
		return "Hello "+Name;
	}
}

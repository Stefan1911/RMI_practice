package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Shared.ICallback;
import Shared.IPrijava;
import Shared.IStudent;

public class Student extends UnicastRemoteObject implements IStudent {
	
	private String brIndexa;
	private Prijava prijava;
	private SluzbaManager sluzba;
	
	public Student(String brIndexa) throws RemoteException{
		super();
		this.brIndexa = brIndexa;
		this.prijava = new Prijava();
	}
	@Override
	public IPrijava vratiPrijavu() {
		return (IPrijava) this.prijava;
	}

	@Override
	public void prijaviIspit(String ispit) throws RemoteException {
		this.prijava.dodajIpsit(ispit);
		this.sluzba.notify(ispit);
	}
	
	public String getBrIndexa() {
		return this.brIndexa; 
	}
	@Override
	public String sayHi(String name) throws RemoteException {
		return "Hello " + name;
	}
	public boolean hasIspit(String ispit) {
		return this.prijava.jePrijavljeno(ispit);
	}
	public void dodajSluzbu(SluzbaManager sluzba) {
		this.sluzba = sluzba;
	}
}

package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import shared.ICallback;
import shared.IKorisnik;
import shared.IOperatorManager;

public class OperatorMangaer extends UnicastRemoteObject implements IOperatorManager {
	
	ArrayList<Korisnik> korisnici;
	ArrayList<ICallback> callbacks;
	
	public OperatorMangaer() throws RemoteException {
		super();
		this.korisnici = new ArrayList<Korisnik>(); 
		this.callbacks = new ArrayList<ICallback>();
	}
	
	@Override
	public IKorisnik vratiKorisnika(String broj) throws RemoteException {
		for(Korisnik korisnik : this.korisnici) {
			System.out.println("proverava se korisnik " + korisnik.broj);
			if(korisnik.proveriBroj(broj)) {
				System.out.println("nadjen korisnik " + korisnik.broj);
				return korisnik;
			}
		}
		return null;
	}

	@Override
	public void obavestiKorisnike(String poruka) throws RemoteException {
		for(ICallback call : this.callbacks) {
			call.obavesti(poruka);
		}
	}
	
	public void dodajKorisnika(Korisnik user) {
		this.korisnici.add(user);
	}

	@Override
	public String sayHi(String Name) throws RemoteException {
		return "Hello "+Name;
	}

	@Override
	public void prijaviCallback(ICallback call) throws RemoteException {
		this.callbacks.add(call);
	}


}

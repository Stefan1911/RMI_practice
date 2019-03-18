package eBanka;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String [] args){
		try{
			IEBankManager manager= new EBankManager();
			
			manager.dodajKorisnika(new Korisnik("1",1000,1000));
			manager.dodajKorisnika(new Korisnik("2",1000,1000));
			manager.dodajKorisnika(new Korisnik("3",1000,1000));
			manager.dodajKorisnika(new Korisnik("4",1000,1000));
			manager.dodajKorisnika(new Korisnik("5",1000,1000));
			manager.dodajKorisnika(new Korisnik("6",1000,1000));
			manager.dodajKorisnika(new Korisnik("7",1000,1000));
			manager.dodajKorisnika(new Korisnik("8",1000,1000));
			manager.dodajKorisnika(new Korisnik("9",1000,1000));
			manager.dodajKorisnika(new Korisnik("10",1000,1000));
			
			LocateRegistry.createRegistry(3333);  
			Naming.rebind("rmi://localhost:3333/zadatak",manager);
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

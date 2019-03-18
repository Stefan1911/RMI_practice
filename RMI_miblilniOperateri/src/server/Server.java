package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) throws RemoteException {
		
		OperatorMangaer manager = new OperatorMangaer();
		
		manager.dodajKorisnika(new Korisnik("061", 100, 200, 1024, 3, 2, 5));
		manager.dodajKorisnika(new Korisnik("062", 200, 300, 2048, 3, 2, 5));
		
		Registry reg = LocateRegistry.createRegistry(1911);
		reg.rebind("Operator", manager);

	}

}

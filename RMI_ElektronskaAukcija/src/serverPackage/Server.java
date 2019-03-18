package serverPackage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfacePackage.ConnectionString;

public class Server {

	public static void main(String[] args) throws RemoteException {

		String service = "Aukcija";
		
		Manager dave = new Manager();
		dave.addEksponat(new Eksponat(1,"prvi",10));
		dave.addEksponat(new Eksponat(2,"drugi",100));
		dave.addEksponat(new Eksponat(3,"treci",1000));
		dave.addEksponat(new Eksponat(4,"cetvrti",100000));

		Registry reg = LocateRegistry.createRegistry(ConnectionString.instance().getPort());
		reg.rebind(service, dave);
	}

}

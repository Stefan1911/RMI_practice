package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IKorisnik extends Remote {
	void uplatiMinute(int minute) throws RemoteException;
	void uplatiPoruke(int poruke) throws RemoteException;
	void uplatiInternet(int internet) throws RemoteException;
	IStanje vratiStanje() throws RemoteException;
	
	String sayHi(String Name) throws RemoteException;
}

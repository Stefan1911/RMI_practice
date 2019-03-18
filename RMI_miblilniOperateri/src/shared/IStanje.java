package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStanje extends Remote {
	int vratiMinute() throws RemoteException;
	int vratiPoruke() throws RemoteException;
	int vratiInternet() throws RemoteException;
	float vratiRacun() throws RemoteException;
	
	String sayHi(String Name) throws RemoteException;
}

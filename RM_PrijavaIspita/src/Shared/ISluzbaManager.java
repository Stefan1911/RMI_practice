package Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISluzbaManager extends Remote {
	IStudent vratiStudent(String brIndexa) throws RemoteException;
	void prijaviCallback(ICallback call)throws RemoteException;
}

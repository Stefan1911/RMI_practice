package interfacePackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICallback extends Remote {
	public void callback(long idUsera,String name, String surename,long id,String Name, int cena) throws RemoteException;
}

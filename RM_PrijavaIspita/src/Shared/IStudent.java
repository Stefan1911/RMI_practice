package Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStudent extends Remote {
	IPrijava vratiPrijavu() throws RemoteException;
	void prijaviIspit(String ispit)throws RemoteException;
	String sayHi(String name)throws RemoteException;
}

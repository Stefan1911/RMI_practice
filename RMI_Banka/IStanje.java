package eBanka;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStanje extends Remote{

	float vratiDinarskiIznos() throws RemoteException;
	float vratiDevizniIznos() throws RemoteException;
	
	void updateDinarskiIznos(float iznos) throws RemoteException;
	void updateDevizniIznos(float iznos) throws RemoteException;
	
}

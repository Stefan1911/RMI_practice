package eBanka;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IKorisnik extends Remote{
	IStanje vratiStanje() throws RemoteException;
	void transferDinarskiNaDevizni(float iznos, float kurs) throws RemoteException;
	void transferDevizniNaDinarski(float iznos, float kurs) throws RemoteException;
	
	String vratiJbk() throws RemoteException;
	
	
}

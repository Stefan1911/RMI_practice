package interfacePackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEksponat extends Remote {
	 void prijaviLicitaciju(UcesnikAukcije ucesnik)throws RemoteException;
	 UcesnikAukcije getUcesnik()throws RemoteException ;
	 void odustani(long ucesnikID)throws RemoteException;
	 String getNaziv()throws RemoteException;
	 int getCenu()throws RemoteException;
	 long getId()throws RemoteException;
	 void  povecajCenu(int iznos) throws RemoteException;
}

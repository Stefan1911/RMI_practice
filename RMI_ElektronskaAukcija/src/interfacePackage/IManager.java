package interfacePackage;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IManager extends Remote {
	public IEksponat getEksponat(long id) throws RemoteException;
	public void PovecajCenu(long id,int iznos, UcesnikAukcije ucesnik) throws RemoteException ;
	public void prijaviCall(ICallback call)throws RemoteException;
}

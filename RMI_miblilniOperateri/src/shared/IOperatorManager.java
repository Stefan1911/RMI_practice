package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperatorManager extends Remote {
	IKorisnik vratiKorisnika(String broj) throws RemoteException;
	void obavestiKorisnike(String poruka) throws RemoteException;
	String sayHi(String Name) throws RemoteException;
	void prijaviCallback(ICallback call) throws RemoteException;
}

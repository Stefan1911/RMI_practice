package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICallback extends Remote {
	public void obavesti(String poruka) throws RemoteException;
}

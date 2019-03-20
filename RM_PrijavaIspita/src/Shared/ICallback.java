package Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICallback extends Remote {
	void callback(int brojStudenata,String Ispit) throws RemoteException;
}

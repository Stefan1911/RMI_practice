package eBanka;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EBankCallback extends Remote {

	public void callback(String poruka) throws RemoteException;
}

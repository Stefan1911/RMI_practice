package Shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPrijava extends Remote {
	String VratiIdpite()throws RemoteException ;
}

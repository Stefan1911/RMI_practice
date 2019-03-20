package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Shared.ICallback;

public class Callback extends UnicastRemoteObject implements ICallback {
	
	Client parent ;
	
	public Callback(Client parent) throws RemoteException {
		super();
		this.parent = parent;
	}
	
	@Override
	public void callback(int brojStudenata,String Ispit) throws RemoteException {
		this.parent.upDate(brojStudenata,Ispit);
	}

}

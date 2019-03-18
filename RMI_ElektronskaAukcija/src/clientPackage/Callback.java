package clientPackage;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfacePackage.ICallback;

public class Callback extends UnicastRemoteObject implements ICallback  {

	Client parent;
	public Callback(Client parent) throws RemoteException {
		super();
		this.parent=parent;
	}
	@Override
	public void callback(long idUsera,String name, String surename, long id,String itemName, int cena) throws RemoteException {
		this.parent.update(idUsera,name,surename,id,itemName,cena);
	}
}

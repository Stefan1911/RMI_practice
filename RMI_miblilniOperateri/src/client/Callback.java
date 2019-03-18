package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import shared.ICallback;

public class Callback extends UnicastRemoteObject implements ICallback {

	protected Callback() throws RemoteException {
		super();
	}

	@Override
	public void obavesti(String poruka) throws RemoteException {
		System.out.println("---Poruka mobilnog operatera:");
		System.out.println(poruka);
	}

}

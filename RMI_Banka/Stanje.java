package eBanka;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Stanje extends UnicastRemoteObject implements IStanje  {

	private float iznosDinarski;
	private float iznosDevizni;
	public Stanje(float iznosDinarski, float iznosDevizni) throws RemoteException {
		super();
		this.iznosDevizni=iznosDevizni;
		this.iznosDinarski=iznosDinarski;
	}
	@Override
	public float vratiDinarskiIznos() throws RemoteException {

		return this.iznosDinarski;
	}

	@Override
	public float vratiDevizniIznos() throws RemoteException {

		return this.iznosDevizni;
	}
	@Override
	public void updateDinarskiIznos(float iznos) throws RemoteException {
		this.iznosDinarski+=iznos;		
	}
	@Override
	public void updateDevizniIznos(float iznos) throws RemoteException {
		this.iznosDevizni+=iznos;
		
	}

}

package serverPackage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import interfacePackage.ICallback;
import interfacePackage.IEksponat;
import interfacePackage.IManager;
import interfacePackage.UcesnikAukcije;

public class Manager extends UnicastRemoteObject implements IManager {

	
	ArrayList<Eksponat> items ;
	ArrayList<ICallback> calls ;
	
	public Manager() throws RemoteException {
		super();
		this.items = new ArrayList<Eksponat>();
		this.calls = new ArrayList<ICallback>();
	}
	
	@Override
	public IEksponat getEksponat(long id) {
		return (IEksponat)this.getElemetn(id);
	}
	
	public void addEksponat(Eksponat item) {
		this.items.add(item);
	}
	
	private Eksponat getElemetn(long id) {
		for(Eksponat item : this.items) {
			if(item.getId() == id) {
				return item;
			}	
		}
		return null;
	}

	@Override
	public void PovecajCenu(long id, int iznos, UcesnikAukcije ucesnik) throws RemoteException {
		IEksponat item = this.getEksponat(id);
		item.povecajCenu(iznos);
		item.prijaviLicitaciju(ucesnik);
		notifyUsers(item);
	}

	@Override
	public void prijaviCall(ICallback call)throws RemoteException {
		this.calls.add(call);
	}
	
	private void notifyUsers(IEksponat item) throws RemoteException {
		for(ICallback call : this.calls) {
			call.callback(item.getUcesnik().getId(),item.getUcesnik().getName(),item.getUcesnik().getSurname(),item.getId(),item.getNaziv(),item.getCenu());
		}
	}

}

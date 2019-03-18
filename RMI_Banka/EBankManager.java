package eBanka;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class EBankManager extends UnicastRemoteObject implements IEBankManager{

	private ArrayList<EBankCallback> clients;
	private ArrayList<IKorisnik> korisnici;
	protected EBankManager() throws RemoteException {
		super();
		clients= new ArrayList<EBankCallback>();
		korisnici=new ArrayList<IKorisnik>();
	}

	@Override
	public IKorisnik vratiKorisnika(String jbk) throws RemoteException {
		for(IKorisnik k:korisnici){
			if(k!=null && k.vratiJbk().equals(jbk)){
				return k;
			}
		}
		return null;
	}

	@Override
	public void posaljiObavestenje(String poruka) throws RemoteException {
		for(EBankCallback e:clients){
			if(e!=null){
				try{
					e.callback(poruka);
				}catch(Exception ee){
					System.out.println(ee);	
				}
			}
		}	
	}

	@Override
	public synchronized void dodajUcallback(EBankCallback c) throws RemoteException {
		clients.add(c);
	}

	@Override
	public synchronized  void izbaciIzcallback(EBankCallback c) throws RemoteException {
		clients.remove(c);		
	}

	@Override
	public void dodajKorisnika(IKorisnik k) throws RemoteException {
		this.korisnici.add(k);
		
	}
	

}

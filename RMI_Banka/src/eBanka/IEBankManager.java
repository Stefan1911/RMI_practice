package eBanka;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEBankManager extends Remote {
	IKorisnik vratiKorisnika(String jbk) throws RemoteException;
	void posaljiObavestenje(String poruka) throws RemoteException;

	void dodajUcallback(EBankCallback c) throws RemoteException;
	void izbaciIzcallback(EBankCallback c) throws RemoteException;
	
	void dodajKorisnika(IKorisnik k) throws RemoteException;
}

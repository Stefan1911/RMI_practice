package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Shared.IPrijava;

public class Prijava extends UnicastRemoteObject implements IPrijava {

	ArrayList<String> ispiti;
	
	
	public Prijava() throws RemoteException {
		super();
		this.ispiti = new ArrayList<String>();
	}
	@Override
	public String VratiIdpite() throws RemoteException  {
		String ret = "";
		int i = 1;
		for(String ispit : this.ispiti) {
			ret += i +".\t"+ ispit +"\n";
			++i;
		}
		return ret;
	}
	
	public void dodajIpsit(String ispit) {
		this.ispiti.add(ispit);
	}
	public boolean jePrijavljeno(String ispit) {
		for(String element : this.ispiti) {
			if(element.equals(ispit))
				return true;
		}
		return false;
	}

}

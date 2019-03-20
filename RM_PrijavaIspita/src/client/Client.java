package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import Shared.ISluzbaManager;
import Shared.IStudent;
import Shared.ICallback;
import Shared.IPrijava;

public class Client {
	
	String promt = "\n/>";
	ISluzbaManager sluzba;
	ICallback call;
	
	public Client() throws MalformedURLException, RemoteException, NotBoundException {
		
		this.call = new Callback(this);
		
		this.sluzba = (ISluzbaManager ) Naming.lookup("rmi://localhost:1911/Sluzba");
		sluzba.prijaviCallback((ICallback)call);
		
	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Client client = new Client();
		client.run();

	}

	private void run() throws RemoteException {
		Scanner keyboard = new Scanner(System.in);
		String odgovor = "";
		while(!odgovor.equals("c")) {
			odgovor = this.meni(keyboard);
			System.out.println(odgovor);
			switch (odgovor) {
			case "a":
				this.opcijaA(keyboard);
				break;
			case "b":
				this.opcijaB(keyboard);
				break;
			case "c":
				System.out.println("Bye :WavinhHandEmoji:");
				keyboard.close();
				break;
			default:
				System.out.println("Uneliste Nevazeci odgovor");
				break;
			}
		}
	}

	public void upDate(int brojStudenata,String ispit) {
		System.out.println("Ispit " + ispit + "su do sada prijavili" +brojStudenata+ "studenata" );
	}
	private String meni(Scanner keyboard) {
		System.out.println("Dobrodosli u korisnicki servis studentske sluzbe. Za nastavak izaberite opciju:\r\n" + 
				"a) Prijava ispita\r\n" + 
				"b) Provera prijavljenih ispita\r\n" + 
				"c) Kraj " + this.promt);
		return keyboard.nextLine();
	}
	private void opcijaA(Scanner keyboard) throws RemoteException {
		System.out.println("Izbrali ste opciju za prijavu ispita:\r\n" + 
				"Unesite broj indeksa:" + promt);
		String brIndexa = keyboard.nextLine();
		IStudent student = this.sluzba.vratiStudent(brIndexa);
		if(student != null) {
			System.out.println("Unesite naziv ispita: " + promt);
			String ispit = keyboard.nextLine();
			student.prijaviIspit(ispit);
			System.out.println("Ispit uspesno prijavljen ");
		}else {
			System.out.println("ne postoji takav student ");
		}
	}
	
	private void opcijaB(Scanner keyboard) throws RemoteException {		
		System.out.println("Izbrali ste opciju za proveru prijavljenih ispita:\r\n" + 
				"Unesite broj indeksa: " + promt);
		String brIndexa = keyboard.nextLine();
		IStudent student = this.sluzba.vratiStudent(brIndexa);
		if(student != null) {
			System.out.println("Prijavljeni ispiti su : " );
			IPrijava prijava = student.vratiPrijavu();
			if(prijava != null) {
				System.out.println(prijava.VratiIdpite());
			}
		}else {
			System.out.println("ne postoji takav student ");
		}
	}

}

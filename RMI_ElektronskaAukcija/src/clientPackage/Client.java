package clientPackage;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import interfacePackage.*;
import serverPackage.Manager;

public class Client implements Serializable {
	
	String prompt = "/>";

	IManager manager;
	Callback callback;
	UcesnikAukcije ucesnik;
	
	public Client() throws MalformedURLException, RemoteException, NotBoundException {
		this.manager = (IManager)Naming.lookup(ConnectionString.instance().getConStr());
		this.callback = new Callback(this); 
		this.ucesnik = null;
		manager.prijaviCall(callback);
		
	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		Client client = new Client();
		client.run();
	}
	
	public void run() throws RemoteException {
		Scanner keyboard = new Scanner(System.in);
		this.ucesnik = napraviUcesnika(keyboard);
		String odgovor = "a";
		int iznos;
		int brojEksponata ;
		while(odgovor != "b") {
			brojEksponata = ucitajBroj("Unesite identifikator za eksponat od interesa:\n"+prompt,keyboard);
			System.out.print("Cena eksponata je: " + this.manager.getEksponat(brojEksponata).getCenu());
			odgovor = this.IzborOpcije(keyboard);
			if(odgovor.equals("a")) {
				iznos = ucitajBroj("Za koliko uvecavate iznos eksponata ? \n" +prompt,keyboard);
				manager.PovecajCenu(brojEksponata,iznos,this.ucesnik);	
			}else {
				this.manager.getEksponat(brojEksponata).odustani(this.ucesnik.getId());
			}
		}
		keyboard.close();
	}
	
	private String IzborOpcije(Scanner keyboard) {
		System.out.print("Izaberite opciju:\r\n" + 
				"a) Licitacija\r\n" + 
				"b) Odustajanje \r\n"+prompt);
		keyboard = new Scanner(System.in);
		String odgovor = keyboard.nextLine();
		return odgovor;
	}

	private int ucitajBroj(String poruka,Scanner keyboard) {
		keyboard = new Scanner(System.in);
		System.out.print(poruka);
		int broj = keyboard.nextInt();
		keyboard.nextLine(); // ovo treba jer je Scanner sugav i ne cita new line pa moram to posebno da procitam
		return broj;
	}

	private  UcesnikAukcije napraviUcesnika(Scanner keyboard) {
		long id ;
		String name;
		String surname;
		
		keyboard = new Scanner(System.in);
		System.out.println("Dobrodosli na elektronsku aukciju. Za nastavak unesite vaše licne podatke:");
		System.out.print("identifikator\n"+prompt);
		id = keyboard.nextLong();
		keyboard.nextLine();
		System.out.print("Ime\n"+prompt);
		name = keyboard.nextLine();
		System.out.print("prezime\n"+prompt);
		surname = keyboard.nextLine();
		
		return new UcesnikAukcije(id, name, surname);
	}
	
	public void update(long idUsera,String name, String surename, long id,String itemName, int cena) throws RemoteException {
		System.out.println("\n---promena cene eksponata: " + id+ " - " + itemName);
		System.out.println("---nova cena: " + cena);
		System.out.println("--Korisnik : "+ idUsera + " "+ name + " " + surename);
		System.out.println("/>");
	}
	
	

}

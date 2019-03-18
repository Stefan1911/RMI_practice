package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import shared.ICallback;
import shared.IOperatorManager;

public class Client {
	
	IOperatorManager operatorManager;
	Callback call;
	
	public Client() throws MalformedURLException, RemoteException, NotBoundException {
		
		this.call = new Callback();
		
		this.operatorManager = (IOperatorManager) Naming.lookup("rmi://localhost:1911/Operator");
		operatorManager.prijaviCallback((ICallback)call);
		
	}

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		Client client = new Client();
		client.run();
	}
	
	public void run() throws RemoteException {
		String mod = "";
		boolean done = false;
		System.out.println("Izaberite mod rada klineta:\r\n" + 
				"a) Administratorski mod\r\n" + 
				"b) Korisnicki mod");
		Scanner keyboard = new Scanner(System.in);
		mod = keyboard.nextLine();
		
		while(!done) {
			if(mod.equals("a")) {
				done = this.runAdminMod(keyboard);
			}
			else if(mod.equals("b")) {
				done = this.runUserMod(keyboard);
			} else {
				System.out.println("nevalidan mod");
			}
		}
	}

	private boolean runUserMod(Scanner Keyboard) throws RemoteException {
		System.out.println("opcijama:\r\n" + 
				"a) Uplata Minuta\r\n" + 
				"b) Uplata Poruka\r\n" + 
				"c) Uplata Interneta\r\n" + 
				"d) Provera stanja\r\n" + 
				"e) Kraj");
		String input = Keyboard.nextLine();
		System.out.println("Unesite broj telefona korisnika: ");
		String broj = Keyboard.nextLine();
		
		if(input.equals("a")) {
			System.out.println("Izbrali ste opciju za uplatu dodatnih minuta:");
			System.out.println("--Unesite broj dodatnih minuta :");
			int kolicina = Keyboard.nextInt();
			this.operatorManager.vratiKorisnika(broj).uplatiMinute(kolicina);
			return false;
		}else if(input.equals("b")) {
			System.out.println("Izbrali ste opciju za uplatu dodatnih poruka :");
			System.out.println("--Unesite broj dodatnih poruka :");
			int kolicina = Keyboard.nextInt();
			this.operatorManager.vratiKorisnika(broj).uplatiPoruke(kolicina);
			return false;
		}else if(input.equals("c")) {
			System.out.println("Izbrali ste opciju za uplatu dodatnih megabajta :");
			System.out.println("--Unesite broj dodatnih megabajta :");
			int kolicina = Keyboard.nextInt();
			this.operatorManager.vratiKorisnika(broj).uplatiInternet(kolicina);
			return false;
		}else if(input.equals("d")) {

			System.out.println("--preostali minuti :" + this.operatorManager.vratiKorisnika(broj).vratiStanje().vratiMinute());
			System.out.println("--preostale poruke :" + this.operatorManager.vratiKorisnika(broj).vratiStanje().vratiPoruke());
			System.out.println("--preostali megabajti :" + this.operatorManager.vratiKorisnika(broj).vratiStanje().vratiInternet());
			System.out.println("--racun iznosi:" + this.operatorManager.vratiKorisnika(broj).vratiStanje().vratiRacun());
			return false ;
		}else if(input.equals("e")) {
			return true;
		}
		else {
			System.out.println("nevalidan mod");
			return true ;
		}
	}
	
	private boolean runAdminMod(Scanner Keyboard) throws RemoteException {
		System.out.println("opcijama:\r\n" + 
				"a) Slanje obavestenja\r\n" + 
				"b) Izlaz \r\n" );
		String input = Keyboard.nextLine();
		if(input.equals("a")) {
			System.out.println("--Unesite Poruku:");
			String poruka = Keyboard.nextLine();
			this.operatorManager.obavestiKorisnike(poruka);
			return false;
		}
		else if(input.equals("b")) {
			return true;
		} else {
			System.out.println("nevalidan mod");
			return true ;
		}
	}

}

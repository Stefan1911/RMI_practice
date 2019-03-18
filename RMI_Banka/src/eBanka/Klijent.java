package eBanka;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Klijent {

	IEBankManager manager;
	EBankCallback callback;
	public Klijent(){
		try{
			BufferedReader r = new BufferedReader (new InputStreamReader(System.in) );
			manager=(IEBankManager)Naming.lookup("rmi://localhost:3333/zadatak");
			callback=new EBankCallbackImp();
			manager.dodajUcallback(callback);
			boolean prom=true;
		while(prom){
				String br;
				System.out.println("Izaberite mod rada klineta:\n\t a) Administratorski mod \n \t b) Korisnicki mod");
				String odgovor=r.readLine();
				if(odgovor.equals("b")){
					System.out.println("Dobrodosli u eBank korisnicki servis. Za nastavak izaberite opciju:\n\t a)Transfer sa dinarskog na devizni racun \n\t b)Transfer sa deviznog na dinarski racun \n\t c) Provera stanja \n\t d) Kraj \n >");

					String odgovor2=r.readLine();
					switch(odgovor2) {
					  case "a":
					  {
						  System.out.println("Izbrali ste opciju za Transfer sa dinarskog na devizni :\n\t Unesite jbk: \n >");
						  br=r.readLine();
						  IKorisnik k=(IKorisnik)manager.vratiKorisnika(br);
						  System.out.println("Unesite iznos i kurs:\n >"); 
						  k.transferDinarskiNaDevizni(Float.parseFloat(r.readLine()), Float.parseFloat(r.readLine()));  

					  }
					    break;
					  case "b":
					  {
						  System.out.println("Izbrali ste opciju za Transfer sa deviznog na dinarski :\n\t Unesite jbk: \n >");
						  br=r.readLine();
						  IKorisnik k=(IKorisnik)manager.vratiKorisnika(br);
						  System.out.println("Unesite iznos i kurs:\n >"); 
						  k.transferDevizniNaDinarski(Float.parseFloat(r.readLine()), Float.parseFloat(r.readLine()));  

					  }
					    break;
					  case "c":
					  {
						  System.out.println("Izbrali ste opciju za proveru stanja: \n\t Unesite jbk: \n >");
						  br=r.readLine();
						  IKorisnik k=(IKorisnik)manager.vratiKorisnika(br);
						  System.out.println("Vase stanje iznosi: \t");
						  IStanje s=(IStanje)k.vratiStanje();
						  System.out.println("Iznos na dinarskom racunu je: "+s.vratiDinarskiIznos());
						  System.out.println("Iznos na deviznom racunu je: "+s.vratiDevizniIznos());
					  }
					  break;
					  case "d":
					  {
						  System.out.println("kraj.");	  
					  }
					  default:
						prom=false;
					   
					}
				
				}
				else
				{
				System.out.println("\t a) Slanje obavestenja \n\t b) Izlaz ");
				String b=r.readLine();
				if( b.equals("a")) 
					manager.posaljiObavestenje("obavestavam sve klijente");
				else
				{	prom=false;
					System.out.println("kraj.");
				}
				 
				}				
			}		
		
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
public static void main(String [] args){
		new Klijent();
	}

	public class EBankCallbackImp extends UnicastRemoteObject implements EBankCallback{

		protected EBankCallbackImp() throws RemoteException {
			super();
		}

		@Override
		public void callback(String poruka) {
			System.out.println(poruka);
		}
		
	}
}

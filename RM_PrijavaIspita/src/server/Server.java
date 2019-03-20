package server;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) throws AccessException, RemoteException {
		
		SluzbaManager sluzba = new SluzbaManager();
		sluzba.addStudent(new Student("16000"));
		sluzba.addStudent(new Student("16001"));
		sluzba.addStudent(new Student("16002"));
		sluzba.addStudent(new Student("16003"));
		sluzba.addStudent(new Student("16004"));
		sluzba.addStudent(new Student("16005"));
		sluzba.addStudent(new Student("16006"));
		sluzba.addStudent(new Student("16007"));
		sluzba.addStudent(new Student("16008"));
		sluzba.addStudent(new Student("16009"));
		
		Registry reg = LocateRegistry.createRegistry(1911);
		reg.rebind("Sluzba", sluzba);
		
	}

}

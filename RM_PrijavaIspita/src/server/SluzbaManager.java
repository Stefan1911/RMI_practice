package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Shared.ICallback;
import Shared.ISluzbaManager;
import Shared.IStudent;

public class SluzbaManager extends UnicastRemoteObject implements ISluzbaManager {
	
	private ArrayList<Student> listaSrusenata;
	private ArrayList<ICallback> calls;
	
	public SluzbaManager() throws RemoteException {
		super();
		this.listaSrusenata = new ArrayList<Student>();
		this.calls = new ArrayList<ICallback>();
	}

	@Override
	public IStudent vratiStudent(String brIndexa) throws RemoteException {
		for(Student student : this.listaSrusenata) {
			if(student.getBrIndexa().equals(brIndexa)) {
				return student;
			}
		}
		return null;
	}
	
	public void addStudent(Student student) {
		student.dodajSluzbu(this);
		this.listaSrusenata.add(student);
	}

	@Override
	public void prijaviCallback(ICallback call) throws RemoteException {
		this.calls.add(call);
	}

	public void notify(String ispit) throws RemoteException {
		int brojStudenata = this.brojiStudente(ispit);
		for(ICallback call : this.calls) {
			call.callback(brojStudenata,ispit);
		}
	}
	private int brojiStudente(String ispit) {
		int i = 0;
		for(Student student : this.listaSrusenata) {
			if(student.hasIspit(ispit)) {
				i++;
			}
		}
		return i;
	}

}

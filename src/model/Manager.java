package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Manager {
	
	private ArrayList<Client> clients;
	
	public Manager() {
		this.clients = new ArrayList<Client>();
	}

	public boolean addClient(String name, String lastName, String iD, String iDType, LocalDate age, String gender, String phone, String email, String password) {
		boolean clientStatus = false;		
		for(int i = 0; i<clients.size(); i++) {
			if(((clients.get(i).getiD()).equals(iD)) || ((clients.get(i).getPhone()).equals(phone)) || ((clients.get(i).getEmail()).equals(email))) {
				clientStatus = true;
			}
		}
		
		if(clientStatus == false) {
			clients.add(new Client(name, lastName, iD, iDType, age, gender, phone, email, password));
		}
		
		
		return clientStatus;
		
	}
	
	/**Para ello debe ingresarse el nombre completo, n�mero y tipo de identificaci�n, fecha de nacimiento,  g�nero, n�mero telef�nico,
	correo electr�nico y contrase�a. Los clientes se guardan en una ArrayList.
	
	
	No pueden repetirse ni la ID, ni el n�mero telef�nico ni el correo electr�nico entre clientes. 
	Podr� ser realizado tanto por clientes como por empleados. */

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

}

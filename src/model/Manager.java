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
	
	/**Para ello debe ingresarse el nombre completo, número y tipo de identificación, fecha de nacimiento,  género, número telefónico,
	correo electrónico y contraseña. Los clientes se guardan en una ArrayList.
	
	
	No pueden repetirse ni la ID, ni el número telefónico ni el correo electrónico entre clientes. 
	Podrá ser realizado tanto por clientes como por empleados. */

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

}

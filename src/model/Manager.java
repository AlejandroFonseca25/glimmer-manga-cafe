package model;

import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import customExceptions.LoginException;


public class Manager{
	
	private ArrayList<Client> clients;
	private Employee headEmployee;
	private Room[] rooms;
	private Manga headManga;
	private Machine[] machines;
	
	
	public Manager() {
		this.clients = new ArrayList<Client>();
		Room a = new Room("A");
		Room b = new Room("B");
		Room c = new Room("C");
		Room d = new Room("D");
		Room e = new Room("E");
		Room f = new Room("F");
		Room g = new Room("G");
		Room h = new Room("H");
		Room i = new Room("I");
		Room j = new Room("J");
		Room k = new Room("K");
		rooms = new Room[] {a,b,c,d,e,f,g,h,i,j,k};
		headManga = null;
		headEmployee = null;
		CandyMachine cm = new CandyMachine();
		FoodMachine fm = new FoodMachine();
		machines = new Machine[] {fm,cm};
	}

	public boolean addClient(String firstName, String lastName, String iD, String iDType, LocalDate birthdate, 
			String phone, String email, String password, String gender) {
		boolean clientStatus = false;		
		
		for(int i = 0; i<clients.size(); i++) {
			if(((clients.get(i).getiD()).equals(iD)) || ((clients.get(i).getPhone()).equals(phone)) || ((clients.get(i).getEmail()).equals(email))) {
				clientStatus = true;
			}
		}
		
		if(!clientStatus) {
			clients.add(new Client(firstName, lastName, iD, iDType, birthdate, gender, phone, email,  password));
		}
		
		System.out.println(clients.get(0).getiD());
		return clientStatus;
		
	}
	
	/**Para ello debe ingresarse el nombre completo, número y tipo de identificación, fecha de nacimiento,  género, número telefónico,
	correo electrónico y contraseña. Los clientes se guardan en una ArrayList.
	
	
	No pueden repetirse ni la ID, ni el número telefónico ni el correo electrónico entre clientes. 
	Podrá ser realizado tanto por clientes como por empleados. */
	
	public void serializeAll() {
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(room1.txt));
	}
	
	public ArrayList<Client> getClients() {
		return clients;
	}

	public Employee getHeadEmployee() {
		return headEmployee;
	}

	public Room[] getRooms() {
		return rooms;
	}

	public Manga getHeadManga() {
		return headManga;
	}

	public Machine[] getMachines() {
		return machines;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public void setHeadEmployee(Employee headEmployee) {
		this.headEmployee = headEmployee;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

	public void setHeadManga(Manga headManga) {
		this.headManga = headManga;
	}

	public void setMachines(Machine[] machines) {
		this.machines = machines;
	}

	public boolean checkValues(String posId, String posPassword) throws LoginException {
		boolean valid = false;
		
		for(int i = 0; i<clients.size(); i++) {
			
			if(clients.get(i).getiD().equals(posId)) {
				Client temp = clients.get(i);
				if(temp.getPassword().equals(posPassword)) {
					valid = true;
				}

			}
		}
				
		return valid;
	}
}

package model;

@SuppressWarnings("serial")
public class DeluxeRoom extends Room{
	
	public static final String PS4 = "PlayStation 4";
	public static final String XBOX_ONE = "Xbox One";
	public static final String PC = "PC";
	private boolean gamingService;
	private String gamingDevice;
	
	public DeluxeRoom(String name) {
		super(name);
		gamingService = false;
		gamingDevice = "None";
	}
	
	public boolean isGamingService() {
		return gamingService;
	}

	public void setGamingService(boolean gamingService) {
		this.gamingService = gamingService;
	}

	public void setGamingDevice(String gamingDevice) {
		this.gamingDevice = gamingDevice;
	}
}

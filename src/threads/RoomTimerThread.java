package threads;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javafx.application.Platform;
import model.Room;
import ui.MainGUI;

public class RoomTimerThread extends Thread{

	private MainGUI mainGUI;
	private LocalDateTime time;
	private Room room;


	public RoomTimerThread(MainGUI mainGUI, Room room, LocalDateTime time) {

		this.mainGUI = mainGUI;
		this.time = time;
		this.room = room;
		}



	public void run() {
		LocalDateTime a;
		do {
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {}
			a = LocalDateTime.parse(mainGUI.getClockTotal());

			LocalDateTime tempDateTime = LocalDateTime.from( time );

			long hours = tempDateTime.until( a, ChronoUnit.HOURS );
			tempDateTime = tempDateTime.plusHours( hours );

			long minutes = tempDateTime.until( a, ChronoUnit.MINUTES );
			tempDateTime = tempDateTime.plusMinutes( minutes );

			long seconds = tempDateTime.until( a, ChronoUnit.SECONDS );			
			
			if(room.getOccupant().getiD().equals(mainGUI.getUsername().getText())) {
				
			Platform.setImplicitExit(false);
			Platform.runLater(new Thread() {

				public void run() {
					mainGUI.updateTimeLeft("Time Left: " + hours*-1 + ":" + minutes*-1 + ":" + seconds*-1);
				}
			});	}
			

		} while(time.compareTo(a) > 0);
		
		room.setOccupied(false);
		room.setTime(null);
		room.setOccupant(null);
		
		
	}
}


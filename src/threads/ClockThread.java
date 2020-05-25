package threads;

import java.time.LocalDateTime;

import javafx.application.Platform;
import ui.MainGUI;

public class ClockThread extends Thread{
	
	private MainGUI mainGUI;
	
	public ClockThread(MainGUI mainGUI) {
		
		this.mainGUI = mainGUI;
		
	}
	

	public void run(){
		
		while(true) {
			
			
			LocalDateTime dateTime = LocalDateTime.now();
			String date = dateTime.toLocalDate().toString();
			String time = dateTime.getHour() + ":" + dateTime.getMinute();
					
					
					
					
					
		Platform.runLater(new Thread() {
			@Override
			public void run() {
				
				mainGUI.updateHour(date + " " + time, dateTime.toString());
			}
		});
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {}
	} 
		
		
	}
}

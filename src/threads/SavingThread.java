package threads;

import java.io.IOException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Manager;

public class SavingThread extends Thread{
	
	private Manager m1;
	
	public SavingThread(Manager m1) {
		
		this.m1 = m1;
	}
	
	public void run() {
		
		while(true) {
			
			try {
				m1.saveAll();
			} catch (ClassNotFoundException | IOException e) {
				Alert a = new Alert(AlertType.WARNING, "An error has ocurred, please contact management");
				a.show();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
	}
	

}

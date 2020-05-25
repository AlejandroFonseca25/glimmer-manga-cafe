package threads;

import java.io.IOException;

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

			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
	}
	

}

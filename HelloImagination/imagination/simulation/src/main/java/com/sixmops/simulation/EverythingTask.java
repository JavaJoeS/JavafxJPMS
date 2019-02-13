package com.sixmops.simulation;

import java.util.TimerTask;

public class EverythingTask extends TimerTask {
	EverythingDate everythingDate;
	public EverythingTask( EverythingDate everythingDate ) {
		this.everythingDate = everythingDate;
	}
	
	@Override
	public void run() {
		//System.out.println("EverythingTask -  Running run EverythingDate");
		everythingDate.update();
		
	}
	
}

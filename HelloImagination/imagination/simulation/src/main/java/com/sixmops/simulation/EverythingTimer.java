package com.sixmops.simulation;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

import com.sixmops.simulation.EverythingDate;

import com.sixmops.simulation.EverythingTask;

public class EverythingTimer {
	
	EverythingTask everythingTask;
	
	Timer timer = new Timer(true);

	public EverythingTimer( EverythingDate everythingDate ) {
		
		everythingTask = new EverythingTask( everythingDate);
		
		timer.scheduleAtFixedRate( everythingTask, 1000,  5000 );
		
	}
}

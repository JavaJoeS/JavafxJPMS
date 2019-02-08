package com.sixmops.component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.sixmops.component.App;

public class TimedServicePull {

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(0);
	//final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 1, 1, SECONDS);
	App current;
	public TimedServicePull(App app) {
		
		try {
			for( int i=0; i < 10;i++) {
				System.out.println( "TimedServicePull -  Scheduling" );
				Thread.sleep(1000);
				scheduler.schedule( new ServiceCheckRunner( app ), 10, TimeUnit.SECONDS);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		scheduler.shutdown();
	}


	public static void main(String[] args) {

		TimedServicePull bc = new TimedServicePull( new App() );
	}

}

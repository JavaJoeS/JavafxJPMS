package com.sixmops.simulation;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledFuture;
import com.sixmops.component.App;

import com.sixmops.simulation.CheckRateRunner;
import com.sixmops.simulation.BitcoinRate;

public class BitAppController {
	
	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(0);
	
	public BitAppController(App app, BitcoinRate bitcoinRate) {
		
		try {
			//for( int i=0; i < 10;i++) {
				//System.out.println( "BitAppController -  Scheduling" );
				Thread.sleep(1000);
				Runnable checkRate = new CheckRateRunner( app, bitcoinRate);
				
				ScheduledFuture<?> scheduleFuture =  scheduler.scheduleAtFixedRate(checkRate, 1, 3, TimeUnit.MINUTES);
				Runnable canceller = () -> scheduleFuture.cancel(true);
			    //scheduler.schedule(canceller, 1, TimeUnit.HOURS);
				//scheduler.schedule( new CheckRateRunner( app ), 4, TimeUnit.MINUTES);
			//}
		} catch(Exception e) {
			e.printStackTrace();
		}
		//scheduler.shutdown();
			
	}
		
}

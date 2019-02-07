package com.sixmops.component;


import com.sixmops.component.App;

public class ServiceCheckRunner implements Runnable {
	App current;
	public ServiceCheckRunner( App app ) {
		current = app;
	}
	@Override
	public void run() {
		System.out.println("Running Runner to update");
		current.getBitcoinTicker();
	}
	public void stop() {
		
	}
}

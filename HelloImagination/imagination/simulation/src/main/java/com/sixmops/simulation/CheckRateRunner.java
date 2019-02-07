package com.sixmops.simulation;

import java.lang.Runnable;

import com.sixmops.component.App;
import com.sixmops.simulation.BitcoinRate;

public class CheckRateRunner implements Runnable {
	App app;
	BitcoinRate bitcoinRate;
	public CheckRateRunner( App app, BitcoinRate bitcoinRate ) {
		this.app = app;
		this.bitcoinRate = bitcoinRate;
	}
	@Override
	public void run() {
		System.out.println("Running Runner to update");
		app.getBitcoinTicker();
		bitcoinRate.setRate ( app.getUsd() );
	}
	public void stop() {
		
	}
}

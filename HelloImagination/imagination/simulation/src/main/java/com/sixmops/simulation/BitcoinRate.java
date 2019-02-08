package com.sixmops.simulation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BitcoinRate {
	private StringProperty rate = new SimpleStringProperty();
	
	public BitcoinRate() {
		this.setRate("101");
	}
	public StringProperty getProperty()
    {
        return this.rate;
    }
	public String getRate() {
		return this.rate.getValue();
	}
	public void setRate( String  s) {
		
		this.rate.setValue(s);
	}

}

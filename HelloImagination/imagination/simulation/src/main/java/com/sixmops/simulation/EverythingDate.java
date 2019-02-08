package com.sixmops.simulation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EverythingDate {
	
	StringProperty currentDateTime = new SimpleStringProperty();
	
	public EverythingDate() {
		
		String pattern = " HH:mm:ss.SSSZ";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String date = simpleDateFormat.format(new Date());
		
		System.out.println(date);
		
	}
	public StringProperty getProperty() {
		return currentDateTime;
	}
	public String getCurrentDateTime() {
		return this.currentDateTime.getValue();
	}
	public void setCurrentDateTime( String s ) {
		this.currentDateTime.setValue( s );
	}
	
}

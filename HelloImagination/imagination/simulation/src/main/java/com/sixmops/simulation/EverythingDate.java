package com.sixmops.simulation;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class EverythingDate {
	private static final String[] formats = { 
            "yyyy-MM-dd'T'HH:mm:ss'Z'",   "yyyy-MM-dd'T'HH:mm:ssZ",
            "yyyy-MM-dd'T'HH:mm:ss",      "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
            "yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd HH:mm:ss", 
            "MM/dd/yyyy HH:mm:ss",        "MM/dd/yyyy'T'HH:mm:ss.SSS'Z'", 
            "MM/dd/yyyy'T'HH:mm:ss.SSSZ", "MM/dd/yyyy'T'HH:mm:ss.SSS", 
            "MM/dd/yyyy'T'HH:mm:ssZ",     "MM/dd/yyyy'T'HH:mm:ss", 
            "yyyy:MM:dd HH:mm:ss",        "yyyyMMdd", };
	private static String pattern = "EEE, d MMM yyyy HH:mm:ss Z";
	SimpleDateFormat simpleDateFormat;
	StringProperty currentDateTime = new SimpleStringProperty();
	
	public EverythingDate() {
		simpleDateFormat = new SimpleDateFormat(pattern);
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
	public void update() {
		String date = simpleDateFormat.format(new Date());
		this.setCurrentDateTime(date);
		//System.out.println(date);
	}
	
}

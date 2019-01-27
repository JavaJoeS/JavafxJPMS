package com.sixmops.component;

import java.net.http.*;

import java.net.URI;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpRequest.BodyPublishers;
import java.time.Duration;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.io.ByteArrayInputStream;



/**
 * Hello world!
 *
 */
public class App {
	private String USD;
	protected static final String bits="https://bitaps.com/api/ticker?";
	public App() {
		
		System.out.println( "Hello App!" );
		StringBuilder sb = new StringBuilder(bits);
		sb.append("average");
		
		try {
			
			HttpRequest bpiRequest = HttpRequest.newBuilder()
			        .uri( URI.create( sb.toString() ) )
			        .timeout(Duration.ofMinutes(2))
			        .header("Content-Type", "application/json")
			        .GET()
			        .build();
	
			HttpClient bpiApiClient = HttpClient.newHttpClient();
	

			CompletableFuture<HttpResponse<String>> response = bpiApiClient.sendAsync(bpiRequest, BodyHandlers.ofString());
			
			
			 
			 Thread.sleep(3000);
			 if(response.isDone()) {
				 System.out.println(response.get().statusCode());
				 //{"fx_rates": {"try": "25558.66", "rub": "267666.33", "cny": "25712.15", "eur": "3346.14"}, "usd": 3833.8, "market": "average", "timestamp": 1546249500}

				 JsonParser jp = Json.createParser( new ByteArrayInputStream(  response.get().body().getBytes() ) );
				 String location="";
				 boolean gotUsd=false;
				 while ( jp.hasNext() ) {
					 
					 Event event = jp.next();
					
					 switch (event) {
					 	case START_ARRAY:
		                case END_ARRAY:
		                case START_OBJECT:
		                case END_OBJECT:
		                case VALUE_FALSE:
		                case VALUE_NULL:
		                case VALUE_TRUE:
		                    //System.out.println("VALUE_TRUE:"+event.toString());
		                    break;
		                case KEY_NAME:
		                	location=jp.getString();
		                    System.out.print("MY_KEY_NAME["+event.toString()+"]"+ "GRABBER[" + location + "] - ");
		                    if (location.equals("usd")) {
		                    	System.out.print("WE HAVE US DOLLARS");
		                    	gotUsd=true;
		                    }
		                    break;
		                case VALUE_STRING:
		                	System.out.println(event.toString() + " " + jp.getString());
		                	break;
		                case VALUE_NUMBER:
		                    System.out.println(event.toString() + " " + jp.getString());
		                    if ( gotUsd) {
		                    	USD=jp.getString();
		                    }
		                    break;
		            }
//							 case "fx_rates":
//								 jp.next();
//				                 System.out.println("FX_RATE: " + jp.getString());
//				                 break;
//							
//							 case "try":
//								 jp.next();
//				                 System.out.println("TRY: " + jp.getString());
//				                 break;
//						
//						 }
					 
				 }
				 
			     //System.out.println(response.get().statusCode());
			     //System.out.println(response.get().body());
			     
			 } else {
			     response.cancel(true);
			     System.out.println("Request is taking more time, hence cancelling it");
			 }
			 
			//System.out.println( "Hello Connected ticker!" );
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String getUsd() {
		
		return USD;
	}
	
    public static void main( String[] args )
    {
        new App();
    }
}

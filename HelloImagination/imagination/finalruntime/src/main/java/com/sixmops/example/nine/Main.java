package com.sixmops.example.nine;


public class Main {
	public Main() {
//		var bpiRequest = HttpRequest.newBuilder()
//		        .uri(new URI(config.getProperty("bpiURL")))
//		        .GET()
//		        .build();
//
//		var bpiApiClient = HttpClient.newHttpClient();
//
//		bpiApiClient
//		    .sendAsync(bpiRequest,
//		        HttpResponse.BodyHandlers.ofString())
//		    .thenApply(response -> toJson(response))
//		    .thenApply(bpiJson -> 
//		        bpiJson.getJsonObject("usd").getString("rate"));
	}
    public static void main(String[] args) {
        System.out.println("Main from Java 9");
        if (args.length > 0) {
            for (String arg : args) {
                System.out.println(" Arg: '" + arg + "'");
            }
        }
    }
}

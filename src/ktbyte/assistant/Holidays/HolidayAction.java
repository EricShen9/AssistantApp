package ktbyte.assistant.Holidays;

import ktbyte.assistant.Assistant;
import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.Response;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.*;
import com.mashape.unirest.request.*;
import com.mashape.unirest.http.exceptions.*;
import com.google.gson.*;


public class HolidayAction extends Action{
														
	public void doCommand(String command) {
		
		String[] commandSplit = command.split("/");
		String month = commandSplit[0].substring(9);
		String year = commandSplit[1];
		String url = "https://holidayapi.com/v1/holidays?pretty&public=true&country=US&year=" + year + "&month=" + month + "&key=b400f1a6-41f3-47b2-89d6-1a7be0a080fa";
		
		System.out.println(url);
		HttpRequest request = Unirest.get(url);
		System.out.println("test");
		try {
			HttpResponse<JsonNode> response = request.asJson();
			System.out.println("test");
			System.out.println(response);
			
			JsonNode node = response.getBody();
			System.out.println(node);
			handleResult(node);
			
		} catch(UnirestException e) {
			System.out.println("Request error occurred: " + e);
		}
	}
	
	
	private static void handleResult(JsonNode node) {
		Assistant assistant = Assistant.getInstance();
		JSONObject json = node.getObject();
		JSONArray holidays = json.optJSONArray("holidays");
		
		if(holidays.length() == 0) {
			assistant.displayItem(new Response("There are no public holidays in the US for this month."));
		} else {
			
			for(int i = 0; i < holidays.length(); i++) {
				String holiday1Date = holidays.optJSONObject(i).optString("date");
				String holiday1Name = holidays.optJSONObject(i).optString("name");
				
				assistant.displayItem(new Response("Holiday name: " + holiday1Name + "\nHoliday date: " + holiday1Date));
			}
			
		}
	}
	
	
	public double getLikelihood(String command) {
		if(command.contains("holidays ")) return 100;
		return 0;
	}
	
}

package ktbyte.assistant.Spacenews;

import ktbyte.assistant.Assistant;
import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.Response;

import java.util.*;

import org.json.JSONArray;

import com.mashape.unirest.http.*;
import com.mashape.unirest.request.*;
import com.mashape.unirest.http.exceptions.*;
import com.google.gson.*;

public class GetSpacenewsActions extends Action{
	
	public void doCommand(String command) {
		String url = "https://spaceflightnewsapi.net/api/v2/articles";
		HttpRequest request = Unirest.get(url);
		try {
			HttpResponse<JsonNode> response = request.asJson();
			System.out.println(response);
			
			JsonNode node = response.getBody();
			System.out.println(node);
			handleResult(node);
			
		} catch(UnirestException e) {
			System.out.println("Request error occured: " + e);
		}
	}
	
	private static void handleResult(JsonNode node) {
		Assistant assistant = Assistant.getInstance();
		JSONArray json = node.getArray();
		
		String article1Id = json.optJSONObject(0).optString("id");
		String article1Title = json.optJSONObject(0).optString("title");
		
		String article2Id = json.optJSONObject(1).optString("id");
		String article2Title = json.optJSONObject(1).optString("title");
		
		assistant.displayItem(new Response("Article ID: " + article1Id + "\nArticle Title: " + article1Title));
		assistant.displayItem(new Response("Article ID: " + article2Id + "\nArticle Title: " + article2Title));

	}

	public double getLikelihood(String command) {
		if(command.contains("space") && command.contains("news")) return 100;
		return 0;
	}

}






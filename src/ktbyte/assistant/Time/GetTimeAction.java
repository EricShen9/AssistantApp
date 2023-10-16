package ktbyte.assistant.Time;

import ktbyte.assistant.app.*;
import ktbyte.assistant.Assistant;
import java.time.*;

public class GetTimeAction extends Action{

	public void doCommand(String command) {
		String result = LocalTime.now().toString();
		
		Assistant TimeAssistant = Assistant.getInstance();
		TimeAssistant.displayItem(new Response(result));
	}

	public double getLikelihood(String command) {
		if(command.contains("time")) return 100;
		return 0;
	}
	
}

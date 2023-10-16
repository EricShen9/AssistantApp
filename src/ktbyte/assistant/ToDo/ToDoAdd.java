package ktbyte.assistant.ToDo;

import ktbyte.assistant.Assistant;
import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.Response;

public class ToDoAdd extends Action {
	
	public void doCommand(String command) {
		command = command.substring(4);
		ToDoApp.getInstance().addToDo(command);
		Assistant TimeAssistant = Assistant.getInstance();
		TimeAssistant.displayItem(new Response("Added: " + command));
	}

	public double getLikelihood(String command) {
		if(command.contains("add ")) return 100;
		return 0;
	}
	
}

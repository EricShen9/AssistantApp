package ktbyte.assistant.ToDo;

import ktbyte.assistant.Assistant;
import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.Response;

public class ToDoRemove extends Action {
	
	public void doCommand(String command) {
		command = command.substring(7);
		ToDoApp.getInstance().removeToDo(command);
		Assistant TimeAssistant = Assistant.getInstance();
		TimeAssistant.displayItem(new Response("Removed: " + command));
	}

	public double getLikelihood(String command) {
		if(command.contains("remove ")) return 100;
		return 0;
	}
}

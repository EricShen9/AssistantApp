package ktbyte.assistant.ToDo;

import ktbyte.assistant.app.*;
import ktbyte.assistant.Assistant;

public class ToDoView extends Action {

	public void doCommand(String command) {
		Assistant ToDoAssistant = Assistant.getInstance();
		String tasks = ToDoApp.getInstance().getToDoList();
		ToDoAssistant.displayItem(new Response(tasks));
	}

	public double getLikelihood(String command) {
		if(command.contains("todolist view")) return 100;
		if(command.contains("view")) return 100;
		return 0;
	}
	
}

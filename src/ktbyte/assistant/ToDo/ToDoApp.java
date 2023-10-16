package ktbyte.assistant.ToDo;

import ktbyte.assistant.app.*;
import java.util.*;

public class ToDoApp extends App{

	private ArrayList<String> ToDo;
	private static ToDoApp instance;
	
	public ToDoApp(){
		this.ToDo = new ArrayList<>();
		this.instance = this;
	}
	
	public static ToDoApp getInstance() {
		return instance;
	}
	
	public String getToDoList(){
		return this.ToDo.toString();
	}
	
	public void removeToDo(String task) {
		this.ToDo.remove(task);
	}
	
	public void addToDo(String task) {
		this.ToDo.add(task);
	}

	public List<Action> getActions(){
		List<Action> actions = new ArrayList<>();
		actions.add(new ToDoView());
		actions.add(new ToDoAdd());
		actions.add(new ToDoRemove());
		return actions;
	}
}


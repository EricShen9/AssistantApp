package ktbyte.assistant.Time;

import ktbyte.assistant.app.*;
import java.util.*;


public class TimeApp extends App{
	
	public List<Action> getActions(){
		List<Action> result = new ArrayList<>();
		result.add(new GetTimeAction());
		return result;
	}
	
}

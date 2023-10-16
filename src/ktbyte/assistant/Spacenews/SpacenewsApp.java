package ktbyte.assistant.Spacenews;

import ktbyte.assistant.app.*;
import java.util.*;

public class SpacenewsApp extends App{
	public List<Action> getActions(){
		return Arrays.asList(new GetSpacenewsActions());
	}
}

package ktbyte.assistant.Holidays;

import java.util.Arrays;
import java.util.List;

import ktbyte.assistant.app.Action;
import ktbyte.assistant.app.App;

public class HolidayApp extends App{
	public List<Action> getActions(){
		return Arrays.asList(new HolidayAction());
	}
}

package systests;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main
{

	public static void main(String args[]) throws Exception
	{
		String sURL = "https://api.ecruise.me/v1/trips?filterbystate=FINISHED";
		String singleSUrl = "https://api.ecruise.me/v1/cars/0";
		JsonParser jsParser = new JsonParser();
		
		JSONObject myObj = jsParser.parseObject(singleSUrl);
		JSONArray myArray = jsParser.parseArray(sURL);
		System.out.println(myObj);
		System.out.println(myArray);
	}
}


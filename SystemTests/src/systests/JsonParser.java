package systests;

import java.io.IOException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonParser
{
	
	public JSONObject parseObject(String sUrl) throws JSONException, IOException
	{
		URL url = new URL(sUrl);
		JSONTokener tokener = new JSONTokener(url.openStream());
		JSONObject json = new JSONObject(tokener);
		return json;
	}
	
	public JSONArray parseArray(String sUrl) throws JSONException, IOException
	{
		URL url = new URL(sUrl);
		JSONTokener tokener = new JSONTokener(url.openStream());
		JSONArray json = new JSONArray(tokener);
		return json;
	}
}

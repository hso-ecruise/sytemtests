package systests;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonParser
{
	/*
	 * This function parses an jsonObject from given URL
	 * 
	 * @param sUrl in string form to be parsed
	 * @return parsed Json Object from url
	 */
	public JSONObject parseObject(String sUrl) throws JSONException, IOException
	{
		URL url = new URL(sUrl);
		JSONTokener tokener = new JSONTokener(url.openStream());
		JSONObject json = new JSONObject(tokener);
		return json;
	}
	
	/*
	 * This function parses an jsonArray from given URL
	 * 
	 * @param sUrl url in string form to be parsed
	 * @return parsed Json Array from url
	 */
	public JSONArray parseArray(String sUrl) throws JSONException, IOException
	{
		URL url = new URL(sUrl);
		JSONTokener tokener = new JSONTokener(url.openStream());
		JSONArray json = new JSONArray(tokener);
		return json;
	}
	
	/*
	 * This function parses an jsonObject from given InputStream
	 * 
	 * @param is InputStream to be parsed
	 * @return parsed Json Object from InputStream
	 */
	public JSONObject parseObject(InputStream is) throws JSONException, IOException
	{
		JSONTokener tokener = new JSONTokener(is);
		JSONObject json = new JSONObject(tokener);
		return json;
	}
	
	/*
	 * This function parses an jsonArray from given InputStream
	 * 
	 * @param is InputStream to be parsed
	 * @return parsed Json Array from InputStream
	 */
	public JSONArray parseArray(InputStream is) throws JSONException, IOException
	{
		JSONTokener tokener = new JSONTokener(is);
		JSONArray json = new JSONArray(tokener);
		return json;
	}
	
	
}

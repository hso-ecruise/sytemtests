package ECFramework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class ECCommonMethods {

	private void Init() {
		// TODO Auto-generated method stub

	}

	private void getDBConnection() {
		// TODO Auto-generated method stub

	}

	private void getAppConn() {
		// TODO Auto-generated method stub

	}
	
	/*
	 * This function print all headers of the response
	 * 
	 * @param response response received from the server
	 */
	public static void printAllHeaders(HttpResponse response)
	{
		Header[] headers = response.getAllHeaders();
		
		for(Header item : headers)
		{
			System.out.println(item.getName() + " = " + item.getValue());
		}
	}

	/*
	 * This function print an InputStream to a console
	 * 
	 * @param is InputStream to be printed out
	 */
	public static void printInputStream(InputStream is)
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line = "";

			while ((line = br.readLine()) != null)
			{
				sb.append(line);
			}
			
			System.out.println(sb.toString());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}

		
	}
}
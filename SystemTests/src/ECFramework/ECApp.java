/**
 * 
 */
package ECFramework;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import systests.JsonParser;

/**
 * @author jenewa
 *
 */
public class ECApp
{
	public static boolean testBooking()
	{
		String sUrl = "https://api.ecruise.me/v1/bookings";
		HttpClient httpClient = HttpClientBuilder.create().build(); 
		
		try
		{
			HttpPost request = new HttpPost(sUrl);
			StringEntity sEntity = new StringEntity("{\"BookingId\" : 100," + 
												     "\"CustomerId\": 1," + 
												     "\"TripId\": 1," +
												     "\"InvoiceItemId\": 1," +
												     "\"BookedPositionLatitude\": 11," +
												     "\"BookedPositionLongitude\": 12," +
												     "\"BookingDate\": \"2017-05-21T23:30:33.713Z\"," +
												     "\"PlannedDate\": \"2017-05-21T23:30:33.713Z\"");
			request.addHeader("content-type", "application/x-www-form-urlencoded");
			request.setEntity(sEntity);
			HttpResponse response = httpClient.execute(request);
			HttpEntity respEntity = response.getEntity();
			InputStream is = respEntity.getContent();
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null)
			{
				sb.append(line);
			}
			
			System.out.println(sb.toString());
			
			
			JsonParser jParser = new JsonParser();
			JSONObject jObject = jParser.parseObject(is);
			
			if(jObject.getInt("id") == 100)
				return true;
			else
				return false;
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	

	private void testBookingWithAtts()
	{
		// TODO Auto-generated method stub
	}

	private void testCarAvaliability()
	{
		// TODO Auto-generated method stub
	}

	public static void testLoadingStations()
	{
		String sUrl = "https://api.ecruise.me/v1/charging-stations";
		JsonParser jsParser = new JsonParser();
		
		try
		{
			JSONArray jArray = jsParser.parseArray(sUrl);
			
			if(jArray.length() == 0)
				System.out.println("No stations registered at server");
			else
			{
				for(int i = 0; i < jArray.length(); i++)
				{
					JSONObject jObject = (JSONObject) jArray.get(i);
					System.out.println("\n\nStation ID = " + jObject.getInt("chargingStationId") 
													   + "\nSlots = " + jObject.getInt("slots") 
													   + "\nSlots occupied = " + jObject.getInt("slotsOccupuied") 
													   + "\nLocated at Longt: " + jObject.getDouble("latitude") + " Lat: " + jObject.getDouble("longitude"));
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private void testLoadingStationWaitingTime()
	{
		// TODO Auto-generated method stub
	}

	private void testNotification()
	{
		// TODO Auto-generated method stub
	}

	private void testNotificationCollection()
	{
		// TODO Auto-generated method stub
	}

	private void testLockCar()
	{
		// TODO Auto-generated method stub
	}

	private void testCarStatus()
	{
		// TODO Auto-generated method stub
	}

	private void testLogIn()
	{
		// TODO Auto-generated method stub
	}

}

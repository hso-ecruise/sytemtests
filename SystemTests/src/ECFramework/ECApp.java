/**
 * 
 */
package ECFramework;


import java.io.InputStream;

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
	/*
	 * This function test Backend bookings with test Parameters
	 * 
	 * @return true if success, else false
	 */
	public static boolean testBooking()
	{
		String sUrl = "https://api.ecruise.me/v1/bookings";
		HttpClient httpClient = HttpClientBuilder.create().build(); 
		
		try
		{
			HttpPost request = new HttpPost(sUrl);
			StringEntity sEntity = new StringEntity("{\"BookingId\" : 0," + 
												     "\"CustomerId\": 2," + 
												     "\"TripId\": 2," +
												     "\"InvoiceItemId\": 2," +
												     "\"BookedPositionLatitude\": 11," +
												     "\"BookedPositionLongitude\": 12," +
												     "\"BookingDate\": \"2017-05-21T23:30:33.713Z\"," +
												     "\"PlannedDate\": \"2017-05-21T23:30:33.713Z\"}");
			//InputStream is1 = sEntity.getContent();
			//ECCommonMethods.printInputStream(is1);
			request.addHeader("content-type", "application/json");
			request.setEntity(sEntity);
			HttpResponse response = httpClient.execute(request);
			//ECCommonMethods.printAllHeaders(response);
			HttpEntity respEntity = response.getEntity();
			InputStream is = respEntity.getContent();
			JsonParser jParser = new JsonParser();
			JSONObject jObject = jParser.parseObject(is);
			
			
			if(jObject.getInt("id") == 0)
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
	

	/*
	 * This function test Backend bookings with given parameters
	 * 
	 * @param bookId booking ID
	 * @param custId Customer ID
	 * @param tripId Trip ID
	 * @param invId Invoice ID
	 * @param lat Latitude
	 * @param longt Longtitude
	 * @param bookDate booking Date
	 * @param planDate date when booking was planned
	 * 
	 * @return true on success, else false
	 */
	public static boolean testBookingWithAtts(String bookId, String custId, String tripId, String invId, String lat, String longt, String bookDate, String planDate)
	{
		String sUrl = "https://api.ecruise.me/v1/bookings";
		HttpClient httpClient = HttpClientBuilder.create().build(); 
		
		try
		{
			HttpPost request = new HttpPost(sUrl);
			StringEntity sEntity = new StringEntity("{\"BookingId\" : " + bookId + "," + 
												     "\"CustomerId\": " + custId + "," + 
												     "\"TripId\": " + tripId + "," +
												     "\"InvoiceItemId\": " + invId + "," +
												     "\"BookedPositionLatitude\": " + lat + "," +
												     "\"BookedPositionLongitude\": " + longt + "," +
												     "\"BookingDate\": \"" + bookDate +"\"," +
												     "\"PlannedDate\": \"" + planDate + "\"}");
			//InputStream is1 = sEntity.getContent();
			//ECCommonMethods.printInputStream(is1);
			request.addHeader("content-type", "application/json");
			request.setEntity(sEntity);
			HttpResponse response = httpClient.execute(request);
			//ECCommonMethods.printAllHeaders(response);
			HttpEntity respEntity = response.getEntity();
			InputStream is = respEntity.getContent();
			JsonParser jParser = new JsonParser();
			JSONObject jObject = jParser.parseObject(is);
			
			
			if(jObject.getInt("id") == 0)
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

	/*
	 * This function test Backend if car is avaliable
	 * 
	 * @param carId car ID
	 * 
	 * @return true if success, else false
	 */
	public static boolean testCarAvaliability(int carId)
	{
		String sUrl = "https://api.ecruise.me/v1/cars/" + carId;
		JsonParser jsParser = new JsonParser();
		
		try
		{
			JSONObject jObject = jsParser.parseObject(sUrl);
			int carInt = jObject.getInt("bookingState");
			System.out.println(carInt);
			if(carInt == 1)
				return true;
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	
	/*
	 * This function test Backend loadingStations status and print it out
	 * 
	 */
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

	
	/*
	 * This function test Backend car charging status and print it out
	 * 
	 */
	public static boolean testCarStatus(int carId)
	{
			String sUrl = "https://api.ecruise.me/v1/cars/" + carId;
			JsonParser jsParser = new JsonParser();
			
			try
			{
				JSONObject jObject = jsParser.parseObject(sUrl);
				int carState = jObject.getInt("chargingState");
				System.out.println(carState);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return false;
	}

	private void testLogIn()
	{
		// TODO Auto-generated method stub
	}

}

package com.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import com.example.Weather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pdf.Watermarking;
import com.weather16.List;
import com.weather16.Weather16;

public class ApacheHttpClientGet {

				

	public static void main(String[] args) {
		try {
			 Object canadaIds[] = 	JsonToJava.getIds();
			
			System.out.println("Object canadaIds[] crated ");
			//String canadaIds[] = new String[]{"5956004","6325523","6941419","6948482"};
			
			for(int i=0;i<canadaIds.length;i++){
				DefaultHttpClient httpClient = new DefaultHttpClient();
				CityL c= (CityL)canadaIds[i];
				//HttpGet getRequest = new HttpGet("http://api.openweathermap.org/data/2.5/forecast/city?id=5907166&APPID=fed19c5a0dfed7bcaadcdc72f027741d");
				HttpGet getRequest = new HttpGet("http://api.openweathermap.org/data/2.5/forecast/daily?id="+c.getId()+"&cnt=16&appid=fed19c5a0dfed7bcaadcdc72f027741d");
												//  http://api.openweathermap.org/data/2.5/forecast/city?id=524901&APPID=fed19c5a0dfed7bcaadcdc72f027741d
				getRequest.addHeader("accept", "application/json");

				HttpResponse response = httpClient.execute(getRequest);

				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
				}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

				String output;
				StringBuffer outputbuffer = new StringBuffer();
						
				System.out.println("Output from Server .... \n" + response.getEntity().getContent());
				while ((output = br.readLine()) != null) {
					outputbuffer.append(output);
				}
				
				Gson gson = new GsonBuilder().create();
				System.out.println("ApacheHttpClientGet.main() Output sting is " + outputbuffer.toString());
				Weather16 p = gson.fromJson(outputbuffer.toString(), Weather16.class);
	            System.out.println(p);
	            String country = p.getCity().getCountry();
	            String cityName = p.getCity().getName() + " \t (Co-ord) " + p.getCity().getCoord().getLat() + " : " + p.getCity().getCoord().getLon();
	            ArrayList list = (ArrayList)p.getList();
	            Iterator itr = list.iterator();
	            
	            
	            File files = new File("C:\\temp\\"+country+"\\"+p.getCity().getName()+"\\"+new Date().toString().hashCode()+".pdf");
	        	
	            File parent = files.getParentFile();
	            if(!parent.exists() && !parent.mkdirs()){
	                throw new IllegalStateException("Couldn't create dir: " + parent);
	            }
	            

	        	
	            System.out.println("Country : " + country);
	            System.out.println("City : " + cityName);
	            System.out.println("City ID : " + p.getCity().getId());
	            System.out.println("ApacheHttpClientGet.main()" + p.getCod());
	            while(itr.hasNext()){
	            	Watermarking w = new Watermarking();
	            	System.out.println("=====================================================================");
	            	List weather16list = (List) itr.next();
	            	
	            	com.weather16.Weather weather = weather16list.getWeather().get(0);
	            	
	            	System.out.println("Date : " +new Date(weather16list.getDt().longValue()).toString());
	            	System.out.println("Main Event " + weather.getMain());
	            	System.out.println("Description " + weather.getDescription());
	           	
	            	System.out.println("Cloudy %" + weather16list.getClouds());
	            	System.out.println("Humiduty % " + weather16list.getHumidity());
	            	System.out.println("Pressure " +weather16list.getPressure());
	            	System.out.println("Snow Fall " +weather16list.getSnow());
	            	System.out.println("Wind Speed M/hr " +weather16list.getSpeed());
	            	
	            	System.out.println("Temperature Degree Cel (Morning) " +(weather16list.getTemp().getMorn()- 273.15F));
	            	System.out.println("Temperature Degree Cel(Day) " +(weather16list.getTemp().getDay()- 273.15F));
	            	System.out.println("Temperature Degree Cel(Eve) " +(weather16list.getTemp().getEve()- 273.15F));
	            	System.out.println("Temperature Degree Cel(Night) " +(weather16list.getTemp().getNight()- 273.15F));
	            	System.out.println("Temperature Degree Cel(Max) " +(weather16list.getTemp().getMax()- 273.15F));
	            	System.out.println("Temperature Degree Cel(Min) " +(weather16list.getTemp().getMin()- 273.15F));
	            	System.out.println("=====================================================================");
	            	try{
	            		if(weather16list.getSnow() == null){
	            			weather16list.setSnow(new Double(0));
            			}
	            		w.createPdf(files.getAbsolutePath(), country, cityName,
		            			
		            			Double.toString(p.getCity().getId()),  //double
		            			
		            			new Date(weather16list.getDt().longValue()).toString(),
		            			
		            			weather.getMain(), 
		            			weather.getDescription(), 
		            			// double from here 
		            			Double.toString(weather16list.getClouds()), 
		            			Double.toString(weather16list.getHumidity()),
		            			
		            			Double.toString(weather16list.getPressure()), 
		            			Double.toString(weather16list.getSnow()), 
		            			Double.toString(weather16list.getSpeed()), 
		            			Double.toString((weather16list.getTemp().getMorn()- 273.15F)), 
		            			Double.toString((weather16list.getTemp().getDay()- 273.15F)), 
		            			Double.toString((weather16list.getTemp().getEve()- 273.15F)), 
		            			Double.toString((weather16list.getTemp().getNight()- 273.15F)),
		            			Double.toString((weather16list.getTemp().getMax()- 273.15F)),
		            			Double.toString((weather16list.getTemp().getMin()- 273.15F)));
	            	}catch(Exception e){
	            		e.printStackTrace();
	            	}
	            	
	            }
	            //httpClient.getConnectionManager().shutdown();
			}

			

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			
		}

	}

}
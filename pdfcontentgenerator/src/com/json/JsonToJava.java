package com.json;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;

import com.example.Weather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class JsonToJava {

    public static void main(String[] args) throws IOException {

    }
    
    public static Object[]  getIds(){
    	List<CityL> data = new ArrayList<>() ;
    	
        try(
        		Reader reader = new InputStreamReader(JsonToJava.class.getResourceAsStream("/city.json"), "UTF-8")){
            Gson gson = new GsonBuilder().create();
//            ArrayList p = gson.fromJson(reader, new TypeToken<List<CityL.class>>(){}.getType());
            data = new Gson().fromJson(new FileReader("C:\\temp\\city.list.json"), new TypeToken<List<CityL>>(){}.getType());
            
            System.out.println(data);
            
        }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
       
        return data.toArray();
        
    }
}
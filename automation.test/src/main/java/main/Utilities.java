package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;


public class Utilities {
	
	
	
	public static UUID UUIDGenerator()
	{
		 UUID uid = UUID.fromString("11200000-8cf0-12bd-b23e-10b96e4ef00d");     
		 return uid.randomUUID();

	}
	
	public static void waitFor()
	{

		try
		{
			Thread.sleep(5000);
		}catch(InterruptedException e)
		{
			
		}
	}
	
	public static void waitFor(Long timeValue)
	{

		try
		{
			Thread.sleep(timeValue);
		}catch(InterruptedException e)
		{
			
		}
	}
	
	public static int randomGenerator()
	{
		Random rand = new Random();
		return rand.nextInt();
	}
	
	public static void writeJSONFile(JSONObject jObj, String jsonPath)
	{
		try
		{
		 // Writing to a file  
	        File file=new File(jsonPath);  
	        file.createNewFile();  
	        FileWriter fileWriter = new FileWriter(file);  
	        fileWriter.write(jObj.toString());  
	        fileWriter.flush();  
	        fileWriter.close(); 
		}catch(IOException e)
		{
			
		}
	}
	
	public static JSONObject readJSONFile(String jsonPath)
	{
		JSONObject obj=null;;
		try
		{
			FileReader reader = new FileReader(jsonPath);
			  int size;  
			  String str="";
	          while((size=reader.read())!=-1)  {
	        	  str=str+(char)size;
	          }
	          obj = new JSONObject(str);
	          reader.close();
	           
		}catch(IOException e)
		{
			
		}
		return obj;
	}
	


}

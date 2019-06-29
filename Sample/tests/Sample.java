package tests;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import my.lib.SeleniumUtilities;

public class Sample extends SeleniumUtilities{
	

	@DataProvider(name="Test_Data")
	public Object[][] dataProvider(){
		
		//Object[][] data = (Object[][]) new Object();
		
		HashMap<String,String> dataMap= new HashMap<String, String>();
		
		dataMap.put("username", "test1");
		dataMap.put("email", "test1@ng.com");
		dataMap.put("gender", "qa");
		
/*HashMap<String,String> dataMap1= new HashMap();
		
		dataMap.put("username", "test1");
		dataMap.put("email", "test1@ng.com");
		dataMap.put("gender", "qa");*/
		
		return new Object[][]{{"test",dataMap}};//,{"test1",{}}
	}
	
	
	@Test(enabled = true, groups = {"Smoke"}, dataProvider="Test_Data")
	public void testMethod1(String name , HashMap<String, String> data){
		
		System.out.println("Testing \n");
		System.out.println("Username is " + data.get("username"));
		System.out.println(data.get("email"));
		System.out.println(data.get("gender"));
		
		
	}

}

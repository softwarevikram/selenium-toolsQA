package selenium;

import tests.TestCases;

public class TestDriver {	

	public TestDriver() throws Exception {
		
	}
	
	public static void main (String[] args){	
		String url = "http://toolsqa.wpengine.com/automation-practice-form/";
		int implicitWaitTimeInSeconds = 30;
		
		PageObjects pages = null;
		TestCases testCases = null;
		
		try{
			pages = new PageObjects();
			testCases = new TestCases();
			
			pages.doPreTestActivity();//param -> url, implicitWaitTimeInSeconds		
			testCases.executeTestCases();
//			seUtil.doPostTestActivity();
			
		}catch(Exception e){
			e.printStackTrace();
		}
				
	}

}

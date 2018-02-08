package toolsQA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TCToolsQADataProvider extends FileUpload {
	
	@DataProvider(name="Test_Data")
	public Iterator<Object[]> provideData(){
		List<Object[]> allDataColletion = new ArrayList<Object[]>();
				
		HashMap<String, Object> dataMap = new HashMap<>();				
		dataMap.put("firstName", "First Name");
		dataMap.put("sex", "Male");
//		dataMap.put("filePath_AutoItCompiled_FileUpload", System.getProperty("user.dir") + "\\autoIt\\FileUpload_ToolsQA.exe");
		
		allDataColletion.add(dataMap.entrySet().toArray());
		return allDataColletion.iterator();
	}

	public TCToolsQADataProvider() throws Exception {

	}
	
	@Test(priority = 2, dataProvider="Test_Data")
	public void fillPracticeAutomationForm(Entry<String, Object> one, Entry<String, Object> two) throws Exception{
		System.out.println(one.getKey());
		System.out.println(two.getKey());
		setFirstName(one.getKey());
		chooseSex(two.getKey());
	}
	
/*	@Test(priority = 1, dataProvider="Test_Data")
	public void uploadFile(HashMap<String, Object> data) throws Exception{
		clickOnUploadButton();
		Runtime.getRuntime().exec(data.get("filePath_AutoItCompiled_FileUpload").toString());
	}*/
}

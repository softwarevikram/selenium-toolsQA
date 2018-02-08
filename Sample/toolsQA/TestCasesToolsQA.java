package toolsQA;

import java.util.HashMap;

public class TestCasesToolsQA extends FileUpload {		
		
	HashMap<String, Object> dataMap;
	
	public TestCasesToolsQA() throws Exception {
		dataMap = new HashMap<>();	
		dataMap.put("filePath_AutoItCompiled_FileUpload", System.getProperty("user.dir") + "\\autoIt\\FileUpload_ToolsQA.exe");		
		dataMap.put("firstName", "First Name");
		dataMap.put("sex", "Male");
	}
	
	public void fillPracticeAutomationForm() throws Exception{		
		setFirstName(dataMap.get("name").toString());
		chooseSex(dataMap.get("gender").toString());	
	}
	
	public void uploadFile() throws Exception{
		clickOnUploadButton();
		Runtime.getRuntime().exec(dataMap.get("filePath_AutoItCompiled_FileUpload").toString());
	}
}

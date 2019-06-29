package toolsQA;

import my.lib.SeleniumUtilities;

public class FileUpload extends SeleniumUtilities{	
	
	ORToolsQA objectRepo =null;
			
	public FileUpload()throws Exception{
		objectRepo = new ORToolsQA();
	}

	void clickOnUploadButton() throws Exception{
		clickOn(objectRepo.BTN_BROWSE);
	}
	
	void setFirstName(String firstName) throws Exception{
		setText(objectRepo.TXT_FIRST_NAME, firstName);
	}
	
	void chooseSex(String sex) throws Exception{
		String sexLocator = "Sex #//input[@value='" + sex + "']";
		clickOn(sexLocator);
	}
}

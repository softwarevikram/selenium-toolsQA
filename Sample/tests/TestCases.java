package tests;

import toolsQA.TestCasesToolsQA;

public class TestCases {
	
	TestCasesToolsQA toolsQATCs =null;
	
	public TestCases() throws Exception{
		toolsQATCs = new TestCasesToolsQA();
	}
	
	public void executeTestCases() throws Exception{
	//	toolsQATCs.uploadFile();
		toolsQATCs.fillPracticeAutomationForm();
	}

}

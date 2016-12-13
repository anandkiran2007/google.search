package testcases;


import org.testng.annotations.Test;

import pageObjects.GoogleSearchPageObjects;
import dataProvider.GoogleSearchCsvObjects;
import dataProvider.GoogleSearchDataProvider;
import driverHandler.BaseClass;

public class GoogleSearchTests4 extends BaseClass {

	public GoogleSearchPageObjects loginPage;
	


	@Test(dataProvider = "getSearchData", dataProviderClass=GoogleSearchDataProvider.class)
	public void googleSearchTests4(GoogleSearchCsvObjects data) throws Exception {
		System.out.println("Starting Test case ==" + data.tc_id);
		loginPage =  new GoogleSearchPageObjects(getDriver());
		loginPage.goTo("https://www.google.co.in/");
		loginPage.googleSearch(data.searchString);
		System.out.println("*****End of Test case ******");
	}

}

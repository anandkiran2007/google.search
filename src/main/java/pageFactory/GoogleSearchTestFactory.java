/**
package pageFactory;
import java.io.IOException;

import org.testng.annotations.Factory;

import testcases.GoogleSearchTests;
import dataProvider.GoogleSearchCsvObjects;
import dataProvider.TestDataProvider;

public class GoogleSearchTestFactory {

	//This is the main method for triggering the tests
	
	//This method will first call the "Generic_Data_Provider" for reading the csv and storing the values in Tree Map
	public GoogleSearchTestFactory() throws IOException {
		TestDataProvider.Generic_Data_Provider();
	}
	
	//In this method first our data provider will be called for the class "TestDataProvider"
	// Then Factory will initiate "GoogleSearchTests" class based on number of data we have in csv
	
	// In the example we have 2 rows of records in the csv hence GoogleSearchTests will be called twice 
	@Factory(dataProvider = "SearchData", dataProviderClass=TestDataProvider.class)
	public Object[] RoleAccessTests(GoogleSearchCsvObjects searchData) {
		return new Object[] {new GoogleSearchTests(searchData)};
	}
}
**/
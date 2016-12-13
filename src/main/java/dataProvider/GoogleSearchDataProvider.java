package dataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import org.testng.annotations.DataProvider;
import au.com.bytecode.opencsv.CSVReader;

//This Method is used for reading the csv and saving the data in TreeMap "searchData"
public class GoogleSearchDataProvider {

	public static TreeMap<String, GoogleSearchCsvObjects> searchData = new TreeMap<String, GoogleSearchCsvObjects>();	 

	@SuppressWarnings("resource")
	public static void Generic_Data_Provider() throws IOException {
		List<String[]> scenario_data = new ArrayList<String[]>();
		Reader reader = new FileReader("src/test/resources/GoogleSearchData.csv");
		scenario_data = new CSVReader(reader).readAll();


		Iterator<String[]> it = scenario_data.iterator();
		//Below line will first read the header of the csv
		String[] header = it.next();
		while (it.hasNext()) {
			GoogleSearchCsvObjects data = new GoogleSearchCsvObjects();
			HashMap<String, String> hashItem = new HashMap<String, String>();
			String[] line = it.next();
			//Below for loop will add the data read from csv in Hash Map in the format {"TC_1","Selenium"}
			for (int i = 0; i < line.length; i++) 
				hashItem.put(header[i], line[i]);
			//Then reading the data from hashmap and setting the values to Object "data" which is initializer for class "GoogleSearchCsvObjects"
			data.tc_id 			= hashItem.get("TestCase_ID");
			data.searchString 	= hashItem.get("Search_String");
			searchData.put(data.tc_id, data);
		}
	}
	//This Method is actual dataProvider which will feed the data to @Factory Method
	// This method should always return 2D array 
	@DataProvider(name = "getSearchData")
	public static Object[][] getSearchData() {
		try {
			Generic_Data_Provider();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] storeSearchData = new Object[searchData.size()][1];
		int i = 0;
		for(String key: searchData.keySet()){
			storeSearchData[i++][0] = searchData.get(key);
		}
		return storeSearchData;
	}
}

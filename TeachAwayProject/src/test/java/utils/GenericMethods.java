package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import functionalTestCases.BaseTest;

public class GenericMethods extends BaseTest{
	
	public static int getStatusCode(String testURL) throws IOException {
		URL url = new URL(testURL);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		return connection.getResponseCode();
	}
}

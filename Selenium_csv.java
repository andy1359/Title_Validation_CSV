package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Selenium_csv {
	public static void main(String[] args) throws IOException {
		String csvFile = "./src/main/resources/resource.csv";
		BufferedReader buf = null;
		String str = null;
		String SplitBy = ",";
		String text_case_id = null;
		String url = null;
		String title_expected = null;
		
		buf = new BufferedReader(new FileReader(csvFile));
		
		WebDriver driver = new HtmlUnitDriver();   // Version 1.2 :: HtmlUnit

		try {
			while ((str = buf.readLine()) != null){
			
				String[] csv = str.split(SplitBy);
				text_case_id = csv[0];
				url =csv[1];
				title_expected = csv[2];
				
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();

			if (title_expected.equals(title_actual)) {
				System.out.println("Test Case ID: \t\t" + text_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "PASSED");
			} else {
				System.out.println("Test Case ID: \t\t" + text_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + title_expected);
				System.out.println("Title Actual: \t\t" + title_actual);
				System.out.println("Test Case Result: \t" + "FAILED");
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		buf.close();
	}
}

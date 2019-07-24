package com.testautomation.framework.utilities.utils;

import com.testautomation.framework.base.ConfigTestData;
import com.testautomation.framework.constatnts.GlobalConstants;
import com.testautomation.framework.driverconfig.DriverBase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @Author Bharath
 * @Date 19-march-2018
 */
public class HtmlUtils {

	private DriverBase driverBase=null;

	public HtmlUtils(ConfigTestData configTestData){
		driverBase = new DriverBase(configTestData);
	}

	/*	To get the Link based on Text*/
	public String getLink(String html,String linkText) throws Exception
	{
		String href=null;
		if(html!=null) {
			Document doc = Jsoup.parse(html);
			Elements links = doc.select("a[href]");

			for (Element link_a : links) {
				if (link_a.text().toLowerCase().trim().contains(linkText.toLowerCase().trim())) {
					href = link_a.attr("href");
					break;
				}
			}
		}
		return href;
	}

	/*	To get the Link based on Text*/
	//public String verifyAllLinks() throws Exception	{
//		Document document;
//		String href=null;
//		String url = GlobalConstants.driver.getCurrentUrl();
//		document = Jsoup.connect(url).get();
//		Elements links = document.select("a[href]");
//		WebElement webElement=null;
//		for (Element link_a : links) {
//			href = link_a.attr("href");
//			System.out.println("href:"+href);
//			webElement = GlobalConstants.driver.findElement(By.xpath("//a[@href='"+href+"']"));
//			driverBase.click_JavaScript(webElement);
//			driverBase.navigateBack();
//		}
//		return href;
	//}
	
	
}

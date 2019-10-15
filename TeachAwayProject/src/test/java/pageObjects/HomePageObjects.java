package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import utils.GenericMethods;



public class HomePageObjects{
	
	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	private static final Logger LOGGER = LoggerFactory.getLogger(HomePageObjects.class);
	
	public HomePageObjects(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='container container-fluid-md']/a/img")
	public WebElement logo;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li/span")
	public List<WebElement> firstThreeTabs;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li/a")
	public List<WebElement> lastTwoTabs;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li[1]/span")
	public WebElement firstTab;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li[2]/span")
	public WebElement secondTab;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li[3]/span")
	public WebElement thirdTab;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li[4]/a")
	public WebElement fourthTab;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-nav nav level-0 items-5']/li[5]/a")
	public WebElement fifthTab;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-subnav mega-nav level-1 items-6']/li/a")
	public WebElement jobInnerContentFirstTab;
	
	@FindBy(xpath="(//span[@class='dropdown-toggle tb-megamenu-no-link'])[2]")
	public WebElement jobInnerContentDestinationTab;
	
	@FindBy(xpath="(//span[@class='dropdown-toggle tb-megamenu-no-link'])[3]")
	public WebElement jobInnerContentFeaturedProgramTab;
	
	@FindBy(xpath="(//span[@class='dropdown-toggle tb-megamenu-no-link'])[4]")
	public WebElement jobInnerContentJobOpeningTab;
	
	@FindBy(xpath="(//span[@class='dropdown-toggle tb-megamenu-no-link'])[5]")
	public WebElement jobInnerContentTeachInTheUSTab;
	
	@FindBy(xpath="(//span[@class='dropdown-toggle tb-megamenu-no-link'])[6]")
	public WebElement jobInnerContentCommunityTab;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-subnav mega-nav level-1 items-3']/li/a")
	public List<WebElement> TEFLInnerContent;
	
	@FindBy(xpath="//ul[@class='tb-megamenu-subnav mega-nav level-1 items-2']/li/a")
	public List<WebElement> TeacherCertificationInnerContent;
	
	
	public int headerTabCount() {
		System.out.println(firstThreeTabs.size()+lastTwoTabs.size());
		return firstThreeTabs.size()+lastTwoTabs.size();
	}
	
	public void checkHeaderTabs(String tab) {
		if(tab.equalsIgnoreCase("JOBS")) {
			LOGGER.info(firstTab.getText() +  "======"+tab);
			Assert.assertEquals(firstTab.getText(), tab);
			
		} else if (tab.equalsIgnoreCase("TEFL")) {
			LOGGER.info(secondTab.getText() +  "======"+tab);
			Assert.assertEquals(secondTab.getText(), tab);
			
		} else if (tab.equalsIgnoreCase("TEACHER CERTIFICATION")) {
			LOGGER.info(thirdTab.getText() +  "======"+tab);
			Assert.assertEquals(thirdTab.getText(), tab);
			
		} else if (tab.equalsIgnoreCase("COURSES")) {
			LOGGER.info(fourthTab.getText() +  "======"+tab);
			Assert.assertEquals(fourthTab.getText(), tab);
			
		} else if (tab.equalsIgnoreCase("HIRE TEACHERS")) {
			LOGGER.info(fifthTab.getText() +  "======"+tab);
			Assert.assertEquals(fifthTab.getText(), tab);
			
		} 
	}

	public String logoURL() {
		LOGGER.info("LOGO URL = "+logo.getAttribute("src"));
		return logo.getAttribute("src");
	}
	
	public void mouseHover(String tab) {
		
		act = new Actions(driver);
		
		if(tab.equalsIgnoreCase("JOBS")) {
			LOGGER.info("Hovering On "+tab);
			act.moveToElement(firstTab).build().perform();
			
		} else if (tab.equalsIgnoreCase("TEFL")) {
			LOGGER.info("Hovering On "+tab);
			act.moveToElement(secondTab).build().perform();
			
		} else if (tab.equalsIgnoreCase("TEACHER CERTIFICATION")) {
			LOGGER.info("Hovering On "+tab);
			act.moveToElement(thirdTab).build().perform();
			
		} 
		
	}
	
	public void explicitWait(WebElement element) {
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void checkInnerContent(String tab){
		
		if(tab.equalsIgnoreCase("JOBS")) {
			
			LOGGER.info("Checking tab "+tab);
			
			for(int i=0;i<6;i++) {
				if(i==0) {
					LOGGER.info("URL of Job Board ="+jobInnerContentFirstTab.getAttribute("href"));
					Assert.assertEquals(jobInnerContentFirstTab.getAttribute("href"), "https://www.teachaway.com/teaching-jobs-abroad");
					
				}
				else if(i==1) {
					explicitWait(jobInnerContentDestinationTab);
					LOGGER.info("Text of Second tab in Jobs ="+jobInnerContentDestinationTab.getText());
					Assert.assertEquals(jobInnerContentDestinationTab.getText(), "Destinations");
					
				} else if(i==2) {
					explicitWait(jobInnerContentFeaturedProgramTab);
					LOGGER.info("Text of Third tab in Jobs ="+jobInnerContentFeaturedProgramTab.getText());
					Assert.assertEquals(jobInnerContentFeaturedProgramTab.getText(), "Featured Programs");
					
				} else if(i==3) {
					explicitWait(jobInnerContentJobOpeningTab);
					LOGGER.info("Text of Fourth tab in Jobs ="+jobInnerContentJobOpeningTab.getText());
					Assert.assertEquals(jobInnerContentJobOpeningTab.getText(), "Job Openings");
					
				} else if(i==4) {
					explicitWait(jobInnerContentTeachInTheUSTab);
					LOGGER.info("Text of Fifth tab in Jobs ="+jobInnerContentTeachInTheUSTab.getText());
					Assert.assertEquals(jobInnerContentTeachInTheUSTab.getText(), "Teach in the US");
					
				} else if(i==5) {
					explicitWait(jobInnerContentCommunityTab);
					LOGGER.info("Text of Sixth tab in Jobs ="+jobInnerContentCommunityTab.getText());
					Assert.assertEquals(jobInnerContentCommunityTab.getText(), "Community");
					
				}
				
			}
			
			
		}
		
		
		
		if(tab.equalsIgnoreCase("TEFL")) {
			
			for(int i=0;i<TEFLInnerContent.size();i++) {
				if(i==0) {
					LOGGER.info("URL of TEFL Courses = "+TEFLInnerContent.get(i).getAttribute("href"));
					Assert.assertEquals(TEFLInnerContent.get(i).getAttribute("href"), "https://www.teachaway.com/courses/online-tefl-certification");
				}else if (i==1) {
					LOGGER.info("URL of TEFL Certification Guide = "+TEFLInnerContent.get(i).getAttribute("href"));
					Assert.assertEquals(TEFLInnerContent.get(i).getAttribute("href"), "https://www.teachaway.com/tefl-certification");
				}
			}
			
		}
		
		if(tab.equalsIgnoreCase("TEACHER CERTIFICATION")) {
			for(int i=0;i<TeacherCertificationInnerContent.size();i++) {
				if(i==0) {
					LOGGER.info("URL of Certification Program = "+TeacherCertificationInnerContent.get(i).getAttribute("href"));
					Assert.assertEquals(TeacherCertificationInnerContent.get(i).getAttribute("href"), "https://www.teachaway.com/courses/teacher-certification-program");
				}else if (i==1) {
					LOGGER.info("URL of Teacher Certification Guide = "+TeacherCertificationInnerContent.get(i).getAttribute("href"));
					Assert.assertEquals(TeacherCertificationInnerContent.get(i).getAttribute("href"), "https://www.teachaway.com/alternative-teacher-certification");
			}
		 }
		}
		
		if(tab.equalsIgnoreCase("COURSES")) {
			LOGGER.info("URL of Courses = "+fourthTab.getAttribute("href"));
			Assert.assertEquals(fourthTab.getAttribute("href"), "https://www.teachaway.com/courses-and-certifications");
		
		}
		
		if(tab.equalsIgnoreCase("HIRE TEACHERS")) {
			LOGGER.info("URL of HIRE TEACHERS = "+fifthTab.getAttribute("href"));
			Assert.assertEquals(fifthTab.getAttribute("href"), "https://www.teachaway.com/recruitment");
		
		}
	}
	
}

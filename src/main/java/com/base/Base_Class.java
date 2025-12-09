package com.base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;    


public class Base_Class {

    public static WebDriver driver;

    // 1. Browser launch()
    public static WebDriver launchBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                Assert.fail("Unsupported browser: " + browserName); 
            }

            driver.manage().window().maximize();

        } catch (Exception e) {
            Assert.fail("ERROR:OCCURED DURING URL LAUNCH");
        }
        return driver;
    }

    
    public static void launchUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            Assert.fail("ERROR DURING URL LAUNCH: " + e.getMessage());
        }
    }

  
    public static void closeBrowser() {
        try {
            driver.close();
        } catch (Exception e) {
            Assert.fail("ERROR:OCCURED DURING URL LAUNCH "  );
        }
    }

 
    public static void quitBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            Assert.fail("ERROR DURING BROWSER QUIT: " + e.getMessage());
        }
    }

    public static void geturl(String url) {
    	try {
    		driver.get(url);
    	}catch(Exception e) {
    		Assert.fail("ERROR : OCCURED DURING URL LAUNCH");
    	}
    }

    public static void navigateTo(String url) {
    	try {
    		driver.navigate().to(url);
    	}catch(Exception e) {
    		Assert.fail("ERROR : OCCURED DURING URL LAUNCH");
    		
    	}
    }
    
    public static void navigateBack(String url) {
    try {
    	driver.navigate().back();
    }catch(Exception e) {
    	Assert.fail("ERROR : OCCURED DURING URL LAUNCH");
        }
    
    }
    
    public static void navigateForward(String url) {
    	try{
    		driver.navigate().forward();
    	}catch(Exception e) {
    		Assert.fail("ERROR : OCCURED DURING URL LAUNCH");
    	}
    }
    
    public static void navigateRefresh() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            Assert.fail("ERROR: NAVIGATE REFRESH FAILED");
        }
    }
    public static String getTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            Assert.fail("ERROR: GET TITLE FAILED");
            return null;
        }
    }
    public static String getCurrentUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            Assert.fail("ERROR: GET CURRENT URL FAILED");
            return null;
        }
    }
    public static String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            Assert.fail("ERROR: GET TEXT FAILED");
            return null;
        }
    }
    public static String getAttribute(WebElement element, String name) {
        try {
            return element.getAttribute(name);
        } catch (Exception e) {
            Assert.fail("ERROR: GET ATTRIBUTE FAILED");
            return null;
        }
    }
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR: CLICK FAILED");
        }
    }
    public static void sendKeys(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR: SENDKEYS FAILED");
        }
    }
    public static boolean isEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            Assert.fail("ERROR: IS ENABLED FAILED");
            return false;
        }
    }
    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            Assert.fail("ERROR: IS DISPLAYED FAILED");
            return false;
        }
    }
    public static void robotEnter() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            Assert.fail("ERROR: ROBOT ENTER KEY ACTION FAILED");
        }
    }
    public static void implicitWait(long seconds) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        } catch (Exception e) {
            Assert.fail("ERROR: IMPLICIT WAIT FAILED");
        }
    }

    
    
    
}

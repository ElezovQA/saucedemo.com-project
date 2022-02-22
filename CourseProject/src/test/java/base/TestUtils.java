package base;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static java.lang.Integer.parseInt;

public class TestUtils {
    public WebDriver driver;
    private String applicationUrl, browser;
    private int implicitWaitSeconds;

    @BeforeMethod
public void setUp(){
        setUpBrowserDriver();
        loadInitialPage();
    }

    private void loadInitialPage() {
        driver.get(applicationUrl);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    private void setUpBrowserDriver(){
        try{
            FileInputStream configFile = new
                    FileInputStream("src/test/resources/config.properties");
            Properties config = new Properties();
            config.load(configFile);
            applicationUrl = config.getProperty("url");
            implicitWaitSeconds = parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("targetBrowser");
        }catch (IOException e){
            System.out.println(e);
        }

        switch (browser){
            case "chrome":
                driver = DriverFactory.getChromeDriver(implicitWaitSeconds);
                break;
            case "firefox":
                driver = DriverFactory.getFireFoxDriver(implicitWaitSeconds);
                break;
        }
    }
}

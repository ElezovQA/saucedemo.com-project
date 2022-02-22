package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement lgnBtn;

    @FindBy(className = "title")
    private WebElement productsTitle;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductsPage login(String username, String password){
        userNameInput.clear();
        userNameInput.sendKeys(username);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        lgnBtn.click();

        return new ProductsPage(driver);
    }
}

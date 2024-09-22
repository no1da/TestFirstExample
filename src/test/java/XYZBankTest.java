import Page.XYZBank;
import Util.GeneratePostCodeName;
import Util.Table;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class XYZBankTest {
    private WebDriver driver;
    private XYZBank xyzBank;
    String postCode = GeneratePostCodeName.generatePostCode();
    String firstName = GeneratePostCodeName.convertToName(postCode);


    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        xyzBank = new XYZBank(driver);
        String heading = xyzBank.getHeading();
        Assert.assertEquals("XYZ Bank", heading);
    }

    @Test
    public void testAdd() {
        xyzBank.add(firstName,"Snape", postCode);
    }

    @Test
    public void testSort() {
        xyzBank.sort();
    }

    @Test
    public void testDelete() {
        xyzBank.customers();
        WebElement tableElement = driver.findElement(By.xpath("//table[@class = 'table table-bordered table-striped']/tbody"));
        Table table = new Table(tableElement, driver);
        xyzBank.delete(table.getNames());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}

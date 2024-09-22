package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XYZBank {
    private WebDriver driver;
    private By openAdd = By.xpath("//button[@ng-class='btnClass1']");
    private By firstName = By.xpath("//input[@ng-model='fName']");
    private By lastName = By.xpath("//input[@ng-model='lName']");
    private By postCode = By.xpath("//input[@ng-model='postCd']");
    private By addCustomer = By.xpath("//button[@type='submit']");
    private By customers = By.xpath("//button[@ng-class='btnClass3']");
    private By sortFirstName = By.cssSelector("a[ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\"]");
    private String nameForRemove;
    /*private By deleteCust = By.xpath("//td[text()='" + nameForRemove + "']/ancestor::tr/td/button[@ng-click='deleteCust(cust)']");*/
    private By heading = By.xpath("//strong[@class='mainHeading']");

    public XYZBank(WebDriver driver) {
        this.driver = driver;
    }

    public XYZBank clickOpenAdd() {
        driver.findElement(openAdd).click();
        return this;
    }

    public XYZBank typeFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
        return this;
    }

    public XYZBank typeLastName(String last) {
        driver.findElement(lastName).sendKeys(last);
        return this;
    }

    public XYZBank typePostCode(String code) {
        driver.findElement(postCode).sendKeys(code);
        return this;
    }

    public XYZBank addCustomer() {
        driver.findElement(addCustomer).click();
        return this;
    }

    public XYZBank allertOk() {
        driver.switchTo().alert().accept();
        return this;
    }

    public XYZBank add(String firstName, String lastName, String postCode) {
        this.clickOpenAdd();
        this.typeFirstName(firstName);
        this.typeLastName(lastName);
        this.typePostCode(postCode);
        this.addCustomer();
        this.allertOk();
        return new XYZBank(driver);
    }

    public XYZBank customers() {
        driver.findElement(customers).click();
        return this;
    }

    public XYZBank sortFirstName() {
        driver.findElement(sortFirstName).click();
        return this;
    }

    public XYZBank sort() {
        this.customers();
        this.sortFirstName();
        return new XYZBank(driver);
    }

/*    public XYZBank nameForRemove(String name) {
        nameForRemove=name;
        return this;
    }*/
    public XYZBank deleteCust(String nameForRemove) {
        By deleteCust = By.xpath("//td[text()='" + nameForRemove + "']/ancestor::tr/td/button[@ng-click='deleteCust(cust)']");
        driver.findElement(deleteCust).click();
        return this;
    }

    public XYZBank delete(String nameForRemove) {
        this.deleteCust(nameForRemove);
        return new XYZBank(driver);
    }

    public String getHeading() {
        return driver.findElement(heading).getText();
    }



}

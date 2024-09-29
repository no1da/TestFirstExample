package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс для представления страницы добавления клиента (Add Customer).
 * <p>
 * Этот класс содержит методы и локаторы для взаимодействия
 * с элементами страницы добавления клиента. Он наследует
 * функционал базового класса BasePage.
 * </p>
 */
public class AddCustomerPage extends BasePage {
    /**
     * Локаторы для взаимодействия с вкладкой добавления клиента
     */
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    private WebElement openAdd;
    @FindBy(xpath = "//input[@ng-model='fName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@ng-model='lName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@ng-model='postCd']")
    private WebElement postCode;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addCustomer;
    /**
     * Конструктор для инициализации страницы добавления клиента.
     *
     * @param driver WebDriver для управления браузером.
     */
    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }
    /**
     * Метод для заполнения полей и добавления клиента.
     */
    public void fillFieldsAndAddCustomer(String firstNameText, String lastNameText, String postCodeText) {
        openAdd.click();
        firstName.sendKeys(firstNameText);
        lastName.sendKeys(lastNameText);
        postCode.sendKeys(postCodeText);
        addCustomer.click();
    }
    /**
     * Принимает текущее предупреждение (alert) в браузере.
     * <p>
     * Метод переключается на текущее предупреждение и
     * подтверждает его, вызывая метод accept() из базового класса.
     * </p>
     */
    @Override
    public void alertAccept() {
        super.alertAccept();
    }
    /**
     * Метод для открытия вкладки клиентов.
     * <p>
     * Метод инициирует клик по кнопке, чтобы открыть
     * соответствующую страницу клиентов.
     * </p>
     */
    @Override
    public void openCustomers() {
        super.openCustomers();
    }
}
package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Класс для представления базовой страницы.
 * <p>
 * Этот класс содержит общий функционал для всех страниц приложения
 * и предназначен для упрощения и централизованного управления
 * взаимодействиями с элементами страницы.
 * </p>
 */
public class BasePage {
    protected WebDriver driver;
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    private WebElement customers;
    /**
     * Конструктор для инициализации базовой страницы.
     *
     * @param driver WebDriver для управления браузером.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * Принимает текущее предупреждение (alert) в браузере.
     * <p>
     * Метод переключается на текущее предупреждение и
     * подтверждает его, вызывая метод accept().
     * </p>
     */
    public void alertAccept() {
        driver.switchTo().alert().accept();
    }
    /**
     * Метод для открытия вкладки клиентов.
     * <p>
     * Метод инициирует клик по кнопке, чтобы открыть
     * соответствующую страницу клиентов.
     * </p>
     */
    public void openCustomers() {
        customers.click();
    }
    /**
     * Метод для поиска клиента по имени.
     *
     * @param name имя клиента для поиска.
     * @return true, если клиент найден, иначе false.
     */
    public boolean findCustomerByName(String name) {
        String xpath = String.format("//td[text()='%s']", name);
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        return !elements.isEmpty();
    }
}


package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Класс для представления страницы клиентов (Customers).
 * <p>
 * Этот класс обрабатывает все взаимодействия с элементами на
 * странице клиентов, включая открытие вкладки, сортировку клиентов,
 * поиск клиентов и их удаление. Он наследует
 * функционал базового класса BasePage.
 * </p>
 */
public class CustomersPage extends BasePage {
    /**
     * Локаторы для взаимодействия с вкладкой клиентов
     */
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    private WebElement customers;
    @FindBy(css = "a[ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\"]")
    private WebElement sortFirstName;
    @FindBy(xpath = "//table[@class = 'table table-bordered table-striped']/tbody")
    private WebElement tableElement;
    /**
     * Конструктор для инициализации страницы клиентов.
     *
     * @param driver WebDriver для управления браузером.
     */
    public CustomersPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Метод для открытия вкладки Customers.
     */
    public void openCustomers() {
        customers.click();
    }

    /**
     * Метод для сортировки клиентов по имени.
     */
    public void sortFirstName() {
        sortFirstName.click();
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

    /**
     * Метод для удаления клиента по имени.
     *
     * @param nameForRemove имя клиента, которого нужно удалить.
     */
    public void deleteCust(String nameForRemove) {
        String xpath = String.format("//td[text()='%s']/ancestor::tr/td/button[@ng-click='deleteCust(cust)']", nameForRemove);
        WebElement deleteCustButton = driver.findElement(By.xpath(xpath));
        deleteCustButton.click();
    }
    /**
     * Метод для получения элемента таблицы клиентов.
     *
     * @return элемент таблицы клиентов.
     */
    public WebElement getTableElement() {
        return tableElement;
    }
}
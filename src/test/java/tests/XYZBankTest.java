package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import page.AddCustomerPage;
import page.CustomersPage;
import util.GeneratePostCodeName;
import util.Table;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Класс тестирования функциональности XYZBank.
 *
 * <p>Этот класс содержит тесты, которые проверяют различные функции банка XYZ,
 * включая добавление клиентов. Каждый тест выполняется в собственном экземпляре
 * веб-драйвера, который открывает веб-приложение банка и взаимодействует с его
 * элементами.</p>
 *
 * <p>Тесты используют аннотации JUnit 5 для настройки и выполнения тестов.</p>
 */
public class XYZBankTest extends BaseTest {
    /**
     * Поле генерации Post code
     */
    private String postCode = GeneratePostCodeName.generatePostCode();
    /**
     * Поле генерации First name
     */
    private String firstName = GeneratePostCodeName.convertToName(postCode);
    /**
     * Объекты вкладок страницы XYZBank
     */
    private AddCustomerPage addCustomerPage;
    private CustomersPage customersPage;

    /**
     * Тест добавления клиента в банк.
     *
     * <p>Этот тест заполняет необходимые поля для добавления нового клиента,
     * открывает таблицу клиентов и проверяет, был ли успешно добавлен клиент
     * с указанным именем.</p>
     */
    @Test
    @Step("Тестирование функции добавления клиента")
    public void addCustomerTest() {
        addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.fillFieldsAndAddCustomer(firstName, config.getLastName(), postCode);
        addCustomerPage.alertAccept();
        addCustomerPage.openCustomers();
        assertTrue(addCustomerPage.findCustomerByName(firstName));
    }

    /**
     * Тестирует сортировку имен клиентов в таблице.
     *
     * <p>
     * Этот тест открывает список клиентов, получает начальный порядок имен,
     * сортирует их по имени, и затем проверяет, изменился ли порядок имен
     * после сортировки.
     * </p>
     */
    @Test
    @Step("Тестирование функции сортировки по имени в обратном алфавитном порядке ")
    public void sortCustomersTest() {
        customersPage = new CustomersPage(driver);
        customersPage.openCustomers();
        Table table = new Table(customersPage.getTableElement(), driver);
        List<String> initialSortNames = table.getAllNames();
        customersPage.sortFirstName();
        List<String> finalSortNames = table.getAllNames();
        assertFalse(initialSortNames.equals(finalSortNames));
    }

    /**
     * Тестирует удаление клиента из списка.
     *
     * <p>
     * Этот тест открывает список клиентов, получает имя клиента для удаления,
     * удаляет клиента и проверяет, что клиент больше не существует в таблиц.
     * </p>
     */
    @Test
    @Step("Тестирование функции удаления клиента")
    public void deleteCustomerTest() {
        customersPage = new CustomersPage(driver);
        customersPage.openCustomers();
        Table table = new Table(customersPage.getTableElement(), driver);
        String nameFoRemove = table.getNamesForRemove();
        customersPage.deleteCust(nameFoRemove);
        assertFalse(customersPage.findCustomerByName(nameFoRemove));
    }
}

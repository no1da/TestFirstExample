package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

/**
 * Класс для взаимодействия с таблицей вкладки Customers.
 * <p>
 * Этот класс предоставляет методы для работы с таблицей клиентов, включая получение
 * имен клиентов для удаления и получение списка всех имен клиентов.
 * </p>
 */
public class Table {

    private WebElement tableElement;
    private WebDriver driver;
    /**
     * Создаёт объект класса Table.
     *
     * @param tableElement элемент таблицы, с которым будет производиться взаимодействие.
     * @param driver       экземпляр WebDriver для выполнения действий с веб-страницей.
     */
    public Table(WebElement tableElement, WebDriver driver) {
        this.tableElement = tableElement;
        this.driver = driver;
    }
    /**
     * Метод для получения имени клиента, у которого длина совпадает с
     * средней длиной имен в таблице.
     *
     * <p>
     * Метод сначала получает список всех имен из таблицы, затем вычисляет
     * среднюю длину этих имен и выбирает первое имя, длина которого
     * близка к средней.
     * </p>
     *
     * @return имя клиента, соответствующее критериям, или null,
     * если имя не найдено или таблица пуста.
     */
    public String getNamesForRemove() {
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr/td[1]"));
        List<String> names = rows
                .stream()
                .map(WebElement::getText)
                .toList();
        if (names.isEmpty()) {
            return null;
        }
        double averageLength = names.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
        return names.stream()
                .filter(name -> Math.abs(name.length() - averageLength) < 2) // Порог близости
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод для получения списка имен всех клиентов.
     *
     * <p>
     * Метод извлекает имена каждого клиента из таблицы и возвращает их
     * в виде списка строк.
     * </p>
     *
     * @return список имен клиентов, найденных в таблице.
     */
    public List<String> getAllNames() {
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr/td[1]"));
        List<String> names = rows
                .stream()
                .map(WebElement::getText)
                .toList();

        return names;
    }
}

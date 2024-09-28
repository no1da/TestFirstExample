package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Класс для работы с конфигурационными свойствами.
 * <p>
 * Этот класс загружает свойства из файла config.properties
 * и предоставляет методы для доступа к ним.
 * </p>
 */
public class Config {
    private Properties properties;
    /**
     * Конструктор класса Config.
     * <p>
     * Конструктор загружает свойства из файла config.properties.
     * Если файл не найден, выводится предупреждение в консоль.
     * </p>
     */
    public  Config() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Получает URL страницы из конфигурационных свойств.
     *
     * @return строка, представляющая URL страницы.
     */
    public String getAppUrl() {
        return properties.getProperty("app.url");
    }
    /**
     * Получает Last Name из конфигурационных свойств.
     *
     * @return строка, представляющая Last Name.
     */
    public String getLastName() {
        return properties.getProperty("last.name");
    }
}

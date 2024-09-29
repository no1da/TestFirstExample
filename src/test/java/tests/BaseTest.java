package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Config;

import java.util.concurrent.TimeUnit;

/**
 * Базовый класс для тестирования функциональности.
 * <p>Этот класс содержит общие настройки для всех тестов,
 * такие как инициализация и завершение работы веб-драйвера.</p>
 */
public class BaseTest {
    protected WebDriver driver;
    protected Config config;

    /**
     * Метод, выполняющийся перед каждым тестом.
     *
     * <p>Этот метод инициализирует веб-драйвер, открывает приложение,
     * устанавливает неявное ожидание и разворачивает окно браузера
     * на полный экран.</p>
     */
    @BeforeEach
    public void setUp() {
        config = new Config();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(config.getAppUrl());
        driver.manage().window().maximize();
    }

    /**
     * Очищает ресурсы после выполнения каждого теста.
     *
     * <p>Этот метод вызывается после каждого теста для завершения работы
     * драйвера, используемого для взаимодействия с веб-приложением.</p>
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

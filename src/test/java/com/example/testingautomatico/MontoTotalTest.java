package com.example.testingautomatico;

/* import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not; */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class MontoTotalTest {
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=/home/seluser/.config/google-chrome/Default");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void testTest(){

    }

    @Test
    public void testMontoTotal() {
        driver.get("https://articulo.mercadolibre.com.ar/MLA-1115579368-mousepad-l-60x285cm-lol-cod002-jinx-_JM?variation=173996929650#reco_item_pos=0&reco_backend=machinalis-homes-pdp-boos&reco_backend_type=function&reco_client=home_navigation-trend-recommendations&reco_id=a9e07b50-efac-47a0-b8df-c798013f39c5&c_id=/home/navigation-trends-recommendations/element&c_element_order=1&c_uid=1012ed16-ab8c-444a-9fbe-52d52c071cd1");
        driver.manage().window().setSize(new Dimension(1366, 768));

//        js.executeScript("window.scrollTo(0,455)");
//        js.executeScript("window.scrollTo(0,813)");


        WebElement precioUnitarioElemento = driver.findElement(By.cssSelector(".andes-money-amount__fraction"));

        // atrapar boton
        WebElement agregarAlCarritoBtn = driver.findElement(By.cssSelector(".andes-button__content"));

        js.executeScript("return arguments[0].scrollIntoView({inline:'center',block:'center',behavior:'smooth'});", agregarAlCarritoBtn);

        int precioUnitario = Integer.parseInt(precioUnitarioElemento.getText().replace(".",""));

        assertNotNull(precioUnitario);

        driver.findElement(By.cssSelector(".andes-button--quiet > .andes-button__content")).click();
        driver.findElement(By.cssSelector("#button1 .andes-button__text")).click();
        driver.findElement(By.name("push")).click();


//        assertEquals(driver.findElement(By.cssSelector(".price-tag-fraction")), (precioUnitario*2).toString());
    }
}
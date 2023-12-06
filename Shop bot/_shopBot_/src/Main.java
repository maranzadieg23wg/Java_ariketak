import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComprarEntradasBot {
    public static void main(String[] args) {
        // Ruta al driver de Chrome. Asegúrate de tenerlo descargado.
        System.setProperty("webdriver.chrome.driver", "ruta/al/driver/chromedriver");

        // Inicializar el WebDriver (ChromeDriver en este caso)
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Navegar a la página de las entradas
        driver.get("https://www.bataplandisco.com/tickets/#/es/event/bataplan-university-electro-latino--143322");

        // Encontrar y hacer clic en el elemento con la clase especificada
        WebElement cardElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".StyledContainer-sc-sdy56u-0.Box-sc-sdy56u-3.Card-sc-1gnzppj-0.jjiLOQ.kRjbYe")));
        cardElement.click();

        // Hacer clic tres veces en el botón con la primera clase especificada
        for (int i = 0; i < 3; i++) {
            WebElement firstButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".Button-sc-j1txxp-0.byrjOq")));
            firstButton.click();
        }

        // Hacer clic en el segundo botón
        WebElement secondButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".Button-sc-j1txxp-0.dWQHGC")));
        secondButton.click();

        // Completar los campos de nombre, apellidos, email y confirmar email
        WebElement nombreField = driver.findElement(By.cssSelector("input[placeholder='Nombre']"));
        nombreField.sendKeys("Manex");

        WebElement apellidosField = driver.findElement(By.cssSelector("input[placeholder='Apellidos']"));
        apellidosField.sendKeys("Aranzadi Egaña");

        WebElement emailField = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        emailField.sendKeys("manexae@gmail.com");

        WebElement confirmarEmailField = driver.findElement(By.cssSelector("input[placeholder='Confirmar email']"));
        confirmarEmailField.sendKeys("manexae@gmail.com");

        // Hacer clic en el botón con el ID especificado
        WebElement checkoutButton1 = driver.findElement(By.id("checkout-btn"));
        checkoutButton1.click();

        // Completar la información de tarjeta de crédito
        WebElement numeroTarjetaField = driver.findElement(By.cssSelector("input[placeholder='1234 5678 9012 3456']"));
        numeroTarjetaField.sendKeys("1234");

        WebElement fechaExpiracionField = driver.findElement(By.cssSelector("input[placeholder='MM/YY']"));
        fechaExpiracionField.sendKeys("22/44");

        WebElement codigoSeguridadField = driver.findElement(By.cssSelector("input[placeholder='3 digits']"));
        codigoSeguridadField.sendKeys("432");

        WebElement titularTarjetaField = driver.findElement(By.cssSelector("input[placeholder='J.Smith']"));
        titularTarjetaField.sendKeys("manexae");

        // Hacer clic en el segundo botón de checkout
        WebElement checkoutButton2 = driver.findElement(By.id("checkout-btn"));
        checkoutButton2.click();

        // Cerrar el navegador
        driver.quit();
    }
}

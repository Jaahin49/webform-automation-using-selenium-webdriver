import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FormAutomation {
    WebDriver driver;
    @BeforeAll
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @DisplayName("Visit the website and get title")
    @Test
    public void getTitle(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        String actual_title= driver.getTitle();
        System.out.println(actual_title);
    }
//    @DisplayName("Visit the website and go to about section")
//    @Test
//    public void aboutSection(){
//        driver.get("https://www.digitalunite.com/practice-webform-learners");
//        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/header/div/div[3]/div/div/nav/div/ul/li[1]/div[1]/span")).click();
//        driver.findElement(By.xpath("//*[@id=\"tbm-main\"]/div/ul/li[1]/div[2]/div/div/div/ul/li[1]/div/a")).click();
//    }
    @DisplayName("Get heading")
    @Test
    public void getText(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        String actual_text = driver.findElement(By.xpath("//*[@id=\"block-pagetitle\"]/h1/span")).getText();
        String expected_text = "Practice webform for learners";
        Assertions.assertEquals(actual_text,expected_text);
        System.out.println("Test Done");
    }
    @DisplayName("Visit the website and submit form")
    @Test
    public void submitForm(){
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        //driver.switchTo().frame("GTM-NVLNJSW");
        driver.findElement(By.xpath("//input[@id='edit-name']")).sendKeys("Naymur Rashid");
        driver.findElement(By.xpath("//input[@id='edit-number']")).sendKeys("01715334291");
        Utils.doScroll(driver);
        driver.findElement(By.cssSelector("label[for='edit-agnew-30-40']")).click();
        driver.findElement(By.xpath("//input[@id='edit-date']")).sendKeys("07/15/2023");
        driver.findElement(By.xpath("//input[@id='edit-email']")).sendKeys("contact.naymur@gmail.com");
        Utils.doScroll(driver);
        driver.findElement(By.xpath("//textarea[@id='edit-tell-us-a-bit-about-yourself-']")).sendKeys("I`m a very hardworking person");
        driver.findElement(By.xpath("//input[@id='edit-uploadocument-upload']")).sendKeys("F:\\Downloads\\230215202324SOMYL8DKZ4EW.pdf");
        driver.findElement(By.cssSelector(".form-checkbox.required")).click();
        driver.findElement(By.id("edit-submit")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.get("https://www.digitalunite.com/node/5932/webform/confirmation?token=OSDg-AQFpN2RsZQI1DReqUr9aoH3SRvJSzEIZhvYnxM");
        String title_actual = driver.findElement(By.xpath("//*[@id=\"block-pagetitle\"]/h1")).getText();
        System.out.println(title_actual);
        String title_expected = "Thank you for your submission!";
        Assertions.assertEquals(title_actual,title_expected);
        System.out.println("Testing complete");
    }
    @AfterAll
    public void closeDriver(){
        driver.close();
    }
}

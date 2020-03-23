import java.sql.SQLOutput;
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import javafx.util.Pair;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Lab2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://103.120.226.190/selenium-demo/git-repo";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLab2() throws Exception {
    List<Pair<String,String>> check_content=read_excel.read_xlsx();
    System.out.println(check_content);
    driver.get(baseUrl);
    for(Pair<String,String> ck:check_content){
      System.out.println(ck.getKey()+" "+ck.getValue());

      driver.findElement(By.name("user_number")).clear();
      driver.findElement(By.name("user_number")).sendKeys(ck.getKey());
      driver.findElement(By.name("password")).clear();
      driver.findElement(By.name("password")).sendKeys(ck.getValue());
      driver.findElement(By.xpath("//input[@value='Query']")).click();
      Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code")).getText(),ck.getValue());

    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

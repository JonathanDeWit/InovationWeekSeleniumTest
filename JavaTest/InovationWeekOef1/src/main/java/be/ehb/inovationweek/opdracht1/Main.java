package be.ehb.inovationweek.opdracht1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {

    //experimenteel bestand
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("http://127.0.0.1:5501/HTML/registratie.html");

        //Voornaam input
        driver.findElement(By.id(("Voornaam_Input"))).sendKeys("Jonathan");

        //Achternaam input
        driver.findElement(By.id(("Achternaam_Input"))).sendKeys("De Wit");

        //Telefoon input
        driver.findElement(By.id(("Phone_Input"))).sendKeys("047732547");

        //Date Input
        driver.findElement(By.id(("Date_Input"))).sendKeys("21092021");

        //Straat Input
        driver.findElement(By.id(("Straat_Input"))).sendKeys("Veldstraat");

        //Nummer Input
        driver.findElement(By.id(("Nummer_Input"))).sendKeys("31");

        //Boxnummer Input
        driver.findElement(By.id(("Boxnummer_Input"))).sendKeys("2");

        //Postcode Input
        driver.findElement(By.id("Postcode_Input")).sendKeys("9000");


        //Opleiding Select
        Select opleidingDropDown = new Select(driver.findElement(By.id("Opleidingen")));
        opleidingDropDown.selectByVisibleText("Multimedia");

        //Selecteer Vacken
        driver.findElement(By.id("Development_I_Check")).click();
        driver.findElement(By.id("Grow_I_Check")).click();

        //submit
        driver.findElement(By.id("Send_bt")).click();





    }
}

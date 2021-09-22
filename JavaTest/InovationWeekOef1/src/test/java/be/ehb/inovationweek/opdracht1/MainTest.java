package be.ehb.inovationweek.opdracht1;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MainTest {

    public static WebDriver driver = null;

    public static String voornaam;
    public static String achternaam;
    public static String telefoonnummer;
    public static String geboortedatum;
    public static String straatnaam;
    public static String nummer;
    public static String boxnummer;
    public static String postcode;
    public static String opleidingen;
    public static ArrayList<String> vakken = new ArrayList<>();


    @BeforeAll
    public static void initTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //Data voor de test
        voornaam = "Jonathan";
        achternaam = "De Wit";
        telefoonnummer = "0477325473";
        geboortedatum = "21-09-2021";
        straatnaam = "Veldstraat";
        nummer = "31";
        boxnummer = "2";
        postcode = "9000";
        opleidingen = "Multimedia";

        List<String> vakkenLijst = Arrays.asList("Development I","Grow I");
        vakken.addAll(vakkenLijst);
    }

    @Test
    void TestA_InvullenFormulier(){

        //Het formulier invullen en verzenden.

        //deze website werd locaal gehost
        driver.get("http://127.0.0.1:5500/HTML/registratie.html");

        //Voornaam input
        try{
            driver.findElement(By.id(("Voornaam_Input"))).sendKeys(voornaam);
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Voornaam_Input niet.");
        }

        //Achternaam input
        try{
            driver.findElement(By.id(("Achternaam_Input"))).sendKeys(achternaam);
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Achternaam_Input niet.");
        }

        //Telefoon input
        try{
            driver.findElement(By.id(("Phone_Input"))).sendKeys(telefoonnummer);
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Phone_Input niet.");
        }

        //Date Input
        try{
            driver.findElement(By.id(("Date_Input"))).sendKeys(geboortedatum);
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Date_Input niet.");
        }

        //Straat Input
        try{
            driver.findElement(By.id(("Straat_Input"))).sendKeys(straatnaam);
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Straat_Input niet.");
        }

        //Nummer Input
        try{
            driver.findElement(By.id(("Nummer_Input"))).sendKeys(nummer);
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Straat_Input niet.");
        }

        //Boxnummer Input
        try{
            driver.findElement(By.id(("Boxnummer_Input"))).sendKeys(boxnummer);
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Boxnummer_Input niet.");
        }

        //Postcode Input
        try{
            driver.findElement(By.id("Postcode_Input")).sendKeys(postcode);
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Postcode_Input niet.");
        }

        //Opleiding Select
        try {
            Select opleidingDropDown = new Select(driver.findElement(By.id("Opleidingen")));
            opleidingDropDown.selectByVisibleText(opleidingen);
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Multimedia niet.");
        }

        //Selecteer Vacken
        for (var vak:vakken) {
            try{
                driver.findElement(By.id(vak+"_Check")).click();
            }catch (Exception exception){
                driver.close();
                fail("Vind het veld "+vak+"_Check niet.");
            }
        }

        //submit
        try{
            driver.findElement(By.id("Send_bt")).click();
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Send_bt niet.");
        }




        //Checken als de verzonden informatie met het formulier steeds dezelfde is.

        //Check Voornaam
        try{

        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Boxnummer_Input niet.");
        }
        assertEquals(voornaam, driver.findElement(By.id("Voornaam")).getText());

        //Check Achternaam
        try{

        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Boxnummer_Input niet.");
        }
        assertEquals(achternaam, driver.findElement(By.id("Achternaam")).getText());

        //Check Telefoon
        try{
            assertEquals(telefoonnummer, driver.findElement(By.id("Telefoon")).getText());
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Telefoon label niet.");
        }


        //Check Datum
        String datum = "";
        //Verander het datum formaat van 01-01-2021 naar 2021-01-01
        var datumSplit = geboortedatum.split("-");
        for (int i=datumSplit.length-1 ; i >= 0 ; i--) {
            if (datumSplit[i]!=null){
                datum += datumSplit[i];
            }
            if (i!=0){
                datum+="-";
            }
        }
        try{
            assertEquals(datum, driver.findElement(By.id("Geboorte_Datum")).getText());
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld Geboorte_Datum label niet.");
        }

        //Check Adres
        try{
            assertEquals(straatnaam +" "+ nummer +" Boxnumer: "+ boxnummer +" Postcode: "+ postcode, driver.findElement(By.id("Adres")).getText());
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld adres label niet.");
        }

        //Check Opleiding
        try{
            assertEquals(opleidingen, driver.findElement(By.id("Opleiding")).getText());
        }catch (Exception exception){
            driver.close();
            fail("Vind het veld opleiding label niet.");
        }


        //Check Vakken
        for (var vak:vakken) {
            System.out.println(vak);
            System.out.println(driver.findElement(By.id("Vakken")).getText());
            try{
                assertEquals(true, driver.findElement(By.id("Vakken")).getText().contains(vak));
            }catch (Exception exception){
                driver.close();
                fail("Vind het veld vakken label niet.");
            }
        }
    }

    @AfterAll
    public static void endTest(){
        driver.close();
    }
}
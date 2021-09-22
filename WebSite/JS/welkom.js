'use strict'
window.onload = function(){

    let Voornaam = document.getElementById("Voornaam")
    let Achternaam = document.getElementById("Achternaam")
    let Telefoon = document.getElementById("Telefoon")
    let Geboorte_Datum = document.getElementById("Geboorte_Datum")
    let Adres = document.getElementById("Adres")
    let Opleiding = document.getElementById("Opleiding")
    let Vakken = document.getElementById("Vakken")
    
    
    Voornaam.innerText = sessionStorage.getItem("Voornaam")
    Achternaam.innerText = sessionStorage.getItem("Achternaam")
    Telefoon.innerText = sessionStorage.getItem("Telefoon")
    Geboorte_Datum.innerText = sessionStorage.getItem("Geboorte_Datum")
    Adres.innerText = sessionStorage.getItem("Straat") + " " + sessionStorage.getItem("HuisNummer") + " Boxnumer: " + sessionStorage.getItem("Boxnummer") + " Postcode: " + sessionStorage.getItem("Postcode")
    Opleiding.innerText = sessionStorage.getItem("Opleiding")
    

    Vakken.innerText = "Vakken: "+sessionStorage.getItem("Vakken")


    
}
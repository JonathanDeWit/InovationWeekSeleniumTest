'use strict'

hideVakken()

document.getElementById("Opleidingen").onchange = function() {
    console.log("Testa")
    hideVakken()
  }


  function hideVakken(){
    var x = document.getElementById("Opleidingen").value;
    console.log("opleiding: "+x)

    if(x != "Toegepaste Informatica"){
        console.log("Test")
        document.getElementById("Toegepaste Informatica").style.display="none"
    }
    if (x != "Multimedia"){
        document.getElementById("Multimedia").style.display="none"
    }
    if (x != "Graduaat Programmeren"){
        document.getElementById("Graduaat Programmeren").style.display="none"
    }

    document.getElementById(x).style.display="block"
  }


document.getElementById("Send_bt").onclick=function(){
    sessionStorage.setItem("Voornaam", document.getElementById("Voornaam_Input").value)
    sessionStorage.setItem("Achternaam", document.getElementById("Achternaam_Input").value)
    sessionStorage.setItem("Telefoon", document.getElementById("Phone_Input").value)
    sessionStorage.setItem("Geboorte_Datum", document.getElementById("Date_Input").value)
    sessionStorage.setItem("Straat", document.getElementById("Straat_Input").value)
    sessionStorage.setItem("HuisNummer", document.getElementById("Nummer_Input").value)
    sessionStorage.setItem("Boxnummer", document.getElementById("Boxnummer_Input").value)
    sessionStorage.setItem("Postcode", document.getElementById("Postcode_Input").value)
    sessionStorage.setItem("Opleiding", document.getElementById("Opleidingen").value)
    
    var vakEllementen = Array.from(document.getElementsByClassName(document.getElementById("Opleidingen").value+"-vak"));
    var vakken = []
    vakEllementen.forEach(element => {
        if(element.checked==true){
            vakken.push(element.value)
        }
    });
    sessionStorage.setItem("Vakken", vakken)
    
    window.location.href="/HTML/welkom.html"  
}
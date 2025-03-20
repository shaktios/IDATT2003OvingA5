# Kortspill – IDATT2003

Dette er et kortspillprosjekt utviklet i Java med **JavaFX** for GUI og **JUnit** for testing.  
Prosjektet implementerer funksjonalitet for å trekke kort, sjekke håndverdier og håndtere tom kortstokk.

---

## **Funksjonalitet**
**DeckOfCards** – Håndterer kortstokken (stokking, trekking, resetting)  
**PlayingCard** – Representerer ett enkelt kort (farge og verdi)  
**GUI(GameGUI)** – Bruker JavaFX for å vise og analysere kortene  
**Check Hand** – Sjekker sum, flush og "Queen of Spades"  
**Automatisk stokking** – Når kortstokken blir tom, fylles den opp igjen  

---

##  Oppgave 1 – Sette opp kortstokk
- Implementerte **DeckOfCards** for å håndtere en full kortstokk med 52 kort.  
- Brukte **Enums (`Suit`, `Rank`)** for kortverdier og farger.  
- **JUnit-tester** sjekker at kortstokken starter med riktig antall kort.

---

## Oppgave 2 – Trekke kort (dealHand)**
- Lagde `dealHand(n)`, som trekker `n` tilfeldige kort fra kortstokken.  
- Sørget for at kortene fjernes fra `DeckOfCards` etter trekking.  
- **JUnit-tester** sjekker at antall kort i stokken reduseres riktig.

---

## Oppgave 3 – GUI med JavaFX
- **Laget et GUI med "Deal Hand"-knapp** for å trekke kort.  
- **Viser kortene i en `ListView`** i GUI-et.  
- **"Check Hand"-knapp analyserer hånden** (sum, flush, Queen of Spades).  
- Bruker **Streams** for analyse av hånden.

---

## Oppgave 4 – Analyse av hånden
- **Summerer verdiene av kortene i hånden.**  
- **Sjekker flush** (om alle 5 kortene har samme suit).  
- **Sjekker om "Queen of Spades" er i hånden.**  
- **GUI oppdaterer resultatene** direkte.

---

##  Oppgave 5 – Automatisk stokking
- Hvis kortstokken **blir tom, fylles den opp automatisk**.  
- `resetDeck()` legger inn alle 52 kort på nytt og stokker kortene.  
- **GUI fungerer uten å henge seg, uansett hvor mange hender som trekkes!**  

---

## **Hvordan kjøre prosjektet**
1. **Installer Java 21** hvis du ikke har det:
   ```sh
   brew install openjdk@21
  2. mvn clean package
  3. mvn javafx:run

Alternativt er det bare å kjøre GameGUI direkte i IntelliJ eller en annen IDE. 

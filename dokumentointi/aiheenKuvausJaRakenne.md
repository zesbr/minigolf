#Mingolf-peli :golf: 
*Ohjelmoinnin harjoitustyö, alkukesä 2015*

## 1. Aiheen kuvaus
Kaksiulotteinen minigolf simulaatio. Pelin idana on että pelaaja yrittää löydä tai ns. putata pallon mahdollisimman vähillä lyönneillä reikään. Peliä pelaatan oikean minigolfin tavoin radoilla, jotka ovat vaihtelevia. Ratoja ympäröi seinät ja radoilla voi olla erilaisia esteitä pelin hankaloittamiseksi. Peli aloitetaan radan aloituspaikalta ja uusi lyönti aloitetaan siitä mihin edellinen lyönti päättyi. Pelikierros päättyy kun pallo pelataan reikään.

Peliä voi pelata yksin tai kaveria vastaan ja sitä ohjataan hiirellä. Hiiren osoittimella valitaan lyönnin suunta ja hiiren vasenta painiketta pohjassa pitämällä asetetaan voima jolla lyönti suoritetaan. Lyönti siis vaikuttaa pallon liikkeeseen eli siihen mihin suuntaan ja millä voimalla pallo alussa lähtee. Pallon edetessä sen liike hidastuu kunnes se lopulta pysähtyy. Tämän jälkeen, peliä jatketaan uudella lyönnillä tai jos pallo päätyi reikään, niin aloitetaan peli uudelta kentältä. Edetessään pallo voi törmätä esteisiin, jolloin pallon liikkeen suunta ja nopeus muuttuvat. Pallon liikeen ja törmäilyn tulee vaikuttaa uskottavalta ja sen tulee jossain määrin noudattaa fysiikan lakeja.

Peli tulee olemaan kaksiulotteinen, joka on kuvattu rataan nähden ylhäältä päin. Peliä voi toistaiseksi pelata vain yksinpelinä.

## 2. Alustavat vaatimukset
HUOM! Yliviivatut vaatimukset siirtyvät jatkokehityskohteeksi

#### Yleiset:
* Pelissä on oltavat vähintään yksi pelaaja
* ~~Pelissä voi olla monta pelaaja~~ *(Siirretty jatkokehityskohteeksi)* 
* ~~Peliä voi pelata yksin tai toisia pelaajia vastaan~~ *(Siirretty jatkokehityskohteeksi)* 
* ~~Pelissä voi olla tekoäly pelaajia~~ *(Siirretty jatkokehityskohteeksi)*
* ~~Tekoäly pelaajilla on vaikeustaso~~ *(Siirretty jatkokehityskohteeksi)*
* Pelissä on useita ratoja
* ~~Pelaaja voi valita haluamansa radan~~ *(Siirretty jatkokehityskohteeksi)*
* Pelikierroksen aikana pidetään kirjaa lyöntien lukumäärästä
* ~~Pelissä pidetään kirjaa ennätyspisteitä eli ns. high scoreista~~ *(Siirretty jatkokehityskohteeksi)*

#### Ohjaus:
* Lyönnin suunta ja voima määritetään hiirellä

#### Fysiikkamallinnus:
* Lyönneillä on suunta ja voima
* ~~Lyönneillä voi olla ylä- tai alakierre~~ *(Siirretty jatkokehityskohteeksi)*
* Pallolla on liike, mikä kertoo pallon sen hetkisen suunnan ja nopeuden
* ~~Pallola on pyörimisliike, mikä kertoo pallon pyörimissuunnan ja pyörimisnopeuden~~ *(Siirretty jatkokehityskohteeksi)*
* Lyöntien suunta ja voima vaikuttaa pallon liikkeeseen
* ~~Lyöntien kierre vaikuttaa pallon pyörimisliikkeeseen~~ *(Siirretty jatkokehityskohteeksi)*
* ~~Pallon pyörimisliike vaikuttaa pallon liikkeeseen~~ *(Siirretty jatkokehityskohteeksi)*
* Pallon osuminen objektiin vaikuttaa liikkeeseen
* ~~Radan pinnanmuodot vaikuttaa pallon liikkeeseen~~ *(Siirretty jatkokehityskohteeksi)*
* ~~Radan päällyste vaikuttaa pallon nopeuteen~~ *(Siirretty jatkokehityskohteeksi)*

#### Radat: 
* Radalla on pohjapiirros, joka määrittää radan mitat
* Rata voi olla tasainen eli siinä ei ole korkeuseroja
* ~~Rata voi sisältää korkeuseroja ja/tai kaltevuuksia~~ *(Siirretty jatkokehityskohteeksi)*
* ~~Radalla on päällyste, joka on jotain materiaalia~~ *(Siirretty jatkokehityskohteeksi)*
* Radalla on yksi aloituslyöntipaikka
* Radalla on yksi reikä
* Radalla voi olla objekteja esim. seiniä tai esteitä
* Objektit voivat olla kulmikkaita
* ~~Objektit voivat olla kaarevia~~ *(Siirretty jatkokehityskohteeksi)*
* Objektit voivat olla staattisia esim. seinät
* ~~Objektit voivat olla dynaamisia (liikkuvia) esim. tuulimyllyt~~ *(Siirretty jatkokehityskohteeksi)*

#### Erikoistehosteet:
* ~~Lyönnin tulee aiheuttaa ääniefekti~~ *(Siirretty jatkokehityskohteeksi)*
* ~~Pallon osuessa objektiin tulee aiheuttaa ääniefekti~~ *(Siirretty jatkokehityskohteeksi)*
* ~~Pallon pudotessa reikään tulee aiheuttaa ääniefekti~~ *(Siirretty jatkokehityskohteeksi)*
* ~~Onnistuneen väylän (par tai alle) jälkeen tulee seurata ääniefekti (aplodit)~~ *(Siirretty jatkokehityskohteeksi)*
* ~~Epäonnistuneen väylän (yli par) jälkeen tulee seurata ääniefekti (buuaus)~~ *(Siirretty jatkokehityskohteeksi)*
* ~~Lyönnin ja törmäyksen voiman tulee vaikuttaa ääniefektiin~~ *(Siirretty jatkokehityskohteeksi)*

## 3. Käyttötapaukset

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot:**

* Pelaaja aloittaa uuden pelin
* Pelaaja määrittää osallistujat
* Pelaaja valitsee haluamansa radan
* Pelaaja suorittaa lyönnin
* Pelaaja keskeyttä pelin
* Pelaaja lopettaa pelin

## 4. Jatkokehitys
Jatkokehityksen kohteeksi siirtyvät toiminnallisuudet, joita ei ehditä toteuttaa tämän kurssi-iteraation aikana. Nämä kohteet sisältävät
mm. pallon fysiikkamallinuksen parantelua (mm. pyörimisliike), ratojen monipuolistamisen (mm. korkeuserot, dynaamiset esteet ja pyöreät kulmat) sekä erikoistehosteiden (mm. ääniefektit) ja tekstuureiden lisäämisen.

## 5. Rakenne
Sovelluksen arkkitehtuuri ei tietoisesti noudata mitään yleisesti tunnettua suunnittelumallia. Käytetyn arkkitehtuuriratkaisun ideana on ollut jakaa sovelluksen eri osa-alueet omiin kokonaisuuksiin, riippuen niiden toteuttamista toiminnallisuuksista. Näin ollen sovelluksen eri osa-alueet muodostavat yhteistyönä sovelluksen kokonaisuuden. Luokkasuunnittelussa on pyritty noudattamaan single-responsibility periaatetta, jossa jokaisen luokan tehtävä on huolehtia yhden rajatun ja loogisen kokonaisuuden toteuttamisesta.

Sovellus on jaettu neljään eri pakettiin: **minigolf**, **minigolf.domain**, **minigolf.game** ja **minigolf.gui**. **Minigolf** paketissa olevien luokkien (App ja Main) tehtävä on huolehtia sovelluksen käynnistämisestä ja ikkunan alustamisesta. **Minigolf.domain** paketissa olevien luokien (Ball, Hole, Level, LevelArchitect, LevelObject, Obstacle, Player, Tee)  tehtävä on huolehtia pelikentälle ja peliin liittyvien objektien toiminnallisuuksista. **Minigolf.game** paketissa olevan luokan (Game) tehtävä on huolehtia pelikierroksen hallinnasta ja siihen liittyvästä toimintalogiikasta. **Minigolf.gui** paketissa olevien luokkien (GUI, GameCanvas, HUD, MouseInputManager, PowerBar, ScoreCard, StartMenu, ViewManager) tehtävä on huolehtia pelin käyttöliittymistä ja sovelluksen näkymistä.

### 5.1 Näkymien hallinta
Sovellus koostuu kolmesta päänäkymästä: Päävalikko (StartMenu), Pelitila tai Pelin piirtoalusta (GameCanvas) sekä Tuloskortti -näkymä (ScoreCard). Sovellusikkunassa esitettävää näkymää hallitsee luokka ViewManager. ViewManager:lla on ulkoasuna CardLayout, joka voi esittää vain yhden aktiivisen näkymän kerrallaan sovelluksen ikkunassa (App). ViewManager toteuttaa tapahtumakuuntelija rajapinnan (ActionListener), joka on liitetty päävalikon ja tuloskortti -näkymän painikkeisiin. Näin ollen, siis painikkeen painaminen käynnistää tapahtuman, joka vaihtaa sovelluksen aktiivista näkymää. Lisäksi, pelikierroksen päätyttyä sovellus avaa automaattisesti Scorecard näkymän, joten sitä ei aktivoida minkään panikkeen kautta.

### 5.2 Lyöntitapahtuma
Pallon lyöntitapahtuma yhdessä pallon liikkumisen kanssa on kenties sovelluksen monimutkaisin tapahtumaketju, joka käynnistyy käyttäjän antamien hiirikomentojen seurauksena. Sovelluksen pelialusta:lla (GameCanvas) on hiiren tapahtumien kuuntelija (MouseInputManager), joka käsittelee hiiren vasemman painikkeen pohjaan painamisen ja vapauttamisen tapahtumat. Hiiren kuuntelijalla on pelialustan käyttöliittymän (GUI) komponetti voimapalkki (PowerBar), joka perii Java Swing -komponentin JProgressBar. Voimapalkilla on ajastin (Timer), joka määrittää milloin voimapalkin mittaripalkki on aktiivisena. **Aina kun käyttäjä painaa hiireen vasemman painikkeen pohjaan, hiiren tapahtuma käsittelijä käynnistää voimapalkin ajastimen.** Tällöin löynnin voimaa kuvaava mittaripalkki alkaa liikkua. **Kun käyttäjä vapauttaa hiiren vasemman painikkeen, hiiren tapahtuma käsittelijä pysäyttää voimapalkin ajastimen sekä asettaa tälle hiiren osoittimen sen hetkisen koordinaatin.** Tämän jälkeen voimapalkki pyytää pelin (Game) aktiivsen pelaajan (Player) palloa (Ball) laskemaan pallon lähtökulman hiirenkoordinaattien perusteella. Lopuksi, voimapalkki pyytää pelaajaa asettamaan pallolleen kulmaksi lasketun kulman ja nopeudeksi voimapalkin määrittämän voima arvon sekä käynnistää pelialustan ajastimen.

Pelialustan (GameCanvas) ajastimen päivitystiheys eli ns. FPS on 60 kertaa sekunnissa. Tämä tarkoittaa sitä, että **aina kun pelialustan ajastin on käynnissä, niin pelialusta päivittyy 60 kertaa sekunnissa.** Tällöin siis ajastin kutsuu itsensä tapahtumakuuntelija, joka on pelialusta luokka itse. Ajastimen ollessa käynnissä, tapahtumankuuntelija hakee aktiivisen pelaajan pallon ja tarkistaa paljonko sen nopeus on. **Jos pallon nopeus on suurempi kuin 0, tarkoittaa se että pallossa jäljellä liike-energiaa. Tässä tapauksessa, tapahtumakuuntelijasta pyydetään palloa liikkumaan pallon kulman suuntaan pallon nopeus/60 askelta eli pikseliä**. Tämä on siis se matka, jonka pallo liikkuu jokaisen piirtoalustan päivityksen aikana, luoden pallon liikeen animaation. **Pallo liikkuu askeleittain ja jokaisen askeleen aikana  tarkistetaan, onko pallo reiässä tai osuuko se yhteenkään kentän esteeseen.** Jos pallo on reiässä, niin liike pysäytetään. Jos pallo osuu esteeseen lasketaan pallolle uusi kulma riippuen siitä missä kulmassa ja mihin kohtaan estettä pallo osuu. Törmäyksen tarkistus tapahtuu kutsumalla kutsumalla jokaista aktiivisen pelikentän (Level) estettä (Obstacle) ja tarkistamalla osuvatko pallon kehän koordinaatit siihen. 

Lopuksi, kun pallossa ei ole enää liikettä, niin pelialustan ajastin pysäytetään ja näin ollen sen päivittäminen keskeytään. Riippuen siitä onko pallo reiässä vai ei vaikuttaa siihen, että jatkuuko peli uudella lyöntitapahtumalla vai tehdäänkö pelaajan vaihdos tai jos kaikki pelaajat ovat pelanneet kentän, niin tehdäänkö kentän vaihdos tai jos kaikki pelaajat ovat pelanneet kaikki kentät, niin lopetetaan pelikierros ja näytetään pelikierroksen tuloskortti (ScoreCard).

## 6. Bugit ja puuttet
Pelissä on tällä hetkellä olemassa bugi, jonka seurauksena pallo voi joutua esteen sisälle. Tämä aiheutuu tilanteesta, jolloin pallo osuu esteen kulmaan tietyssä kulmassa. Syynä on logiikka virhe kulman osuman tunnistuksessa ja törmäyksen aihettavan uuden kulman laskemisesta, joka tälle hetkellä laskee kulma törmäyksen vain 180 asteen sektorilla tapahtuville törmäyksille.

Voimapalkin arvo kiihtyy ja hidastuu tällä hetkellä lineaarisesti. Jotta voiman ajoittamisesta tulisi haastavampaa, voisi kiihtymisen toteuttaa toisella tavalla.

Peliä voi tällä hetkellä pelata vain yksinpelinä. Suunnitelmana olisi, että ennen pelin alkamista esitettäisiin näkymä jossa käyttäjä voisi määrittää peliin osallistuvat muut pelaajat. Lisäksi peliin voisi tehdä tekoälypelaajia joita pelaaja voisi myös haastaa.


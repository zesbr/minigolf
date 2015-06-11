#Mingolf-peli :golf: 
*Ohjelmoinnin harjoitustyö, kesä 2015*

## 1. Aiheen kuvaus
Kaksiulotteinen minigolf simulaatio. Pelin idana on että pelaaja yrittää löydä tai ns. putata pallon mahdollisimman vähillä lyönneillä reikään. Peliä pelaatan oikean minigolfin tavoin radoilla, jotka ovat muodoiltaan vaihtelevia. Ratoja ympäröi seinät ja radoilla voi olla erilaisia 
esteitä pelin hankaloittamiseksi. Peli aloitetaan radan aloituspaikalta ja uusi lyönti aloitetaan siitä mihin edellinen lyönti päättyi. Pelikierros päättyy kun pallo pelataan reikään.

Peliä voi pelata yksin tai kaveria vastaan ja sitä ohjataan hiirellä. Hiiren osoittimella valitaan lyönnin suunta ja hiiren painiketta pohjassa pitämällä voima jolla lyönti suoritetaan. Lyönti vaikuttaa pallon liikkeeseen eli siihen mihin suuntaan ja millä voimalla pallo alussa lähtee. Pallon edetessä sen liike hidastuu kunnes se lopulta pysähtyy, jonka jälkeen peliä jatketaan uudella lyönnillä. Edetessään pallo voi törmätä esteisiin, jolloin pallon liikkeen suunta ja nopeus muuttuvat. Pallon liike ja käyttäytyminen tulee noudattamaan jossain määrin simuloituja fysiikan lakeja.

Peli tulee olemaan kaksiulotteinen, joka on kuvattu rataan nähden ylhäältä päin. Peliä voi pelata yksin tai kaveria vastaan.

## 2. Alustavat vaatimukset
HUOM! Yliviivatut vaatimukset siirtyvät jatkokehityskohteeksi

#### Yleiset:
* Pelissä on oltavat vähintään yksi pelaaja
* Pelissä voi olla monta pelaaja 
* Peliä voi pelata yksin tai toisia pelaajia vastaan
* ~~Pelissä voi olla tekoäly pelaajia~~ *(Siirretty jatkokehityskohteeksi)*
* ~~Tekoäly pelaajilla on vaikeustaso~~ *(Siirretty jatkokehityskohteeksi)*
* Pelaaja voi valita haluamansa radan
* Pelaaja voi ottaa peliin mukaan useampia ratoja
* Pelikierroksen aikana pidetään kirjaa lyöntien lukumäärästä
* ~~Pelissä pidetään kirjaa ennätyspisteitä eli ns. high scoreista~~ *(Siirretty jatkokehityskohteeksi)*

#### Ohjaus:
* Lyönnin suunta ja voima määritetään hiirellä

#### Fysiikkamoottori:
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
* ~~Objektit voivat olla pyöreitä, kaarevia tai kuperia~~ *(Siirretty jatkokehityskohteeksi)*
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
mm. pallon fysiikkamallinuksen parantelua (mm. pyörimisliike), ratojen monipuolistamisem (mm. korkeuserot, dynaamiset esteet ja pyöreät kulmat) sekä erikoistehosteiden (mm. ääniefektit) ja tekstuureiden lisäämisen.

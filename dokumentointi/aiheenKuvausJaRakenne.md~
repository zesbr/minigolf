#Mingolf-peli :golf: 
*Ohjelmoinnin harjoitustyö, kesä 2015*

## 1. Aiheen kuvaus
Kaksiulotteinen minigolf simulaatio. Pelin idana on että pelaaja yrittää löydä tai ns. putata pallon mahdollisimman vähillä lyönneillä reikään. Peliä pelaatan oikean minigolfin tavoin radoilla, jotka ovat muodoiltaan vaihtelevia. Ratoja ympäröi seinät ja radoilla voi olla erilaisia 
esteitä pelin hankaloittamiseksi. Peli aloitetaan radan aloituspaikalta ja uusi lyönti aloitetaan siitä mihin edellinen lyönti päättyi. Pelikierros päättyy kun pallo pelataan reikään tai jos lyöntejä on käytetty kuusi.

Peliä ohjataan näppäimistöllä, jolla määritetään jokaista lyöntiä varten lyönnin suunta sekä voima. Lisäominaisuutena lyönnille voidaan määrittää myös ylä- tai alakierre. Lyönti vaikuttaa pallon liikkeeseen eli siihen mihin suuntaan ja millä voimalla pallo alussa lähtee. Pallon edetessä sen liike hidastuu kunnes se lopulta pysähtyy, jonka jälkeen peliä jatketaan uudella lyönnillä. Edetessään pallo voi törmätä esteisiin, jolloin pallon liikkeen suunta ja nopeus muuttuvat. Lisäominaisuutena pelattavan radan pinnanmuodot voivat vaikuttaa pallon liikkeeseen. Pallon liike ja käyttäytyminen tulee noudattamaan jossain määrin simuloituja fysiikan lakeja.

Peli tulee olemaan kaksiulotteinen, joka on kuvattu rataan nähden ylhäältä päin. Peliä voi pelata yksin tai kaveria vastaan ja se tulee noudattamaan jossain määrin oikean minigolfin sääntöjä.

## 2. Alustavat vaatimukset
HUOM! Toissijaiset vaatimukset on *kursivoitu*

#### Yleiset:
* Pelissä on oltavat vähintään yksi pelaaja
* Pelissä voi olla monta pelaaja 
* Peliä voi pelata yksin tai toisia pelaajia vastaan
* *Pelissä voi olla tekoäly pelaajia*
* *Tekoäly pelaajilla on vaikeustaso*
* Pelaaja voi valita haluamansa radan
* Pelaaja voi ottaa peliin mukaan useampia ratoja
* Pelikierroksen aikana pidetään kirjaa lyöntien lukumäärästä
* *Pelissä pidetään kirjaa ennätyspisteitä eli ns. high scoreista*

#### Ohjaus:
* Lyönnin suunta ja voima määritetään näppäinkomennoilla
* *Lyönnin suunta ja voima voidaan myös määrittää hiirellä tai kosketusnäytöltä*

#### Fysiikkamoottori:
* Lyönneillä on suunta ja voima
* *Lyönneillä voi olla ylä- tai alakierre*
* Pallolla on liike, mikä kertoo pallon sen hetkisen suunnan ja nopeuden
* *Pallola on pyörimisliike, mikä kertoo pallon pyörimissuunnan ja pyörimisnopeuden*
* Lyöntien suunta ja voima vaikuttaa pallon liikkeeseen
* *Lyöntien kierre vaikuttaa pallon pyörimisliikkeeseen*
* *Pallon pyörimisliike vaikuttaa pallon liikkeeseen*
* Pallon osuminen objektiin vaikuttaa liikkeeseen
* *Radan pinnanmuodot vaikuttaa pallon liikkeeseen*
* *Radan päällyste vaikuttaa pallon nopeuteen*

#### Radat: 
* Radalla on pohjapiirros, joka määrittää radan mitat
* Rata voi olla tasainen eli siinä ei ole korkeuseroja
* *Rata voi sisältää korkeuseroja ja/tai kaltevuuksia*
* *Radalla on päällyste, joka on jotain materiaalia*
* Radalla on yksi aloituslyöntipaikka
* Radalla on yksi reikä
* Radalla voi olla objekteja esim. seiniä tai esteitä
* Objektit voivat olla kulmikkaita
* *Objektit voivat olla pyöreitä, kaarevia tai kuperia*
* Objektit voivat olla staattisia esim. seinät
* *Objektit voivat olla dynaamisia (liikkuvia) esim. tuulimyllyt*

#### Erikoistehosteet:
* Lyönnin tulee aiheuttaa ääniefekti
* Pallon osuessa objektiin tulee aiheuttaa ääniefekti
* Pallon pudotessa reikään tulee aiheuttaa ääniefekti
* *Onnistuneen väylän (par tai alle) jälkeen tulee seurata ääniefekti (aplodit)*
* *Epäonnistuneen väylän (yli par) jälkeen tulee seurata ääniefekti (buuaus)*
* *Lyönnin ja törmäyksen voiman tulee vaikuttaa ääniefektiin*

## 3. Käyttötapaukset

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot:**

* Pelaaja aloittaa uuden pelin
* Pelaaja määrittää osallistujat
* Pelaaja valitsee haluamansa radan
* Pelaaja suorittaa lyönnin
* Pelaaja keskeyttä pelin
* Pelaaja lopettaa pelin

#Mingolf -peli :golf: 
Ohjelmoinnin harjoitustyö, kesä 2015
Jesper Ruuth

**Kuvaus:** 
Kaksiulotteinen minigolf simulaatio. Pelin idana on että pelaaja yrittää löydä tai "putata" pallon mahdollisimman vähillä lyönneillä reikään. 
Peliä pelaatan oikean minigolfin tavoin radoilla, jotka ovat muodoiltaan vaihtelevia. Ratoja ympäröi seinät ja radoilla voi olla erilaisia 
esteitä pelin hankaloittamiseksi. Pelikierros aloitetaan radan aloituspaikalta ja jatketaan siitä mihin edellinen lyönti päättyi. 
Pelikierros päättyy kun pallo pelataan reikään tai jos lyöntejä on käytetty kuusi.

Peliä ohjataan näppäimistöllä, jossa jokaista lyöntiä varten määritetään lyönnin suunta sekä voima. Lisäominaisuutena lyönnille voi määrittää
myös ylä- tai alakierteen. Lyönti vaikuttaa pallon liikkeeseen joka määrittää miten pallo radalla etenee ja mihin kohtaa radalla pallon 
liike lopulta pysähtyy. Edetessään, pallo voi törmätä esteisiin, jotka vaikuttavat myös pallon liikeen jatkoon.  Lisäominaisuutena radan 
pinnanmuodot voivat vaikuttaa pallon liikkeeseen. Pallon liike ja käyttäytyminen noudatta jossain määrin simuloituja fysiikan ja liikkeen lakeja.

Peli tulee olemaan kaksiulotteinen, joka on kuvattu pystysuoraan ylhäältä päin. Peliä voi pelata yksin tai kaveria vastaan ns. moninpelinä.

## Alustavat toiminnalliset vaatimukset
HUOM! Toissijaiset vaatimukset on *kursivoitu*

### Yleiset:
* Pelissä on oltavat vähintään yksi pelaaja
* Pelissä voi olla monta pelaaja 
* Pelissä voi valita pelattavan radan 
* Peliin voi ottaa mukaan useampia ratoja
* Pelikierroksen aikana pidetään kirjaa lyöntien lukumäärästä
* *Pelissä voi olla tekoäly pelaajia*
* *Tekoäly pelaajilla on vaikeustaso*
* *Pelissä pidetään kirjaa ennätyspisteitä eli ns. high scoreista*

### Ohjaus ja pelattavuus:
* Peliä ohjataa näppäimistöllä
* Pelikierros aloitetaan radan aloituspaikalta
* Pelikierrosta jatketaan siitä mihin edellinen lyönti päättyi
* Pelikierros päätty kun pallo on saatu reikään tai pelikierrokseen on käytetty kuusi lyöntiä
* *Peliä voidaan ohjata hiirellä tai kosketusnäytöllä*


### Fysiikkamoottori:
* Lyönneillä on suunta
* Lyönneillä on voima
* Pallolla on liike, mikä kertoo pallon sen hetkisen suunnan ja nopeuden
* Lyöntien suunta ja voima vaikuttaa pallon liikkeeseen
* Pallon osuminen objektiin tulee vaikuttaa liikkeeseen
* *Lyönneillä on kierre (front/backspin)*
* *Pallola on pyörimisliike, mikä kertoo pallon pyörimissuunnan ja pyörimisnopeuden*
* *Lyöntien kierre vaikuttaa pallon pyörimisliikkeeseen*
* *Pyörimisliike vaikuttaa pallon liikkeeseen*
* *Radan korkeuserojen ja kaltevuuksien tulee vaikuttaa pallon liikkeeseen
* *Radan päällyste vaikuttaa pallon nopeuteen ja pyörimisliikkeeseen*
* *Objektin materiaalia vaikuttaa pallon liikkeeseen*

### Radat: 
* Radalla on pohjapiirros, joka määrittää radan mitat
* Rata voi olla tasainen eli siinä ei ole korkeuseroja
* Radalla on yksi aloituslyönti paikka
* Radalla on yksi reikä
* Radalla voi olla objekteja esim. seiniä tai esteitä, jotka ovat jotain materiaalia
* Objektit voivat olla kulmikkaita
* Objektit voivat olla staattisia esim. seinät
* *Rata voi sisältää korkeuseroja ja/tai kaltevuuksia
* *Radoilla on päällyste, joka on jotain materiaalia*
* *Objektit voivat olla pyöreitä tai kaarevia*
* *Radalla on ihannetulos eli ns. par
* *Objektit voivat olla dynaamisia (liikkuvia) esim. tuulimyllyt 

### Erikoistehosteet:
* Lyönnin tulee aiheuttaa ääniefekti
* Pallon osuessa objektiin tulee aiheuttaa ääniefekti
* Pallon pudotessa reikään tulee aiheuttaa ääniefekti
* *Onnistuneen väylän (par tai alle) jälkeen tulee seurata ääniefekti (aplodit)
* *Epäonnistuneen väylän (yli par) jälkeen tulee seurata ääniefekti (buuaus)
* *Erilaisen materiaalin tulee aiheuttaa erilainen ääniefekti*
* *Lyönnin ja törmäyksen voiman tulee vaikuttaa ääniefektiin*


## Käyttötapaukset:

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot:**

* Pelaaja aloittaa uuden pelin
* Pelaaja määrittää osallistujat
* Pelaaja valitsee radan tai radat
* Pelaaja suorittaa lyönnin 
* Pelaaja keskeyttä pelin
* Pelaaja lopettaa pelin


## Jatkokehitys: 
* Tänne tulee kommentteja, ideoita ja suunnitelmia pelin jatkokehitystä varten 

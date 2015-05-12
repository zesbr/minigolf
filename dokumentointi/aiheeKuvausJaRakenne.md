#Mingolf-peli :golf: 
*Ohjelmoinnin harjoitustyö, kesä 2015*

## 1. Aiheen kuvaus
Kaksiulotteinen minigolf simulaatio. Pelin idana on että pelaaja yrittää löydä tai ns. putata pallon mahdollisimman vähillä lyönneillä reikään. Peliä pelaatan oikean minigolfin tavoin radoilla, jotka ovat muodoiltaan vaihtelevia. Ratoja ympäröi seinät ja radoilla voi olla erilaisia 
esteitä pelin hankaloittamiseksi. Pelikierros aloitetaan radan aloituspaikalta ja sitä jatketaan siitä mihin edellinen lyönti päättyi. Pelikierros päättyy kun pallo pelataan reikään tai jos lyöntejä on käytetty kuusi.

Peliä ohjataan näppäimistöllä, jolla määritetään jokaista lyöntiä varten lyönnin suunta sekä voima. Lisäominaisuutena lyönnille voi määrittää myös ylä- tai alakierteen. Lyönti vaikuttaa pallon liikkeeseen joka määrittää miten pallo radalla etenee ja mihin kohtaa radalla pallon 
liike lopulta pysähtyy. Edetessään pallo voi törmätä esteisiin, jotka vaikuttavat myös pallon liikkeen jatkoon. Lisäominaisuutena radan pinnanmuodot voivat vaikuttaa pallon liikkeeseen. Pallon liike ja käyttäytyminen tulee noudattamaan jossain määrin simuloituja fysiikan lakeja.

Peli tulee olemaan kaksiulotteinen, joka on kuvattu rataan nähden ylhäältä päin. Peliä voi pelata yksin tai kaveria vastaan moninpelinä ja se tulee noudattamaan jossain määrin oikean minigolfin sääntöjä.

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

#### Ohjaus ja pelattavuus:
* Peliä ohjataa näppäimistöllä
* *Peliä voidaan ohjata hiirellä tai kosketusnäytöllä*
* Pelikierros aloitetaan radan aloituspaikalta
* Pelikierrosta jatketaan siitä mihin edellinen lyönti päättyi
* Pelikierros päätty kun pallo on saatu reikään tai pelikierrokseen on käytetty kuusi lyöntiä

#### Fysiikkamoottori:
* Lyönneillä on suunta ja voima
* *Lyönneillä on kierre (front/backspin)*
* Pallolla on liike, mikä kertoo pallon sen hetkisen suunnan ja nopeuden
* *Pallola on pyörimisliike, mikä kertoo pallon pyörimissuunnan ja pyörimisnopeuden*
* Lyöntien suunta ja voima vaikuttaa pallon liikkeeseen
* *Lyöntien kierre vaikuttaa pallon pyörimisliikkeeseen*
* *Pallon pyörimisliike vaikuttaa pallon liikkeeseen*
* Pallon osuminen objektiin vaikuttaa liikkeeseen
* *Radan korkeuserojen ja kaltevuuksien tulee vaikuttaa pallon liikkeeseen
* *Radan päällyste vaikuttaa pallon nopeuteen ja pyörimisliikkeeseen*
* *Objektin materiaalia vaikuttaa pallon liikkeeseen*

#### Radat (pelimaailma): 
* Radalla on pohjapiirros, joka määrittää radan mitat
* Rata voi olla tasainen eli siinä ei ole korkeuseroja
* *Rata voi sisältää korkeuseroja ja/tai kaltevuuksia
* *Radalla on päällyste, joka on jotain materiaalia*
* Radalla on yksi aloituslyöntipaikka
* Radalla on yksi reikä
* Radalla voi olla objekteja esim. seiniä tai esteitä, jotka ovat jotain materiaalia
* Objektit voivat olla kulmikkaita
* *Objektit voivat olla pyöreitä tai kaarevia*
* Objektit voivat olla staattisia esim. seinät
* *Objektit voivat olla dynaamisia (liikkuvia) esim. tuulimyllyt 

#### Erikoistehosteet:
* Lyönnin tulee aiheuttaa ääniefekti
* Pallon osuessa objektiin tulee aiheuttaa ääniefekti
* Pallon pudotessa reikään tulee aiheuttaa ääniefekti
* *Onnistuneen väylän (par tai alle) jälkeen tulee seurata ääniefekti (aplodit)
* *Epäonnistuneen väylän (yli par) jälkeen tulee seurata ääniefekti (buuaus)
* *Erilaisen materiaalin tulee aiheuttaa erilainen ääniefekti*
* *Lyönnin ja törmäyksen voiman tulee vaikuttaa ääniefektiin*

## 3. Käyttötapaukset:

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot:**

* Pelaaja aloittaa uuden pelin
* Pelaaja määrittää osallistujat
* Pelaaja valitsee radan tai radat
* Pelaaja suorittaa lyönnin 
* Pelaaja keskeyttä pelin
* Pelaaja lopettaa pelin

## 4. Jatkokehitys: 
* Tänne tulee kommentteja, ideoita ja suunnitelmia pelin jatkokehitystä varten 

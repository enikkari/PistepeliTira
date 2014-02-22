PistepeliTira

=============

Projekti on tekstipohjainen ja sen voi ajaa ohjelmointiympäristö NetBeansissa. 
Kun ohjelman käynnistää, kysyy se ensimmäisenä haluatko luoda verkon vai käyttää valmista verkkoa. 
Jos haluat käyttää valmista verkkoa anna syöte ’1’.

Valmiina olevat verkot ovat samat, kuin testausdokumentissa esitellyt kolme verkkoa. Anna syötteenä sen verkon numero, jota haluat käyttää. (Esim. Verkko 1:stä varten syötä ’1’).

Suoritus näyttää silloin suunnilleen tältä:
run:
Luo verkko käsin:1
Käytä valmista verkkoa:2
2
Mikä verkoista? (int)
1
Paras reitti oli Mizar:3->Alioth:8->Megrez:-1->Dubhe:10, ja sen arvo oli 20.

Ohjelmassa on myös mahdollisuus ’luoda verkko käsin’ eli syöttää ensin verkon solmut ohjelmaan ja sitten kaaret niiden välille. (Tämä on varsin vaivalloista ja sitä varten on mahdollisuus käyttää valmiita verkkoja).

Ohjelman suoritus voi näyttää esimerkiksi tältä:
run:
Luo verkko käsin:1
Käytä valmista verkkoa:2
1
Kuinka monta solmua verkkoon?
3
Anna ensin solmun nimi, sitten pistearvo (Solmut indeksöidään nollasta alkaen, lisäysjärjestyksessä)
moi
4

tere
8

hei
-3

Kuinka monta kaarta verkkoon?
3
Käytä solmujen indeksöintiä lisätessäsi kaaria
0
1

0
2

2
1

Paras reitti oli moi:4->tere:8, ja sen arvo oli 12.
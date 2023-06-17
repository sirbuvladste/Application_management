# Sistem de gestionare a cererilor pentru o primarie

**Clasa abstracta Utilizator**
- in constructor se creaza un nou TreeSet pentru cereriAsteptare si cereriFinalizate
  (am ales TreeSet pentru ca aceste cereri trebuie ordonate dupa data pentru comenzile
  de afisare)
- metoda abstracta generareTextCerere care trebuie implementata pentru fiecare tip
  de utilizator

**Clasa UserCereriComparator**
- este folosita de TreeSet pentru ordonarea dupa data a cererilor unui utilizator

**Clasele Persoana, Penstionar, Angajat, Elev, EntitateJuridica**
- Aceste clase extind Utilizator
- Au un constructor care seteaza parametrii timupui de utilizator si
  se folosind constructorul clasei Utilizator se creaza si un nou TreeSet
  de tip cereriAsteptare, respesctiv cereriAsteptare.
- Implementarea pentru generareTextCerere, care returneaza textul in
  corespondenta tipului de cerere, asta daca cererea corespunde si tipului
  utilizatorului, altfel retuneaza null.

**Clasa Birou**
- Contine un TreeSet setCereriBirou (am ales TreeSet pentru ca cererile
  trebuie sa fie unnice si ordonate dupa prioritate si data) si un
  HashSet setFunctionarPublic (set cu toti functionarii unui birou,
  care trebuie doar sa fie doar unici)

**Clasa BirouCereriComparator**
- este folosita de TreeSet pentru ordonarea dupa prioritate sau data
  a cererilor unui birou

**Clasa FunctionarPublic**
- constructor care seteaza numele functionarului si tipul biroului de care
  acesta apartine

**Clasa ManagementPrimarie**
- Aici sunt initializate (in constructor) fiecare birou
- in metoda main se citesc rand cu rand comenzile si se verifica primul
  parametru si se apeleaza metoda (din ManagementComenzi) care rezolva comanda

**Clasa ManagementComenzi**
- Extinde clasa ManagementPrimarie, constituie un fel manager/handler pentru
  comenzile pe care primaria le primeste
  -are ca principal scop doar imbunatatirea aspectul coduluii
  in ManagementPrimarie

- Metodele clasei:
  - adaugaUtilizator => returneaza clasei parinte un nou utilizator de tipul
  specificat sau null daca tipul introdus nu e valabil
  - creareCerereNoua => genereaza o noua cerere; daca cererea este genereata cu
  succes se adauga in cereriAsteptare ale utilizatorului si in biroul corespunator;
  daca nu s-a realizat cu succes se scrie in fisierul de output, cat si in terminal,
  mesajul de excepti.
  - verificareCerere => returneaza ce tip de cerere daca corespunde utilizatorului,
  altfel se returneaza CERERE_GRESITA
  - afisareCereriAsteptareUtilizator si afisareCereriFinalizateUtilizator =>
  scrie in fisier cererile aflate in asteptare ale utilizatorului cu numele
  trimis ca parametru
  - afisareCereriBirou => scrie in fisier cererile biroului cu tipul precizat
  - rezolvaCerere => iau prima cerere din birou si se cauta functionaru care trebuie
  sa o rezolve, dupa se sterge cererea din birou si din cereriAsteptare
  ale utilizatorului si se adauga la cereriFinalizate, respectiv se
  apeleaza outputCerereFunctionar
  - outputCerereFunctionar => se ocupa de scrierea in fisierul functionarului
  ca a rezolvat cererea
  - retrageCerereUtilizator => se cauta utilizatorul care vrea sa faca retragerea
  in setul de utilizatori din ManagementPrimarie, dupa se cauta si biroul de care
  apartine si se sterge cererea din cereriAsteptare, respectiv din setul biroului
  - adaugaFunctionar => creaza un nou functionar si il adauga in setul de functionari
  ai biroului de care apartine

**Clase exceptii:**
- ExceptieTipCerere => realizeaza textul care trebuie afisat in terminal si scris
  in fisier, in cazul in care un utilizaotr incearca sa faca o cerere de un tip la
  care nu are acces.
- ExceptieFunctionarNuExista => afiseaza in terminal ca functionarul cautat nu exista
  in birou corespunzator cereri care trebuie rezolvata

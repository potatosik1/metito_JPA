﻿Laboratorium II - Architektura warstwowa, EntityManager oraz testy

Uwaga! Do wykonania zadan konieczne jest zaimplementowanie modelu obiektowo-relacyjnego bazy z Laboratorium I !

1. Korzystajac z przykladowego kodu dla encji AddressEntity utworz warstwy dostepu do danych (Repository, Service, mappery, TOsy, opcjonalnie RESTy - dla chetnych) dla encji PatientEntity. Spelnione maja byc nasteoujace wymagania:
   - TO pacjenta ma miec liste wizyt ktore sie odbyly (czyli w teorii nowy model wizyty)
   - kazda wizyta ma miec informacje o czasie (daty), imie i nazwisko lekarza oraz liste typow (z encji MedicalTreatment)
   - rozszerz encje PatientEntity o jedno dowolne pole innego typu niz String, odwzoruj je w TO. (data, enum, jakis boolean itp)
2. Korzystajac z przykladowych insertow w pliku data.sql uzupelnij encje pacjenta, doktorow oraz wizyt danymi testowymi
3. Korzystajac z przykladowych testow dla encji Address, napisz testy do serwisu (uwaga! serwisu, nie DAO!) pacjenta:
   - test usuwajacy pacjenta sprawdza czy usuniete zostaly wszystkie wizyty (kaskada) i czy nie zostali usunieci doktorzy
   - pobranie pacjenta po ID powinno zwrocic strukture TO-sow odpowiadajaca wczesniejszym zalozeniom. W asercjach sprawdz poprawnosc odczytu dodanego przez Ciebie pola z punktu pierwszego
4. Dodaj metode w PatientDao, ktora na podstawie parametrow wejsciowych:

   ID pacjenta, ID doktora, data wizyty, opis wizyty 

   utworzy nowa encje wizyty i doda ja do pacjenta w jednym wywolaniu - kaskadowy update pacjenta (merge). 

   Npisz test do tej metody (Dao)

- ad.1.3 Trzeba zrobic do tego pacjenta 2 mappery, jeden dla niego i drugi dla wizyt.
     Czyli patient mapper bedzie musial wywolac statyczna metode z mappera wizyt do zmapowania ich (ograniczenie odpowiedzialnosci)
     No i dodaj kontroler
- kaskadowosc - np kiedy ustawimy na persist to wtedy przy zapisie doktora i dodajac do niego set address, ten adres tez doda sie jako rekord do bazy
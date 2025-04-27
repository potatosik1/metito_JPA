Laboratorium III - JPQL

Uwaga! Do wykonania zadan konieczne jest zaimplementowanie architektury warstwowej i testow z Laboratorium II !

Uzupelnij plik data.sql o dane niezbedne do realizacji nastepujacych zapytan:
1. Znajdz pacjentow po nazwisku
2. Znajdz wszystkie wizyty pacjenta po jego ID
3. znajdz pacjentow ktorzy mieli wiecej niz X wizyt (X jest parametrem wejsciowym)
4. Znajdz pacjentow po dodanym przez Ciebie polu - nie wyszukuj wprost po wartosci, uzyj zapytania typu wieksze/mniejsze/pozniej/wczesniej/zawiera, w zaleznosci od wybranego typu zmiennej.

Napisz testy do zapytan w nastepujacej formie:
1. do zapytania nr 1  - test DAO
2. do zapytania nr 2 - test serwisu
3. do zapytania nr 3 - test DAO
4. do zapytania nr 4 - test DAO

W PatientEntity, nad relacja do VisitEntity dodaj adnotacje

@Fetch(FetchMode.SELECT)

a fetchType zmien na EAGER
Uruchom test w ktorym pobierany jest Patient z wieloma wizytami. W logach zaobserwuj, jak wyglada pobieranie dodatkowych encji (ile i jakie sqle).
Nastepnie zmien adnotacje na

@Fetch(FetchMode.JOIN)

i powtorz test i obserwacje. Wnioski zapisz na dole tego pliku i skomituj.

Do wybranej encji dodaj wersjonowanie, oraz napisz test (w DAO) sprawdzajacy rownolegla modyfikacje (OptimisticLock)

Opis:
Dodajemy metody w interfejsach Dao
Nastepnie tworzymy implementacje w DaoImpl za pomoca EntityManagera

Np.

entityManager.createQuery("SELECT * FROM DoctorEntity d WHERE d.lastName = :param1", DoctorEntity.class).setParameter("param1", pName).getSingleResult(); // nie odnosimy sie do tabel tylko do encji (MUSIMY DODAC ALIAS)

Komenda z like: "SELECT * FROM DoctorEntity d WHERE d.lastName LIKE :param1" .setParameter("param1", "%"+pName+"%");

Komenda z join: "SELECT d FROM DoctorEntity d JOIN d.visits v"

Koemnda z group:"SELECT d FROM DoctorEntity d JOIN d.visits v GROUP BY d HAVING COUNT(v) >= :param1"

Komenda z datami: "SELECT d FROM DoctorEntity d JOIN d.visits v WHERE v.visitDate BETWEEN :param1 AND :param2" i wtedy 2 razy setParameter

Niektore testy moga nie moc miec adnotacji @Transactional, odnosnie ktorego z testow to kazder z zapytan automatycznie otworzy i zamknie transakcje, cos tam z wersjonowaniem i exception




WNIOSKI

FetchMode.SELECT - przy pobieraniu pacjenta Hibernate wykona osobne SELECTY na tabelę wizyt, w logach widać osobne zapytania na każdą kolekcję wizit

FetchMode.JOIN - Hibernate łączy pacjenta i wizyty za pomocą LEFT OUTER JOIN w jednym zapytaniu SQL, wykona się to szybciej dla mniejszej liczby danych ale isnitje ryzyko dupliukatów przy dużych kolekcjach
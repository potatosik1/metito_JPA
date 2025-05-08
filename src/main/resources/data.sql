--LEKARZE--
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
            values(101, 'Jan', 'Kowalski', '+48123456789', 'kowalski@jpa.com', 'DS1', 'SURGEON');

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
            values(102, 'Marcin', 'Kawasaki', '+48737926154', 'kawasaki@jpa.com', 'DO1', 'OCULIST');

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
            values(103, 'Magdalena', 'Słomka', '+48678934325', 'slomka@jpa.com', 'DD1', 'DERMATOLOGIST');

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
            values(104, 'Hieronim', 'Abażur', '+4832678908', 'abazur@jpa.com', 'DG1', 'GP');

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
            values(105, 'Helga', 'Krankenhaus', '+48567546390', 'krankenhaus@jpa.com', 'DG2', 'GP');

--PACJENCI--
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_foreigner)
            values(201, 'Karol', 'Nowak', '+481234565789', 'karoln@gmail.com', 'P01','2000-12-12', true);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_foreigner)
            values(202, 'Brajan', 'Sobieski', '+48563890901', 'brajanek08@wp.pl', 'P02','2008-03-27', false);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_foreigner)
            values(203, 'Nasturcja', 'Sowik', '+48683965097', 'nasturcjasowik@gmail.com', 'P03','1986-08-15', false);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_foreigner)
            values(204, 'Piotr', 'Cyjanowicz', '+48598740235', 'cyjan@op.pl', 'P04','2003-09-11', false);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_foreigner)
            values(205, 'Horacy', 'Nowacy', '+48795556423', 'h.nowacy@gmail.com', 'P05','1960-02-12', false);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_foreigner)
            values(206, 'Malaga', 'Nowacy', '+48795556423', 'm.nowacy@gmail.com', 'P06','1999-04-04', false);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_foreigner)
            values(207, 'Sława', 'Biodrowska', '+48699656789', 'slawka@gmail.com', 'P07','1974-04-16', false);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_foreigner)
            values(208, 'Lilianna', 'Paderewska', '+48674343890', 'paderewskal@gmail.com', 'P08','1998-12-24', false);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_foreigner)
            values(209, 'Gustav', 'Smoth', '+32968656453', 'smothgus@icloud.com', 'P09','1990-09-12', true);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, is_foreigner)
            values(210, 'Bolek', 'Lolek', '+48642109641', 'bolo@gmail.com', 'P10','2000-06-29', false);

--ADRESY--
insert into address (id, address_line1, address_line2, city, postal_code, doctor_id)
            values (901, 'Dworcowa 5', '-', 'Ustrzyki Dolne', '37-700', 101);

insert into address (id, address_line1, address_line2, city, postal_code, doctor_id)
            values (902, 'Dworcowa 5', '-', 'Ustrzyki Dolne', '37-700', 102);

insert into address (id, address_line1, address_line2, city, postal_code, doctor_id)
            values (903, 'Dworcowa 5', '-', 'Ustrzyki Dolne', '37-700', 103);

insert into address (id, address_line1, address_line2, city, postal_code, doctor_id)
            values (904, 'Dworcowa 5', '-', 'Ustrzyki Dolne', '37-700', 104);

insert into address (id, address_line1, address_line2, city, postal_code, patient_id)
            values (905, 'Szkolna 3', '-', 'Ustrzyki Dolne', '37-700', 202);

insert into address (id, address_line1, address_line2, city, postal_code, patient_id)
            values (906, '29 listopada 5', 'm. 4', 'Ustrzyki Dolne', '37-700', 205);

insert into address (id, address_line1, address_line2, city, postal_code, patient_id)
            values (907, 'Nadrzeczna 9', 'm. 2', 'Ustrzyki Dolne', '37-700', 206);

insert into address (id, address_line1, address_line2, city, postal_code, patient_id)
            values (908, '3 maja 3', '-', 'Ustrzyki Dolne', '37-700', 209);

insert into address (id, address_line1, address_line2, city, postal_code, patient_id)
            values (909, 'Wyzwolenia 19', 'm. 6', 'Ustrzyki Dolne', '37-700', 207);


--WIZYTY--
insert into visit (id, description, time, patient_id, doctor_id)
            values(501, 'Zmiany skórne', '2025-03-12 12:00:00', 202, 103);

insert into visit (id, description, time, patient_id, doctor_id)
            values(502, 'Ból ciała szklistego', '2025-03-13 14:30:00', 208, 102);

insert into visit (id, description, time, patient_id, doctor_id)
            values(503, 'Siny knykieć u kciuka', '2025-03-12 13:00:00', 202, 105);

insert into visit (id, description, time, patient_id, doctor_id)
            values(504, 'Skaczące jelita', '2025-03-14 09:00:00', 202, 101);

insert into visit (id, description, time, patient_id, doctor_id)
            values(505, 'Odwrócone nozdrza', '2025-03-17 11:25:59', 205, 101);

insert into visit (id, description, time, patient_id, doctor_id)
            values(506, 'Młoteczek bije strzemiączko', '2025-03-12 17:00:00', 201, 105);

--LECZENIE--
insert into medical_treatment(id, description, type, visit_id)
            values(5011, 'Leczenie trądziku', 'USG', 501);

insert into medical_treatment(id, description, type, visit_id)
            values(5021, 'Wymiana oka na robooko', 'USG', 502);

insert into medical_treatment(id, description, type, visit_id)
            values(5031, 'Sprawdzenie co to knykieć', 'RTG', 503);

insert into medical_treatment(id, description, type, visit_id)
            values(5041, 'Usunięcie jelit', 'USG', 504);

insert into medical_treatment(id, description, type, visit_id)
            values(5051, 'Skierowanie do Hogwartu', 'EKG', 505);

insert into medical_treatment(id, description, type, visit_id)
            values(5061, 'Dostawienie kowadełka między nimi', 'RTG', 506);

insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
            values(101, 'Jan', 'Kowalski', '+48123456789', 'jank@email.com', '123', 'SURGEON');

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth)
            values(102, 'Karol', 'Nowak', '+481234565789', 'karoln@email.com', '123','2000-12-12');

insert into visit (id, description, time, patient_id, doctor_id)
            values(103, 'opis', '2000-12-12 12:00:00', 102, 101);

insert into medical_treatment(id, description, type, visit_id)
            values(104, 'opis', 'USG', 103);


insert into addresses (country, city, street, number) values ('Srbija', 'Novi Sad', 'bulevar Oslobodjenja', 69);
insert into addresses (country, city, street, number) values ('Bosna i Hercegovina', 'Sarajevo', 'bulevar Ćevapa', 21);
insert into addresses (country, city, street, number) values ('Hrvatska', 'Split', 'bulevar Avnoja', 42);
insert into addresses (country, city, street, number) values ('Crna Gora', 'Budva', 'bulevar Mihajla Pupina', 96);
insert into addresses (country, city, street, number) values ('Slovenija', 'Ljutomer', 'Franca Miklošića', 101);
insert into addresses (country, city, street, number) values ('Italija', 'Napulj', 'bulevar Pice', 69);
insert into addresses (country, city, street, number) values ('Grcka', 'Atina', 'bulevar Girosa', 21);
insert into addresses (country, city, street, number) values ('Turska', 'Istanbul', 'bulevar Kebaba', 42);
insert into addresses (country, city, street, number) values ('Austrija', 'Bec', 'bulevar Snicala', 121);
insert into addresses (country, city, street, number) values ('Holandija', 'Amsterdam', 'bulevar Trave', 420);

insert into users (user_type,email, password, name, surname, gender, jmbg, address_id,phone_number, points, user_catagory) values (1,'juzer@gmail.com','123', 'Mo', 'Salah', 1, 123123123, 1, '18921892',5.00,1);
insert into users (user_type,email, password, name, surname, gender, jmbg, address_id,phone_number, points, user_catagory) values (1,'asdf@gmail.com','321', 'Petar', 'Trs', 1, 12, 2, '2313211',3.00,2);
insert into users (user_type ,email, password, name, surname, gender, jmbg, address_id, phone_number) values (1,'juzer3@gmail.com','123', 'Md', 'Dh', 1, 121123123, 3, '18921892');

insert into users (user_type, email, password, name, surname, gender, jmbg, address_id, phone_number) values (2, 'juzer4@gmail.com','111', 'Mil', 'Mar', 0, 321124412, 4, '746352332');
insert into users (user_type, email, password, name, surname, gender, jmbg, address_id, phone_number) values (2, 'juzer5@gmail.com','333', 'To', 'And', 1, 412412123, 5, '574456443');

insert into blood_bank_center (name, address_id, description, average_rating) values ('Dunja', 6, 'Najsavremenija oprema.', '3.14');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Phizer', 7, 'Bil Gejts vas čeka.', '4');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Alucard', 8, 'Najprijatniji radnici.', '4.99');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Dracula', 9, 'Stari načini vađenja krvi se vraćaju u modu.', '2.3');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Krpelj', 10, 'Divan banka krvi omeđena prostranim livadama.', '3');

insert into blood_donor_info(weight, skin_issues, feel_healthy, blood_pressure, menstruation, tooth_out_last7days, taken_medicine_in_last7days, piercing_last6months, operation_or_transfusion_last6months, tattoo_last6months, donor_id) values (false, false, true, false, false, true, true, true, true, true, 1);
insert into blood_donor_info(weight, skin_issues, feel_healthy, blood_pressure, menstruation, tooth_out_last7days, taken_medicine_in_last7days, piercing_last6months, operation_or_transfusion_last6months, tattoo_last6months, donor_id) values (true, true, true, true, true, true, true, true, true, true, 2);
insert into blood_donor_info(weight, skin_issues, feel_healthy, blood_pressure, menstruation, tooth_out_last7days, taken_medicine_in_last7days, piercing_last6months, operation_or_transfusion_last6months, tattoo_last6months, donor_id) values (true, true, true, true, true, true, true, true, true, true, 3);

insert into equipment(blood_quantity, needles) values (400, 10);

insert into appointment_history(datum, donor_id, krvna_grupa, napomena_doktoru_medicine, bakar_sulfat, hemoglobinometar_vrednost, pluca, srce, ta, tip_kese, napomena, broj_lota_kese) values ('19-12-2022', 1, 'A+', 'Nap dok medicine 1', 'nizak', 'mala', 'losa pluca', 'slabo srce', 'nizak pritisak', 'mala', 'napomena1', 1);
insert into appointment_history(datum, donor_id, krvna_grupa, napomena_doktoru_medicine, bakar_sulfat, hemoglobinometar_vrednost, pluca, srce, ta, tip_kese, napomena, broj_lota_kese) values ('20-12-2022', 1, 'A+', 'Nap dok medicine 2', 'visok', 'velika', 'sjajna pluca', 'jako srce', 'visok pritisak', 'srednja', 'napomena2', 2);
insert into appointment_history(datum, donor_id, krvna_grupa, napomena_doktoru_medicine, bakar_sulfat, hemoglobinometar_vrednost, pluca, srce, ta, tip_kese, napomena, broj_lota_kese) values ('21-12-2022', 1, 'A+', 'Nap dok medicine 3', 'dobar', 'srednja', 'dobra pluca', 'dobro srce', 'normalan pritisak', 'velika', 'napomena3', 3);




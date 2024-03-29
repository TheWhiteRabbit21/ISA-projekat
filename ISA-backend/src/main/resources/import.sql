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
insert into addresses (country, city, street, number) values ('Srbija', 'Subotica', 'bulevar Madjara', 1892);

insert into working_hours(work_hour_begin_time,work_hour_end_time) values ( '08:00', '18:00');

insert into blood_bank_center (name, address_id, description, average_rating, working_hours_id) values ('Dunja', 6, 'Najsavremenija oprema.', '3.14',1);
insert into blood_bank_center (name, address_id, description, average_rating) values ('Phizer', 7, 'Bil Gejts vas čeka.', '4');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Alucard', 8, 'Najprijatniji radnici.', '4.99');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Dracula', 9, 'Stari načini vađenja krvi se vraćaju u modu.', '2.3');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Krpelj', 10, 'Divna banka krvi omeđena prostranim livadama.', '3');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Elektra', 6, 'Predobri.', '3.4');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Kod Rocka', 7, 'Prosjecni.', '3.1');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Epruveta', 8, 'Grozni.', '1.3');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Divna', 9, 'Samo ime kaze.', '4.3');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Benu', 10, 'Savrseni.', '5.0');

insert into blood_bank_center (name, address_id, description, average_rating, working_hours_id) values ('Dinja', 6, 'Radi.', '3.14',1);
insert into blood_bank_center (name, address_id, description, average_rating) values ('Miloja', 7, 'Lose.', '4');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Prenk', 8, 'Meh.', '4.99');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Betmen', 9, 'Da.', '2.3');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Drvo', 10, 'Ne.', '3');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Elite', 6, 'Onako.', '3.4');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Kod Brke', 7, 'Kao.', '3.1');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Laboratorija+', 8, 'Pakao.', '1.3');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Ekavica', 9, 'Raj.', '4.3');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Jankovic', 10, 'Eden.', '5.0');


insert into roles (name) values ('ROLE_USER');
insert into roles (name) values ('ROLE_ADMIN_CENTER');
insert into roles (name) values ('ROLE_ADMIN');

-- Lozinka za sve user-e je 123
insert into users (user_type, username, password, name, surname, gender, jmbg, address_id, phone_number, points, user_catagory, penals, enabled) values (1,'juzer@gmail.com','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Gojko', 'Mrmot', 1, '1234567891234', 1, '18921892', 5.00, 1, 0, true);
insert into users (user_type, username, password, name, surname, gender, jmbg, address_id, phone_number, points, user_catagory, penals, enabled) values (1,'asdf@gmail.com','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Petar', 'Trs', 1, '4321987654321', 2, '2313211', 3.00, 2, 0, true);
insert into users (user_type, username, password, name, surname, gender, jmbg, address_id, phone_number, points, user_catagory, penals, enabled) values (1,'juzer3@gmail.com','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Negovan', 'Radicic', 1, '1111111111111', 3, '18921892', 2.00, 1, 0, true);

insert into users (user_type, username, password, name, surname, gender, jmbg, address_id, phone_number, blood_bank_center_id, enabled) values (2, 'juzer4@gmail.com','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Mil', 'Mar', 0, '1596324879562', 4, '746352332',1, true);
insert into users (user_type, username, password, name, surname, gender, jmbg, address_id, phone_number, enabled) values (2, 'juzer5@gmail.com','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'To', 'And', 1, '9635874215698', 5, '574456443', true);

insert into users (user_type, username, password, name, surname, gender, jmbg, address_id, phone_number, password_changed, enabled) values (3, 'juzer6@gmail.com','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'To', 'And', 1, '1563248976523', 11, '57445643', false, true);

INSERT INTO USER_ROLE (user_id, role_id) values (1, 1); 
INSERT INTO USER_ROLE (user_id, role_id) values (2, 1); 
INSERT INTO USER_ROLE (user_id, role_id) values (3, 1);
INSERT INTO USER_ROLE (user_id, role_id) values (4, 2);
INSERT INTO USER_ROLE (user_id, role_id) values (5, 2);
INSERT INTO USER_ROLE (user_id, role_id) values (6, 3);

insert into work_calendar (blood_bank_center_id) values (1);

insert into appointment (date, time, duration, taken, user_id, work_calendar_id) values (to_date('22/12/2022', 'DD/MM/YYYY'),to_timestamp('12:00:00','HH24:MI:SS'),30, false, 1, 1);

insert into complaints (text, user_id) values ('UAaaaaaaa',1);
insert into complaints (text, user_id) values ('Nevalja nista',2);

insert into blood_donor_info(weight, skin_issues, feel_healthy, blood_pressure, menstruation, tooth_out_last7days, taken_medicine_in_last7days, piercing_last6months, operation_or_transfusion_last6months, tattoo_last6months, donor_id) values (false, false, true, false, false, true, true, true, true, true, 1);
insert into blood_donor_info(weight, skin_issues, feel_healthy, blood_pressure, menstruation, tooth_out_last7days, taken_medicine_in_last7days, piercing_last6months, operation_or_transfusion_last6months, tattoo_last6months, donor_id) values (true, true, true, true, true, true, true, true, true, true, 2);
insert into blood_donor_info(weight, skin_issues, feel_healthy, blood_pressure, menstruation, tooth_out_last7days, taken_medicine_in_last7days, piercing_last6months, operation_or_transfusion_last6months, tattoo_last6months, donor_id) values (true, true, true, true, true, true, true, true, true, true, 3);

insert into equipment(blood_quantity, needles) values (400, 100);

insert into appointment_history(datum, donor_id, krvna_grupa, napomena_doktoru_medicine, bakar_sulfat, hemoglobinometar_vrednost, pluca, srce, ta, tip_kese, napomena, broj_lota_kese) values ('19-12-2022', 1, 'A+', 'Nap dok medicine 1', 'nizak', 'mala', 'losa pluca', 'slabo srce', 'nizak pritisak', 'mala', 'napomena1', 1);
insert into appointment_history(datum, donor_id, krvna_grupa, napomena_doktoru_medicine, bakar_sulfat, hemoglobinometar_vrednost, pluca, srce, ta, tip_kese, napomena, broj_lota_kese) values ('20-12-2022', 1, 'A+', 'Nap dok medicine 2', 'visok', 'velika', 'sjajna pluca', 'jako srce', 'visok pritisak', 'srednja', 'napomena2', 2);
insert into appointment_history(datum, donor_id, krvna_grupa, napomena_doktoru_medicine, bakar_sulfat, hemoglobinometar_vrednost, pluca, srce, ta, tip_kese, napomena, broj_lota_kese) values ('21-12-2022', 1, 'A+', 'Nap dok medicine 3', 'dobar', 'srednja', 'dobra pluca', 'dobro srce', 'normalan pritisak', 'velika', 'napomena3', 3);

insert into predefined_appointments (date, time, duration, username, center_id, availability) values (to_date('22/06/2023', 'DD/MM/YYYY'), to_timestamp('12:00:00','HH24:MI:SS'), 30, 'juzer@gmail.com', 1, 0);
insert into predefined_appointments (date, time, duration, username, center_id, availability) values (to_date('22/06/2023', 'DD/MM/YYYY'), to_timestamp('12:30:00','HH24:MI:SS'), 30, 'juzer@gmail.com', 1, 0);
insert into predefined_appointments (date, time, duration, username, center_id, availability) values (to_date('22/06/2023', 'DD/MM/YYYY'), to_timestamp('13:00:00','HH24:MI:SS'), 30, 'juzer@gmail.com', 1, 0);

insert into predefined_appointments (date, time, duration, username, center_id, availability) values (to_date('22/06/2023', 'DD/MM/YYYY'), to_timestamp('12:00:00','HH24:MI:SS'), 30, 'juzer@gmail.com', 2, 1);
insert into predefined_appointments (date, time, duration, username, center_id, availability) values (to_date('22/06/2023', 'DD/MM/YYYY'), to_timestamp('12:30:00','HH24:MI:SS'), 30, 'juzer@gmail.com', 2, 1);
insert into predefined_appointments (date, time, duration, username, center_id, availability) values (to_date('22/06/2023', 'DD/MM/YYYY'), to_timestamp('13:00:00','HH24:MI:SS'), 30, 'juzer@gmail.com', 2, 1);

insert into predefined_appointments (date, time, duration, username, center_id, availability) values (to_date('22/06/2023', 'DD/MM/YYYY'), to_timestamp('12:00:00','HH24:MI:SS'), 30, 'juzer@gmail.com', 3, 1);
insert into predefined_appointments (date, time, duration, username, center_id, availability) values (to_date('22/06/2023', 'DD/MM/YYYY'), to_timestamp('12:30:00','HH24:MI:SS'), 30, 'juzer@gmail.com', 3, 1);
insert into predefined_appointments (date, time, duration, username, center_id, availability) values (to_date('22/06/2023', 'DD/MM/YYYY'), to_timestamp('13:00:00','HH24:MI:SS'), 30, 'juzer@gmail.com', 3, 1);

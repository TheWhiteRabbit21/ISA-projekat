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


insert into working_hours(work_hour_begin_time,work_hour_end_time) values ( '08:00', '18:00');

insert into blood_bank_center (name, address_id, description, average_rating, working_hours_id) values ('Dunja', 6, 'Najsavremenija oprema.', '3.14',1);
insert into blood_bank_center (name, address_id, description, average_rating) values ('Phizer', 7, 'Bil Gejts vas čeka.', '4');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Alucard', 8, 'Najprijatniji radnici.', '4.99');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Dracula', 9, 'Stari načini vađenja krvi se vraćaju u modu.', '2.3');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Krpelj', 10, 'Divan banka krvi omeđena prostranim livadama.', '3');

insert into users (user_type,email, password, name, surname, gender, jmbg, address_id,phone_number, points, user_catagory, blood_bank_center_id) values (2,'juzer@gmail.com','123', 'Mo', 'Salah', 1, 123123123, 1, '18921892',5.00,1,1);
insert into users (user_type,email, password, name, surname, gender, jmbg, address_id,phone_number, points, user_catagory) values (1,'asdf@gmail.com','321', 'Petar', 'Trs', 1, 12, 2, '2313211',3.00,2);
insert into users (user_type ,email, password, name, surname, gender, jmbg, address_id, phone_number) values (1,'juzer3@gmail.com','123', 'Md', 'Dh', 1, 121123123, 3, '18921892');

insert into users (user_type, email, password, name, surname, gender, jmbg, address_id, phone_number) values (2, 'juzer4@gmail.com','111', 'Mil', 'Mar', 0, 321124412, 4, '746352332');
insert into users (user_type, email, password, name, surname, gender, jmbg, address_id, phone_number) values (2, 'juzer5@gmail.com','333', 'To', 'And', 1, 412412123, 5, '574456443');

insert into blood_donor_info(aspirin_last5days, ate_something, blood_past, ever_rejected, feel_healthy, have_dangerous_job, hospital_ever_or_now, regularly_take_medicine, taken_medicine_in_last3days, taken_tooth_out_in_last7days) values  (true, true, true, true, true, true, true, true, true, true);
insert into blood_donor_info(aspirin_last5days, ate_something, blood_past, ever_rejected, feel_healthy, have_dangerous_job, hospital_ever_or_now, regularly_take_medicine, taken_medicine_in_last3days, taken_tooth_out_in_last7days) values  (false, false, false, false, false, false, false, false, false, false);
insert into blood_donor_info(aspirin_last5days, ate_something, blood_past, ever_rejected, feel_healthy, have_dangerous_job, hospital_ever_or_now, regularly_take_medicine, taken_medicine_in_last3days, taken_tooth_out_in_last7days) values  (true, false, true, true, true, false, true, true, true, false);
insert into blood_donor_info(aspirin_last5days, ate_something, blood_past, ever_rejected, feel_healthy, have_dangerous_job, hospital_ever_or_now, regularly_take_medicine, taken_medicine_in_last3days, taken_tooth_out_in_last7days) values  (false, true, false, true, false, true, false, true, false, true);
insert into blood_donor_info(aspirin_last5days, ate_something, blood_past, ever_rejected, feel_healthy, have_dangerous_job, hospital_ever_or_now, regularly_take_medicine, taken_medicine_in_last3days, taken_tooth_out_in_last7days) values  (true, true, true, false, true, true, true, false, true, true);

insert into work_calendar(blood_bank_center_id) values (1);

insert into users (user_type,email, password, name, surname, gender, jmbg, address,phone_number, points, user_catagory) values (1,'juzer@gmail.com','123', 'Mo', 'Salah', 1, 123123123, 2, '18921892',5.00,1);
insert into users (user_type,email, password, name, surname, gender, jmbg, address,phone_number, points, user_catagory) values (1,'asdf@gmail.com','321', 'Petar', 'Trs', 1, 12, 1, '2313211',3.00,2);
insert into users (user_type ,email, password, name, surname, gender, jmbg, address, phone_number) values (1,'juzer3@gmail.com','123', 'Md', 'Dh', 1, 121123123, 2, '18921892');

insert into users (user_type, email, password, name, surname, gender, jmbg, address, phone_number) values (2, 'juzer4@gmail.com','111', 'Mil', 'Mar', 0, 321124412, 4, '746352332');
insert into users (user_type, email, password, name, surname, gender, jmbg, address, phone_number) values (2, 'juzer5@gmail.com','333', 'To', 'And', 1, 412412123, 5, '574456443');

insert into blood_bank_center (name, address, description, average_rating) values ('Dunja', 1, 'Najsavremenija oprema.', '3.14');
insert into blood_bank_center (name, address, description, average_rating) values ('Phizer', 2, 'Bil Gejts vas čeka.', '4');
insert into blood_bank_center (name, address, description, average_rating) values ('Alucard', 3, 'Najprijatniji radnici.', '4.99');
insert into blood_bank_center (name, address, description, average_rating) values ('Dracula', 4, 'Stari načini vađenja krvi se vraćaju u modu.', '2.3');
insert into blood_bank_center (name, address, description, average_rating) values ('Krpelj', 5, 'Divan banka krvi omeđena prostranim livadama.', '3');

insert into addresses (country, city, street, number) values ('Srbija', 'Novi Sad', 'bulevar Oslobodjenja', 69);
insert into addresses (country, city, street, number) values ('Bosna i Hercegovina', 'Sarajevo', 'bulevar Ćevapa', 21);
insert into addresses (country, city, street, number) values ('Hrvatska', 'Split', 'bulevar Avnoja', 42);
insert into addresses (country, city, street, number) values ('Crna Gora', 'Budva', 'bulevar Mihajla Pupina', 96);
insert into addresses (country, city, street, number) values ('Slovenija', 'Ljutomer', 'Franca Miklošića', 101);

insert into blood_donor_info(aspirin_last5days, ate_something, blood_past, ever_rejected, feel_healthy, have_dangerous_job, hospital_ever_or_now, regularly_take_medicine, taken_medicine_in_last3days, taken_tooth_out_in_last7days) values  (true, true, true, true, true, true, true, true, true, true);
insert into blood_donor_info(aspirin_last5days, ate_something, blood_past, ever_rejected, feel_healthy, have_dangerous_job, hospital_ever_or_now, regularly_take_medicine, taken_medicine_in_last3days, taken_tooth_out_in_last7days) values  (false, false, false, false, false, false, false, false, false, false);
insert into blood_donor_info(aspirin_last5days, ate_something, blood_past, ever_rejected, feel_healthy, have_dangerous_job, hospital_ever_or_now, regularly_take_medicine, taken_medicine_in_last3days, taken_tooth_out_in_last7days) values  (true, false, true, true, true, false, true, true, true, false);
insert into blood_donor_info(aspirin_last5days, ate_something, blood_past, ever_rejected, feel_healthy, have_dangerous_job, hospital_ever_or_now, regularly_take_medicine, taken_medicine_in_last3days, taken_tooth_out_in_last7days) values  (false, true, false, true, false, true, false, true, false, true);
insert into blood_donor_info(aspirin_last5days, ate_something, blood_past, ever_rejected, feel_healthy, have_dangerous_job, hospital_ever_or_now, regularly_take_medicine, taken_medicine_in_last3days, taken_tooth_out_in_last7days) values  (true, true, true, false, true, true, true, false, true, true);

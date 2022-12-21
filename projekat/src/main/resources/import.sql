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

-- Lozinka za sve user-e je 123
insert into users (user_type, username, password, name, surname, gender, jmbg, address_id, phone_number, points, user_catagory, enabled) values (1,'marko@gmail.com','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 1, 123123123, 1, '18921892', 5.00, 1, true);
insert into users (user_type, username, password, name, surname, gender, jmbg, address_id, phone_number, points, user_catagory, enabled) values (1,'ana@gmail.com','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Petar', 'Trs', 1, 12, 2, '2313211', 3.00, 2, true);
insert into users (user_type, username, password, name, surname, gender, jmbg, address_id, phone_number, enabled) values (1,'boris@gmail.com','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Md', 'Dh', 1, 121123123, 3, '18921892', true);

insert into users (user_type, username, password, name, surname, gender, jmbg, address_id, phone_number, enabled) values (2, 'goran@gmail.com','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Mil', 'Mar', 0, 321124412, 4, '746352332', true);
insert into users (user_type, username, password, name, surname, gender, jmbg, address_id, phone_number, enabled) values (2, 'sasa@gmail.com','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'To', 'And', 1, 412412123, 5, '574456443', false);

insert into blood_bank_center (name, address_id, description, average_rating) values ('Dunja', 6, 'Najsavremenija oprema.', '3.14');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Phizer', 7, 'Bil Gejts vas čeka.', '4');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Alucard', 8, 'Najprijatniji radnici.', '4.99');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Dracula', 9, 'Stari načini vađenja krvi se vraćaju u modu.', '2.3');
insert into blood_bank_center (name, address_id, description, average_rating) values ('Krpelj', 10, 'Divan banka krvi omeđena prostranim livadama.', '3');

insert into roles (name) values ('ROLE_USER');
insert into roles (name) values ('ROLE_ADMIN');

INSERT INTO USER_ROLE (user_id, role_id) values (1, 1); 
INSERT INTO USER_ROLE (user_id, role_id) values (2, 1); 
INSERT INTO USER_ROLE (user_id, role_id) values (3, 2); 

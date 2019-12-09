-- roles
insert into role (role_id, role) values (1, 'ADMIN');
insert into role (role_id, role) values (2, 'USER');

-- users
insert into user (id, active, email, name, last_name, login, password)
values (1,1,'lucjan@gmail.com', 'Lucjan', 'Pawarotti', 'pawcio', '$2a$10$7x7XKAKB7Snk0qzOlmgmXOaC6KrjrFvCl0bPTKtHagaHlUIgvheLa');

insert into user (id, active, email, name, last_name, login, password)
values (2,1,'adas@gmail.com', 'Adaś', 'Nowakowski', 'adas', '$2a$10$jH12FRY3I7HZxhloF3UlEO2pLNBNwaTcKsYEzZWtAQi8/d/wkPAC6');

-- add roles to users
insert into user_role (user_id, role_id) values (1,2);
insert into user_role (user_id, role_id) values (1,1);
insert into user_role (user_id, role_id) values (2,2);
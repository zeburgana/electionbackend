# INIT db
create database if not exists nasdaq;
create user if not exists 'elector'@'nasdaq' identified by 'password';
grant ALL privileges on nasdaq.* to 'elector'@'localhost';

# INIT DATA
insert into nasdaq.candidate (number, name, summary)
values  (1, 'Jonas', 'Už geresnę ateitį'),
        (2, 'Petras', 'Už blogesnę praeitį'),
        (3, 'Gryčius', 'Už Garstyčias grikiuose'),
        (4, 'Margarita', 'Už mašinų draudimą keliuose'),
        (5, 'Bertalomėja', 'Už <30kvm būtų naikinimą');

insert into nasdaq.voter (vote_id, id, region)
values  (null, 13815766020, 'Kaunas'),
        (null, 14365728482, 'Vilnius'),
        (null, 15386141574, 'Vilnius'),
        (null, 17109855811, 'Šiauliai'),
        (null, 17359489122, 'Vilnius'),
        (null, 28806100527, 'Klaipėda'),
        (null, 29129000336, 'Vilnius'),
        (null, 32593521587, 'Kaunas'),
        (null, 58318870330, 'Vilnius'),
        (null, 64789321580, 'Klaipėda'),
        (null, 67591268423, 'Kaunas'),
        (null, 82691393048, 'Kaunas'),
        (null, 88006928920, 'Kaunas');
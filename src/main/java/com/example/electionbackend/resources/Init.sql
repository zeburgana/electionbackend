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


## INIT FOR statistics
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

insert into nasdaq.vote (candidate_number, id, voter_id)
values  (3, 1, 14365728482),
        (3, 2, 13815766020),
        (1, 3, 15386141574),
        (1, 4, 17109855811),
        (5, 5, 17359489122),
        (5, 6, 28806100527),
        (1, 7, 29129000336),
        (4, 8, 32593521587),
        (3, 9, 58318870330),
        (1, 10, 64789321580),
        (1, 11, 67591268423),
        (1, 12, 82691393048),
        (1, 13, 88006928920);

update nasdaq.voter set vote_id = 2 where nasdaq.voter.id = 13815766020;
update nasdaq.voter set vote_id = 1 where nasdaq.voter.id = 14365728482;
update nasdaq.voter set vote_id = 3 where nasdaq.voter.id = 15386141574;
update nasdaq.voter set vote_id = 4 where nasdaq.voter.id = 17109855811;
update nasdaq.voter set vote_id = 5 where nasdaq.voter.id = 17359489122;
update nasdaq.voter set vote_id = 6 where nasdaq.voter.id = 28806100527;
update nasdaq.voter set vote_id = 7 where nasdaq.voter.id = 29129000336;
update nasdaq.voter set vote_id = 8 where nasdaq.voter.id = 32593521587;
update nasdaq.voter set vote_id = 9 where nasdaq.voter.id = 58318870330;
update nasdaq.voter set vote_id = 10 where nasdaq.voter.id = 64789321580;
update nasdaq.voter set vote_id = 11 where nasdaq.voter.id = 67591268423;
update nasdaq.voter set vote_id = 12 where nasdaq.voter.id = 82691393048;
update nasdaq.voter set vote_id = 13 where nasdaq.voter.id = 88006928920;
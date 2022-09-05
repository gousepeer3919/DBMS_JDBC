drop database ipldb;
create database ipldb;
use ipldb;

create table team(
    team_name VARCHAR(25),
    jersey_colour VARCHAR(20),
    no_of_indianplayers INTEGER,
    no_of_foreignplayers INTEGER,
    no_of_cups INTEGER,
    constraint pk_team PRIMARY KEY(team_name)
);


create table player(
    jersey_number INTEGER,
    player_name VARCHAR(30),
    player_age INTEGER,
    player_price FLOAT,
    player_country VARCHAR(25),
    player_role VARCHAR(20),
    team_name VARCHAR(25),
    constraint pk_player PRIMARY KEY(jersey_number)
);

create table auctioner(
    auctioner_ID INTEGER,
    auctioner_name VARCHAR(30),
    auctioner_mail VARCHAR(50),
    team_name VARCHAR(25),
    constraint pk_auctioner PRIMARY KEY(auctioner_ID)
);

create table sponsor(
    sponsor_ID INTEGER,
    sponsor_name VARCHAR(30),
    sponsor_ceo VARCHAR(30),
    team_name VARCHAR(25),
    constraint pk_sponsor PRIMARY KEY(sponsor_ID)
);


create table owner(
    owner_ID INTEGER,
    constraint pk_owner PRIMARY KEY(owner_ID)
);

alter table player
    add constraint fk_player_team_name FOREIGN KEY(team_name) REFERENCES team(team_name);

alter table auctioner
    add constraint fk_auctioner_team_name FOREIGN KEY(team_name) REFERENCES team(team_name);

alter table sponsor
    add constraint fk_sponsor_team_name FOREIGN KEY(team_name) REFERENCES team(team_name);

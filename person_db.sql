drop database persondb;
drop user person;
create user person with password 'password';
create database persondb with template=template0 owner=person;
\connect persondb;
alter default privileges grant all on tables to person;
alter default privileges grant all on sequences to person;

CREATE TABLE person(
	id UUID NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL
);
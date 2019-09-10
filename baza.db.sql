BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `osoba` (
	`id`	INTEGER,
	`ime`	TEXT,
	`prezime`	TEXT,
	`datumRodjenja`	DATE,
	`adresa`	TEXT,
	FOREIGN KEY(`drzava`) REFERENCES `drzava`,
	PRIMARY KEY(`id`)
);

INSERT INTO `osoba` VALUES (1,'Hamo', 'Hamic', '01.01.1998', 'Provare 12');
INSERT INTO `osoba` VALUES (2,'Haso', 'Hasic', '01.01.1997', 'Sekerova 12');
INSERT INTO `osoba` VALUES (3,'Meho', 'Mehic', '01.01.1996', 'Zmaja od Bosne 12');
INSERT INTO `osoba` VALUES (4,'Ramo', 'Ramic', '01.01.1995', 'Miss Irbina 12');


CREATE TABLE IF NOT EXISTS `pacijent` (
	`id`	INTEGER,
	`osoba`	INTEGER,
	`bolesti`	TEXT,
	`pregledi`	TEXT,
	`lijekovi`	TEXT,
    FOREIGN KEY(`osoba`) REFERENCES `osoba`,
	PRIMARY KEY(`id`)
);

INSERT INTO `pacijent` VALUES (1, 1, ,1);
INSERT INTO `drzava` VALUES (2,'Velika Britanija',2);
INSERT INTO `drzava` VALUES (3,'Austrija',3);

CREATE TABLE IF NOT EXISTS `doktor` (
	`id`	INTEGER,
	`osoba`	INTEGER,
	`specijalizacija`	TEXT,
    FOREIGN KEY(`osoba`) REFERENCES `osoba`,
	PRIMARY KEY(`id`)
);


CREATE TABLE IF NOT EXISTS `medicinskaSestra` (
	`id`	INTEGER,
	`osoba`	INTEGER,
    FOREIGN KEY(`osoba`) REFERENCES `osoba`,
	PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `lijek` (
	`id`	INTEGER,
	`naziv`	TEXT,
	`proizvodjac`	TEXT,
	PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `bolest` (
	`id`	INTEGER,
	`naziv`	TEXT,
	`simptomi`	TEXT,
	PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `pregled` (
	`id`	INTEGER,
	`doktor`	INTEGER,
	`medicinskaSestra`	INTEGER,
	`cijena`	INTEGER,
	`dijagnoza`	INTEGER,
	`opisPregleda`	TEXT,
    FOREIGN KEY(`doktor`) REFERENCES `doktor`,
    FOREIGN KEY(`medicinskaSestra`) REFERENCES `medicinskaSestra`,
    FOREIGN KEY(`dijagnoza`) REFERENCES `bolest`,
	PRIMARY KEY(`id`)
);





COMMIT;

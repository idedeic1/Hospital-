BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `lijek` (
	`id`	INTEGER,
	`naziv`	TEXT,
	`proizvodjac`	TEXT,
	PRIMARY KEY(`id`)
);
INSERT INTO `lijek` VALUES (1,'Ranibos', 'Bosnalijek');
INSERT INTO `lijek` VALUES (2,'Paracetamol', 'Bosnalijek');
INSERT INTO `lijek` VALUES (3,'Aspirin', 'Pliva');
CREATE TABLE IF NOT EXISTS `bolest` (
	`id`	INTEGER,
	`naziv`	TEXT,
	`simptomi`	TEXT,
	PRIMARY KEY(`id`)
);
INSERT INTO `bolest` VALUES (1,'Gripa', 'Temperatura, grlobolja, malaksavost');
INSERT INTO `bolest` VALUES (2,'Secer', 'Malaksavost, vrtoglavica');
INSERT INTO `bolest` VALUES (3,'Depresija', 'Sutljivost, povucenost');
CREATE TABLE IF NOT EXISTS `pacijent` (
	`id`	INTEGER,
	`ime`	TEXT,
	`prezime`	TEXT,
	`bolest`	INTEGER,
	`lijek`	INTEGER,
    FOREIGN KEY(`bolest`) REFERENCES `bolest`,
    FOREIGN KEY(`lijek`) REFERENCES `lijek`,
	PRIMARY KEY(`id`)
);
INSERT INTO `pacijent` VALUES (1,'Hamo', 'Hamic',  1, 1);
INSERT INTO `pacijent` VALUES (2,'Haso', 'Hasic',  2, 2);
INSERT INTO `pacijent` VALUES (3,'Meho', 'Mehic',  3, 3);
CREATE TABLE IF NOT EXISTS `doktor` (
	`id`	INTEGER,
    `ime`	TEXT,
	`prezime`	TEXT,
	`specijalizacija`	TEXT,
	PRIMARY KEY(`id`)
);
INSERT INTO `doktor` VALUES (1,'Ramo', 'Ramic', 'Opca');
CREATE TABLE IF NOT EXISTS `medicinskaSestra` (
	`id`	INTEGER,
	`ime`	TEXT,
	`prezime`	TEXT,
	PRIMARY KEY(`id`)
);
INSERT INTO `medicinskaSestra` VALUES (1,'Seka', 'Sekic');
INSERT INTO `medicinskaSestra` VALUES (2,'Mirna', 'Glasna');
CREATE TABLE IF NOT EXISTS `pregled` (
	`id`	INTEGER,
	`doktor`	INTEGER,
	`medicinskaSestra`	INTEGER,
	`pacijent`	INTEGER,
	`cijena`	INTEGER,
	`dijagnoza`	INTEGER,
	`opisPregleda`	TEXT,
    FOREIGN KEY(`doktor`) REFERENCES `doktor`,
    FOREIGN KEY(`medicinskaSestra`) REFERENCES `medicinskaSestra`,
    FOREIGN KEY(`pacijent`) REFERENCES `pacijent`,
    FOREIGN KEY(`dijagnoza`) REFERENCES `bolest`,
	PRIMARY KEY(`id`)
);
INSERT INTO `pregled` VALUES (1, 1, 1, 1, 50, 1, 'Sve po propisima');
INSERT INTO `pregled` VALUES (2, 1, 1, 2, 150, 1, 'Sve po propisima');
INSERT INTO `pregled` VALUES (3, 1, 1, 3, 250, 1, 'Sve po propisima');
COMMIT;

BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Lieferanten" (
	"id"	INTEGER,
	"Name"	TEXT,
	"Straße"	INTEGER,
	"Hausnummer"	INTEGER,
	"Postleitzahl"	INTEGER,
	"Ort"	TEXT,
	"Mindestbestellwert"	INTEGER,
	"Lieferkosten"	INTEGER,
	"Kategorie_id"	INTEGER,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "Kategorie" (
	"id"	INTEGER,
	"label"	INTEGER,
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "Lieferanten_Kategorie" (
	"lieferanten_id"	INTEGER,
	"kategorie_id"	INTEGER,
	PRIMARY KEY("lieferanten_id","kategorie_id")
);
CREATE TABLE IF NOT EXISTS "Essen" (
	"id"	INTEGER,
	"Name"	TEXT,
	"Produktinfo"	INTEGER,
	"lieferanten_id"	INTEGER,
	"kategorie_id"	INTEGER,
	PRIMARY KEY("id")
);
INSERT INTO "Lieferanten" VALUES (1,'Pizza GO','Landwehrstraße ','60a',28217,'Bremen',8,0,5);
INSERT INTO "Lieferanten" VALUES (2,'City Pizza & Paradise City ','Am Hulsberg ',54,28205,'Bremen',12,0,5);
INSERT INTO "Lieferanten" VALUES (3,'Die Mafia Pizza','Westerstraße ',78,28199,'Bremen',7,0.99,'5, 10');
INSERT INTO "Lieferanten" VALUES (4,'Finepizza','Steffensweg',239,28219,'Bremen',6.99,0,'5, 2');
INSERT INTO "Lieferanten" VALUES (5,'Majon','Steffensweg ',173,28217,'Bremen',9,1,'3, 4');
INSERT INTO "Kategorie" VALUES (1,'Deutsch');
INSERT INTO "Kategorie" VALUES (2,'Burger');
INSERT INTO "Kategorie" VALUES (3,'Chinesisch');
INSERT INTO "Kategorie" VALUES (4,'Asiatisch ');
INSERT INTO "Kategorie" VALUES (5,'Italienisch');
INSERT INTO "Kategorie" VALUES (6,'Türkisch');
INSERT INTO "Kategorie" VALUES (7,'Arabisch');
INSERT INTO "Kategorie" VALUES (8,'Syrisch');
INSERT INTO "Kategorie" VALUES (9,'Amerikanisch');
INSERT INTO "Kategorie" VALUES (10,'Griechisch');
INSERT INTO "Lieferanten_Kategorie" VALUES (1,5);
INSERT INTO "Lieferanten_Kategorie" VALUES (2,2);
INSERT INTO "Lieferanten_Kategorie" VALUES (3,5);
INSERT INTO "Lieferanten_Kategorie" VALUES (4,3);
INSERT INTO "Lieferanten_Kategorie" VALUES (5,'3, 4');
INSERT INTO "Essen" VALUES (1,'Pizza Salami','mit Salami','1, 2, 3, 4',5);
INSERT INTO "Essen" VALUES (2,'Pizza Sucuk','mit Sucuk','1, 2, 3, 4',5);
INSERT INTO "Essen" VALUES (3,'Gebackenes Huhn','mit Sauce nach Wahl',5,'3, 4');
INSERT INTO "Essen" VALUES (4,'Gebackene Ente','mit Sauce nach Wahl',5,'3, 4');
INSERT INTO "Essen" VALUES (5,'Pasta Milano','mit Tomaten-Sahnesauce, Rindersteakstreifen, Paprika, Jalapenos und Zwiebeln','1, 2, 4',5);
INSERT INTO "Essen" VALUES (6,'Schnitzel Jäger Art	','mit Champignonsauce',3,1);
COMMIT;

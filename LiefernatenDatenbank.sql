BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "LiefernatenDatenbank" (
	"LieferantenID"	INTEGER,
	"Name"	TEXT,
	"Adresse"	TEXT,
	"Postleitzahl"	INTEGER,
	"Mindestbestellwert"	INTEGER,
	"Lieferkosten"	INTEGER,
	"Essen"	INTEGER
);
INSERT INTO "LiefernatenDatenbank" VALUES (1,'Pizza Go','Landwehrstraße 60a','28217 Bremen','8,00€','0,00€','Italienische Pizza, Salate, Pasta ');
INSERT INTO "LiefernatenDatenbank" VALUES (2,'Sushi Kaiser','Herdentorsteinweg 1','28195 Bremen ','10,00€
','0,00€','Sushi, Bowls');
INSERT INTO "LiefernatenDatenbank" VALUES (3,'Bon Joy´s','Pappelstraße 44
','28199 Bremen ','8,00€','0,00€','Pizza');
INSERT INTO "LiefernatenDatenbank" VALUES (4,'Star Pizza','Nicolaistraße 36','28195 Bremen ','8,00€','0,00€','Pizza');
INSERT INTO "LiefernatenDatenbank" VALUES (5,'burger me
','Wartburgstr 62

','28217 Bremen ','6,99€','1,99€','Burger');
INSERT INTO "LiefernatenDatenbank" VALUES (6,'Finepizza','Steffensweg 239

','28219 Bremen ','6,90€','0,00€','Pasta, Pizza');
INSERT INTO "LiefernatenDatenbank" VALUES (7,'Du & Ich','Findorffstraße 76-78
 ','28215 Bremen','20,00€','0,00€','Italienisch, Italienische Pizza, Pasta ');
INSERT INTO "LiefernatenDatenbank" VALUES (8,'Al Mir Imbiss ','Wartburgstraße 15
 ','28217 Bremen','7,00€','1,00€','Türkisch, Türkische Pizza, Döner ');
INSERT INTO "LiefernatenDatenbank" VALUES (9,'Galileo Pizza, Burger & more ','Langemarckstrasse 127
','28199 Bremen ','9,00€','0,00€','Italienische Pizza, Burger, Pasta ');
INSERT INTO "LiefernatenDatenbank" VALUES (10,'Majon','Steffensweg 173','28217 Bremen ','9,00€','1,00€','Chinesisch, Thailändisch, Asiatisch ');
COMMIT;

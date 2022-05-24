-- HIZTEGIA.DB datu-basea sortzeko komandoak:
.open C:\\Users\\imadariaga\\Documents\\PROGRAMAZIOA\\program2020\\UD4\\HiztegiarenInguruan\\HiztegiaSQlite\\db\\Hiztegia.db
 


DROP TABLE Terminoak;
CREATE TABLE Terminoak(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  euskaraz VARCHAR(20),
  gazteleraz VARCHAR(20));

INSERT INTO Terminoak VALUES(null,"sagarra","manzana");
INSERT INTO Terminoak(euskaraz,gazteleraz) VALUES("madaria","pera");
INSERT INTO Terminoak(euskaraz,gazteleraz) VALUES("marrubia","fresa");
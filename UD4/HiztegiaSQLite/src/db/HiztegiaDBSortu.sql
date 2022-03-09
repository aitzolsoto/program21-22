/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  soto.aitzol
 * Created: 09-mar-2022
 */

DROP TABLE Terminoak;
CREATE TABLE Terminoak(id INTEGER PRIMARY KEY AUTOINCREMENT, euskaraz VARCHAR(20), gazteleraz VARCHAR(20));

INSERT INTO Terminoak VALUES(null, "sagarra", "manzana");
INSERT INTO Terminoak(euskaraz,gazteleraz) VALUES ("madaria", "pera");
INSERT INTO Terminoak(euskaraz,gazteleraz) VALUES ("marrubia", "fresa");


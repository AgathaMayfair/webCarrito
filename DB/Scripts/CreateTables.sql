USE carrito_master;

CREATE TABLE `role`(
	`RoleID` INT NOT NULL AUTO_INCREMENT,
    `NameOfRole` VARCHAR(30) NOT NULL,
    `Code` CHAR(3) NOT NULL,
    `Description` VARCHAR(250),
     PRIMARY KEY (RoleID)
);

ALTER TABLE `role` ADD UNIQUE (`Code`); 

CREATE TABLE `user`(
	`UserID` INT NOT NULL AUTO_INCREMENT,
    `RoleID` INT NOT NULL,
    `Name` VARCHAR(30) NOT NULL,
    `Surname` VARCHAR(30) NOT NULL,
    `CI` VARCHAR(30) NOT NULL UNIQUE,
    `Phone` VARCHAR(30),
    `Adress` VARCHAR(100) NOT NULL,
    `Correo` VARCHAR(30) NOT NULL,
    `Password` VARCHAR(30) NOT NULL,
    PRIMARY KEY (UserID),   
    FOREIGN KEY (RoleID) REFERENCES `role`(RoleID)
);
ALTER TABLE `user` RENAME column `Adress` TO `Address`;
ALTER TABLE `user` RENAME column `Correo` TO `Mail`;


CREATE TABLE `headerFacturation`(
	`HeaderFacturationID` INT NOT NULL AUTO_INCREMENT,
    `UserID` INT NOT NULL,
    `Date` DATE NOT NULL,
    `TotalAmount` INT NOT NULL,
    `FacturationNumber` INT NOT NULL,
    PRIMARY KEY (HeaderFacturationID),
    FOREIGN KEY (UserID) REFERENCES user(UserID)
);

ALTER TABLE `headerFacturation` MODIFY COLUMN `TotalAmount` decimal(15,5);

CREATE TABLE `facturationLines`(
	`FacturationLinesID` INT NOT NULL AUTO_INCREMENT,
    `HeaderFacturationID` INT NOT NULL,
    `ProductName` VARCHAR(30) NOT NULL,
    `Brand` VARCHAR(50) NOT NULL,
    `Price` INT,
    `ProductCode` CHAR(10) NOT NULL,    
    PRIMARY KEY (FacturationLinesID),
    FOREIGN KEY (HeaderFacturationID) REFERENCES headerFacturation(HeaderFacturationID)
);

ALTER TABLE `facturationLines` MODIFY COLUMN `Price` decimal(15,5);

CREATE TABLE `products` (
	`ProductID` INT NOT NULL AUTO_INCREMENT,
    `ProductName` VARCHAR(30) NOT NULL,
    `Description` VARCHAR(300) NOT NULL,
    `Brand` VARCHAR(50) NOT NULL,
    `Provider` VARCHAR(50) NOT NULL,
    `Price` INT,
    `AvailableQuantity` INT NOT NULL,
    `SellQuantity` INT NOT NULL,
    `RegisterDate` DATE NOT NULL,
    `ProductCode` CHAR(10) NOT NULL,
    PRIMARY KEY (ProductID)
);

ALTER TABLE `products` MODIFY COLUMN `Price` decimal(15,5);

CREATE TABLE `priceHistoric` (
	`PriceHistoricID` INT NOT NULL AUTO_INCREMENT,
    `ProductID` INT NOT NULL,
    `ProductName` VARCHAR(30) NOT NULL,
    `Price` INT,
    `RegisterDate` DATE NOT NULL,
    `ProductCode` CHAR(10) NOT NULL,
    PRIMARY KEY (PriceHistoricID),
    FOREIGN KEY (ProductID) REFERENCES products(ProductID)
);

ALTER TABLE `priceHistoric` MODIFY COLUMN `Price` decimal(15,5);
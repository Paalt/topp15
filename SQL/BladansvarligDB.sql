CREATE TABLE IF NOT EXISTS `Gruppe` (
  `GruppeID` INT NOT NULL AUTO_INCREMENT,
  `Gruppenavn` VARCHAR(45) NULL,
  `Mål` INT NULL,
  `Måned` DATE NULL,
  PRIMARY KEY (`GruppeID`));
  
  CREATE TABLE IF NOT EXISTS `Bruker` (
  `Forhandlernr` INT NOT NULL,
  `Passord` INT NOT NULL,
  `GruppeNr` INT NULL,
  `Poeng` INT NULL,
  `Status` INT NULL,
  `Multiplier` INT NULL DEFAULT 0,
  `Salgsbadge` INT NULL DEFAULT 0,
  `Sjekklister_Gjort` INT NULL,
  PRIMARY KEY (`Forhandlernr`),
  CONSTRAINT `GruppeNr`
    FOREIGN KEY (`GruppeNr`)
    REFERENCES `Gruppe` (`GruppeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `Sjekkliste` (
  `Forhandlernr` INT NOT NULL,
  `Timestamp` TIMESTAMP NULL,
  `Steps completed` INT NULL,
  PRIMARY KEY (`Forhandlernr`),
  CONSTRAINT `Forhandlernr`
    FOREIGN KEY (`Forhandlernr`)
    REFERENCES `Bruker` (`Forhandlernr`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

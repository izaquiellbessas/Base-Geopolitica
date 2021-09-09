-- MySQL Script generated by MySQL Workbench
-- Thu Sep  9 15:17:26 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema geografia
-- -----------------------------------------------------
-- Sistema de Gerenciamento de Regiões Geográficas e/ou Geopolíticas - Base fundamental para demais sistemas que envolvem geopolítica
DROP SCHEMA IF EXISTS `geografia` ;

-- -----------------------------------------------------
-- Schema geografia
--
-- Sistema de Gerenciamento de Regiões Geográficas e/ou Geopolíticas - Base fundamental para demais sistemas que envolvem geopolítica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `geografia` ;
USE `geografia` ;

-- -----------------------------------------------------
-- Table `geografia`.`geo_Paises`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Paises` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Paises` (
  `nome` VARCHAR(90) NOT NULL,
  `iso_alpha2` VARCHAR(2) NOT NULL,
  `iso_alpha3` VARCHAR(3) NOT NULL,
  `iso_numero` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`iso_alpha3`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Regioes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Regioes` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Regioes` (
  `id_regiao` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sigla` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`id_regiao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Estados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Estados` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Estados` (
  `id_estado` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sigla_uf` VARCHAR(2) NOT NULL,
  `fk_pais` VARCHAR(3) NULL,
  `fk_id_regiao` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id_estado`),
  CONSTRAINT `fk_Estados_Paises`
    FOREIGN KEY (`fk_pais`)
    REFERENCES `geografia`.`geo_Paises` (`iso_alpha3`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estados_Regioes`
    FOREIGN KEY (`fk_id_regiao`)
    REFERENCES `geografia`.`geo_Regioes` (`id_regiao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Estados_Paises_idx` ON `geografia`.`geo_Estados` (`fk_pais` ASC) VISIBLE;

CREATE INDEX `fk_geo_Estados_geo_Regioes_idx` ON `geografia`.`geo_Estados` (`fk_id_regiao` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Mesorregioes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Mesorregioes` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Mesorregioes` (
  `id_mesorregiao` VARCHAR(2) NOT NULL,
  `fk_id_estado` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`id_mesorregiao`, `fk_id_estado`),
  CONSTRAINT `fk_geo_Mesorregioes_geo_Estados1`
    FOREIGN KEY (`fk_id_estado`)
    REFERENCES `geografia`.`geo_Estados` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_geo_Mesorregioes_geo_Estados1_idx` ON `geografia`.`geo_Mesorregioes` (`fk_id_estado` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Microrregioes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Microrregioes` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Microrregioes` (
  `id_microrregiao` VARCHAR(3) NOT NULL,
  `fk_id_estado` VARCHAR(2) NOT NULL,
  `fk_id_mesorregiao` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`id_microrregiao`, `fk_id_estado`, `fk_id_mesorregiao`),
  CONSTRAINT `fk_geo_Microrregioes_geo_Mesorregioes1`
    FOREIGN KEY (`fk_id_mesorregiao` , `fk_id_estado`)
    REFERENCES `geografia`.`geo_Mesorregioes` (`id_mesorregiao` , `fk_id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_geo_Microrregioes_geo_Mesorregioes1_idx` ON `geografia`.`geo_Microrregioes` (`fk_id_mesorregiao` ASC, `fk_id_estado` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Regiao_Intermediaria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Regiao_Intermediaria` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Regiao_Intermediaria` (
  `id_regiao_intermediaria` INT NOT NULL,
  `fk_id_estado` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_regiao_intermediaria`, `fk_id_estado`),
  CONSTRAINT `fk_geo_Regiao_Intermediaria_geo_Estados1`
    FOREIGN KEY (`fk_id_estado`)
    REFERENCES `geografia`.`geo_Estados` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_geo_Regiao_Intermediaria_geo_Estados1_idx` ON `geografia`.`geo_Regiao_Intermediaria` (`fk_id_estado` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Regiao_Imediata`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Regiao_Imediata` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Regiao_Imediata` (
  `id_regiao_imediata` INT NOT NULL,
  `fk_id_regiao_intermediaria` INT NOT NULL,
  `fk_id_estado` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_regiao_imediata`, `fk_id_regiao_intermediaria`, `fk_id_estado`),
  CONSTRAINT `fk_geo_Regiao_Imediata_geo_Regiao_Intermediaria1`
    FOREIGN KEY (`fk_id_regiao_intermediaria` , `fk_id_estado`)
    REFERENCES `geografia`.`geo_Regiao_Intermediaria` (`id_regiao_intermediaria` , `fk_id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_geo_Regiao_Imediata_geo_Regiao_Intermediaria1_idx` ON `geografia`.`geo_Regiao_Imediata` (`fk_id_regiao_intermediaria` ASC, `fk_id_estado` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Cidades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Cidades` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Cidades` (
  `id_cidade` VARCHAR(7) NOT NULL,
  `codigo_municipio` VARCHAR(5) NOT NULL,
  `nome` VARCHAR(120) NOT NULL,
  `geo_latitude` VARCHAR(255) NULL,
  `geo_longitude` VARCHAR(255) NULL,
  `geo_altitude` VARCHAR(255) NULL,
  `fk_id_microrregiao` VARCHAR(3) NOT NULL,
  `fk_id_estado` VARCHAR(2) NOT NULL,
  `fk_id_mesorregiao` VARCHAR(2) NOT NULL,
  `fk_id_regiao_imediata` INT NOT NULL,
  `fk_id_regiao_intermediaria` INT NOT NULL,
  `fk_id_estado` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id_cidade`),
  CONSTRAINT `fk_geo_Cidades_geo_Microrregioes1`
    FOREIGN KEY (`fk_id_microrregiao` , `fk_id_estado` , `fk_id_mesorregiao`)
    REFERENCES `geografia`.`geo_Microrregioes` (`id_microrregiao` , `fk_id_estado` , `fk_id_mesorregiao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_geo_Cidades_geo_Regiao_Imediata1`
    FOREIGN KEY (`fk_id_regiao_imediata` , `fk_id_regiao_intermediaria` , `fk_id_estado`)
    REFERENCES `geografia`.`geo_Regiao_Imediata` (`id_regiao_imediata` , `fk_id_regiao_intermediaria` , `fk_id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_geo_Cidades_geo_Microrregioes1_idx` ON `geografia`.`geo_Cidades` (`fk_id_microrregiao` ASC, `fk_id_estado` ASC, `fk_id_mesorregiao` ASC) VISIBLE;

CREATE INDEX `fk_geo_Cidades_geo_Regiao_Imediata1_idx` ON `geografia`.`geo_Cidades` (`fk_id_regiao_imediata` ASC, `fk_id_regiao_intermediaria` ASC, `fk_id_estado` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Distritos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Distritos` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Distritos` (
  `id_distrito` VARCHAR(9) NOT NULL,
  `codigo_distrito` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(120) NOT NULL,
  `geo_latitude` VARCHAR(255) NULL,
  `geo_longitude` VARCHAR(255) NULL,
  `geo_altitude` VARCHAR(255) NULL,
  `fk_id_cidade` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`id_distrito`),
  CONSTRAINT `fk_Distritos_Cidades`
    FOREIGN KEY (`fk_id_cidade`)
    REFERENCES `geografia`.`geo_Cidades` (`id_cidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Distritos_Cidades1_idx` ON `geografia`.`geo_Distritos` (`fk_id_cidade` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Sub_Distritos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Sub_Distritos` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Sub_Distritos` (
  `id_sub_distrito` VARCHAR(11) NOT NULL,
  `codigo_sub_distrito` VARCHAR(2) NOT NULL,
  `nome` VARCHAR(120) NOT NULL,
  `geo_latitude` VARCHAR(255) NULL,
  `geo_longitude` VARCHAR(255) NULL,
  `geo_altitude` VARCHAR(255) NULL,
  `fk_id_distrito` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`id_sub_distrito`),
  CONSTRAINT `fk_geo_Sub_Distritos_geo_Distritos1`
    FOREIGN KEY (`fk_id_distrito`)
    REFERENCES `geografia`.`geo_Distritos` (`id_distrito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_geo_Sub_Distritos_geo_Distritos1_idx` ON `geografia`.`geo_Sub_Distritos` (`fk_id_distrito` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Cidades_Aniversarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Cidades_Aniversarios` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Cidades_Aniversarios` (
  `raiz_id_cidade` VARCHAR(6) NOT NULL,
  `mes` INT NOT NULL,
  `dia` INT NOT NULL,
  PRIMARY KEY (`raiz_id_cidade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Indicadores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Indicadores` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Indicadores` (
  `id_indicador` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_indicador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `geografia`.`geo_Cidades_Indicadores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`geo_Cidades_Indicadores` ;

CREATE TABLE IF NOT EXISTS `geografia`.`geo_Cidades_Indicadores` (
  `fk_id_indicador` INT NOT NULL,
  `fk_id_cidade` VARCHAR(7) NOT NULL,
  `valor_quantitativo` FLOAT NOT NULL,
  `data_inicial` DATETIME NOT NULL,
  `data_final` DATETIME NOT NULL,
  PRIMARY KEY (`fk_id_indicador`, `fk_id_cidade`),
  CONSTRAINT `fk_geo_Indicadores_has_geo_Cidades_geo_Indicadores1`
    FOREIGN KEY (`fk_id_indicador`)
    REFERENCES `geografia`.`geo_Indicadores` (`id_indicador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_geo_Indicadores_has_geo_Cidades_geo_Cidades1`
    FOREIGN KEY (`fk_id_cidade`)
    REFERENCES `geografia`.`geo_Cidades` (`id_cidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_geo_Indicadores_has_geo_Cidades_geo_Cidades1_idx` ON `geografia`.`geo_Cidades_Indicadores` (`fk_id_cidade` ASC) VISIBLE;

CREATE INDEX `fk_geo_Indicadores_has_geo_Cidades_geo_Indicadores1_idx` ON `geografia`.`geo_Cidades_Indicadores` (`fk_id_indicador` ASC) VISIBLE;

USE `geografia` ;

-- -----------------------------------------------------
-- Placeholder table for view `geografia`.`view_regioes_mesorregioes_microrregioes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geografia`.`view_regioes_mesorregioes_microrregioes` (`'Microrregião'` INT, `'Mesorregião'` INT, `'UF'` INT, `'Região'` INT);

-- -----------------------------------------------------
-- Placeholder table for view `geografia`.`view_cidades_com_estados_e_regioes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geografia`.`view_cidades_com_estados_e_regioes` (`"Código"` INT, `"Cidades"` INT, `"UF"` INT, `'Região'` INT);

-- -----------------------------------------------------
-- Placeholder table for view `geografia`.`view_cidades_com_todas_caracteristicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geografia`.`view_cidades_com_todas_caracteristicas` (`'Cidade'` INT, `'Microrregião'` INT, `'Mesorregião'` INT, `'UF'` INT, `'Região'` INT, `'Latitude'` INT, `'Longitude'` INT, `'Altitude'` INT);

-- -----------------------------------------------------
-- Placeholder table for view `geografia`.`view_cidades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geografia`.`view_cidades` (`'Cidade'` INT, `'Microrregião'` INT, `'Mesorregião'` INT, `'UF'` INT, `'Região'` INT);

-- -----------------------------------------------------
-- Placeholder table for view `geografia`.`view_cidades_com_distritos_completo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geografia`.`view_cidades_com_distritos_completo` (`'Cidade'` INT, `'Microrregião'` INT, `'Mesorregião'` INT, `'UF'` INT, `'Região'` INT, `'Distrito'` INT);

-- -----------------------------------------------------
-- Placeholder table for view `geografia`.`view_cidades_com_distritos_e_subdistritos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `geografia`.`view_cidades_com_distritos_e_subdistritos` (`'Cidade'` INT, `'Microrregião'` INT, `'Mesorregião'` INT, `'UF'` INT, `'Região'` INT, `'Distrito'` INT, `'Sub-distritos'` INT);

-- -----------------------------------------------------
-- View `geografia`.`view_regioes_mesorregioes_microrregioes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`view_regioes_mesorregioes_microrregioes`;
DROP VIEW IF EXISTS `geografia`.`view_regioes_mesorregioes_microrregioes` ;
USE `geografia`;
CREATE  OR REPLACE VIEW `view_regioes_mesorregioes_microrregioes` AS
SELECT
	microrregioes.nome AS 'Microrregião',
	mesorregioes.nome AS 'Mesorregião',
	estados.sigla_uf AS 'UF',
	regioes.nome AS 'Região'
FROM 
	geo_microrregioes AS microrregioes,
	geo_mesorregioes AS mesorregioes,
	geo_regioes AS regioes,
	geo_estados AS estados
WHERE
	regioes.id_regiao = estados.fk_id_regiao
	AND mesorregioes.fk_id_estado = estados.id_estado
    AND microrregioes.fk_id_estado = estados.id_estado
    AND microrregioes.fk_id_mesorregiao = mesorregioes.id_mesorregiao
ORDER BY regioes.nome, estados.sigla_uf, mesorregioes.nome, microrregioes.nome
;

-- -----------------------------------------------------
-- View `geografia`.`view_cidades_com_estados_e_regioes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`view_cidades_com_estados_e_regioes`;
DROP VIEW IF EXISTS `geografia`.`view_cidades_com_estados_e_regioes` ;
USE `geografia`;
CREATE  OR REPLACE VIEW `view_cidades_com_estados_e_regioes` AS
SELECT cidades.id_cidade AS "Código",
        cidades.nome AS "Cidades",
		estados.sigla_uf AS "UF",
        regioes.nome AS 'Região'
    FROM geo_cidades AS cidades,
		 geo_estados AS estados JOIN geo_regioes AS regioes
	WHERE estados.fk_id_regiao = regioes.id_regiao
		AND cidades.fk_id_estado = estados.id_estado
	ORDER BY regioes.nome, estados.sigla_uf, cidades.nome;

-- -----------------------------------------------------
-- View `geografia`.`view_cidades_com_todas_caracteristicas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`view_cidades_com_todas_caracteristicas`;
DROP VIEW IF EXISTS `geografia`.`view_cidades_com_todas_caracteristicas` ;
USE `geografia`;
CREATE  OR REPLACE VIEW `view_cidades_com_todas_caracteristicas` AS
SELECT
	cidades.nome AS 'Cidade',
	microrregioes.nome AS 'Microrregião',
	mesorregioes.nome AS 'Mesorregião',
	estados.sigla_uf AS 'UF',
	regioes.nome AS 'Região',
    cidades.geo_latitude AS 'Latitude',
    cidades.geo_longitude AS 'Longitude',
    cidades.geo_altitude AS 'Altitude'
FROM 
	geo_cidades AS cidades,
	geo_microrregioes AS microrregioes,
	geo_mesorregioes AS mesorregioes,
	geo_regioes AS regioes,
	geo_estados AS estados
WHERE
	regioes.id_regiao = estados.fk_id_regiao
	AND mesorregioes.fk_id_estado = estados.id_estado
    AND microrregioes.fk_id_estado = estados.id_estado
    AND microrregioes.fk_id_mesorregiao = mesorregioes.id_mesorregiao
    AND cidades.fk_id_estado = estados.id_estado
    AND cidades.fk_id_mesorregiao = mesorregioes.id_mesorregiao
    AND cidades.fk_id_microrregiao = microrregioes.id_microrregiao
ORDER BY regioes.nome, estados.sigla_uf, mesorregioes.nome, microrregioes.nome, cidades.nome;

-- -----------------------------------------------------
-- View `geografia`.`view_cidades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`view_cidades`;
DROP VIEW IF EXISTS `geografia`.`view_cidades` ;
USE `geografia`;
CREATE  OR REPLACE VIEW `view_cidades` AS
SELECT
	cidades.nome AS 'Cidade',
	microrregioes.nome AS 'Microrregião',
	mesorregioes.nome AS 'Mesorregião',
	estados.sigla_uf AS 'UF',
	regioes.nome AS 'Região'
FROM 
	geo_cidades AS cidades,
	geo_microrregioes AS microrregioes,
	geo_mesorregioes AS mesorregioes,
	geo_regioes AS regioes,
	geo_estados AS estados
WHERE
	regioes.id_regiao = estados.fk_id_regiao
	AND mesorregioes.fk_id_estado = estados.id_estado
    AND microrregioes.fk_id_estado = estados.id_estado
    AND microrregioes.fk_id_mesorregiao = mesorregioes.id_mesorregiao
    AND cidades.fk_id_estado = estados.id_estado
    AND cidades.fk_id_mesorregiao = mesorregioes.id_mesorregiao
    AND cidades.fk_id_microrregiao = microrregioes.id_microrregiao
ORDER BY regioes.nome, estados.sigla_uf, mesorregioes.nome, microrregioes.nome, cidades.nome;

-- -----------------------------------------------------
-- View `geografia`.`view_cidades_com_distritos_completo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`view_cidades_com_distritos_completo`;
DROP VIEW IF EXISTS `geografia`.`view_cidades_com_distritos_completo` ;
USE `geografia`;
CREATE  OR REPLACE VIEW `view_cidades_com_distritos_completo` AS
SELECT
	cidades.nome AS 'Cidade',
	microrregioes.nome AS 'Microrregião',
	mesorregioes.nome AS 'Mesorregião',
	estados.sigla_uf AS 'UF',
	regioes.nome AS 'Região',
    distritos.nome AS 'Distrito'
FROM 
	geo_cidades AS cidades,
	geo_microrregioes AS microrregioes,
	geo_mesorregioes AS mesorregioes,
	geo_regioes AS regioes,
	geo_estados AS estados,
    geo_distritos AS distritos
WHERE
	regioes.id_regiao = estados.fk_id_regiao
	AND mesorregioes.fk_id_estado = estados.id_estado
    AND microrregioes.fk_id_estado = estados.id_estado
    AND microrregioes.fk_id_mesorregiao = mesorregioes.id_mesorregiao
    AND cidades.fk_id_estado = estados.id_estado
    AND cidades.fk_id_mesorregiao = mesorregioes.id_mesorregiao
    AND cidades.fk_id_microrregiao = microrregioes.id_microrregiao
    AND distritos.fk_id_cidade = cidades.id_cidade
ORDER BY regioes.nome, estados.sigla_uf, mesorregioes.nome, microrregioes.nome, cidades.nome, distritos.nome;

-- -----------------------------------------------------
-- View `geografia`.`view_cidades_com_distritos_e_subdistritos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `geografia`.`view_cidades_com_distritos_e_subdistritos`;
DROP VIEW IF EXISTS `geografia`.`view_cidades_com_distritos_e_subdistritos` ;
USE `geografia`;
CREATE  OR REPLACE VIEW `view_cidades_com_distritos_e_subdistritos` AS
SELECT
	cidades.nome AS 'Cidade',
	microrregioes.nome AS 'Microrregião',
	mesorregioes.nome AS 'Mesorregião',
	estados.sigla_uf AS 'UF',
	regioes.nome AS 'Região',
    distritos.nome AS 'Distrito',
    subdistritos.nome AS 'Sub-distritos'
FROM 
	geo_cidades AS cidades,
	geo_microrregioes AS microrregioes,
	geo_mesorregioes AS mesorregioes,
	geo_regioes AS regioes,
	geo_estados AS estados,
    geo_distritos AS distritos,
    geo_sub_distritos AS subdistritos
WHERE
	regioes.id_regiao = estados.fk_id_regiao
	AND mesorregioes.fk_id_estado = estados.id_estado
    AND microrregioes.fk_id_estado = estados.id_estado
    AND microrregioes.fk_id_mesorregiao = mesorregioes.id_mesorregiao
    AND cidades.fk_id_estado = estados.id_estado
    AND cidades.fk_id_mesorregiao = mesorregioes.id_mesorregiao
    AND cidades.fk_id_microrregiao = microrregioes.id_microrregiao
    AND distritos.fk_id_cidade = cidades.id_cidade
    AND subdistritos.fk_id_distrito = distritos.id_distrito
ORDER BY regioes.nome, estados.sigla_uf, mesorregioes.nome, microrregioes.nome, cidades.nome, distritos.nome, subdistritos.nome;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

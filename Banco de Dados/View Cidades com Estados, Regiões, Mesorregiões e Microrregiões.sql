CREATE VIEW `view_cidades` AS
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
ORDER BY regioes.nome, estados.sigla_uf, mesorregioes.nome, microrregioes.nome, cidades.nome
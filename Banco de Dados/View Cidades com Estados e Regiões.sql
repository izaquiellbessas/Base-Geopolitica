CREATE VIEW `view_cidades_com_estados_e_regioes` AS
SELECT cidades.codigo_ibge AS 'Código IBGE',
	   cidades.nome AS 'Cidades',
	   microrregioes.nome AS 'Microrregião',
	   mesorregioes.nome AS 'Mesorregião',
       estados.sigla_uf AS 'Estado/UF',
       regioes.nome AS 'Região'
FROM geografia.geo_cidades AS cidades,
	 geografia.geo_regioes AS regioes,
	 geografia.geo_mesorregioes AS mesorregioes,
     geografia.geo_microrregioes AS microrregioes,
     geografia.geo_estados AS estados
WHERE mesorregioes.id_mesorregiao = microrregioes.fk_id_mesoregiao AND 
	  mesorregioes.fk_id_regiao = regioes.id_regiao AND
      cidades.fk_id_microrregiao = microrregioes.id_micrroregiao AND
      cidades.fk_id_estado = estados.id_estado
ORDER BY regioes.nome, estados.sigla_uf, mesorregioes.nome, microrregioes.nome, cidades.nome
;
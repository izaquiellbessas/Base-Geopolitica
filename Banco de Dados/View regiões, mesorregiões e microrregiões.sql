CREATE VIEW `view_regioes_mesorregioes_microrregioes` AS
SELECT microrregioes.nome AS 'Microrregião',
	   mesorregioes.nome AS 'Mesorregião',
       regioes.nome AS 'Região'
FROM geografia.regioes AS regioes,
	 geografia.mesorregioes AS mesorregioes,
     geografia.microrregioes AS microrregioes
WHERE mesorregioes.id_mesorregiao = microrregioes.fk_id_mesoregiao AND 
	  mesorregioes.fk_id_regiao = regioes.id_regiao
ORDER BY regioes.nome, mesorregioes.nome, microrregioes.nome
;
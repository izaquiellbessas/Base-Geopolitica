CREATE VIEW `view_cidades_com_estados_e_regioes` AS
SELECT cidades.id_cidade AS "Código",
        cidades.nome AS "Cidades",
		estados.sigla_uf AS "UF",
        regioes.nome AS 'Região'
    FROM geo_cidades AS cidades,
		 geo_estados AS estados JOIN geo_regioes AS regioes
	WHERE estados.fk_id_regiao = regioes.id_regiao
		AND cidades.fk_id_estado = estados.id_estado
	ORDER BY regioes.nome, estados.sigla_uf, cidades.nome;
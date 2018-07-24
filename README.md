# Base-Geopolitica

Este projeto tem o objetivo de disponibilizar um banco de dados com informações geográficas para serem usadas em sistemas de informações que necessitam, para qualquer tarefa, fazer uso de informações como: País, Estado, Região e subrregiões, e Cidades.

Para tanto foi projetado um banco de dados otimizado de acordo com as normas de otimização de tabelas e relacionamentos, o qual é apresentado pela sua documentação, Diagrama Entidade-Relacionamento (DER) que pode ser acessado na pasta de Documentação deste projeto.

<h2>DER:</h2>
<img src="https://github.com/izaquiellbessas/Base-Geopolitica/blob/master/Documenta%C3%A7%C3%A3o/DER%20Geral.png?raw=true" alt="DER" />

O projeto já conta com um banco de dados populado que disponibiliza:
<ol>
  <li> Países, com seus respectivos códigos de ISO. </li>
  <li> Estados brasileiros com o seu código sendo o mesmo utilizado pelo IBGE. </li>
  <li> Regiões brasileiras, tais como Sul, Sudeste, Centro-Oeste, Norte e Nordeste. </li>
  <li> Subrregiões brasileiras, chamadas de mesorregiões (as quais estão contidas nas Regiões) e microrregiões (que por sua vez estão contidas nas Mesorregiões).
  <li> Cidades brasileiras, com latitude, longitude, altitude, código IBGE e seus relacionamentos com as Microrregiões e Estados. </li>
</ol>

Todo o conteúdo que povoa o banco de dados foi fruto de mineiração de dados disponibilizados publicamente na internet. A maior parte das informações sobre cidades, estados e regiões brasileiras foi obtida no site do IBGE.

O projeto visa ainda a criação de uma tabela de bairros e endereços com CEP. Contudo, há um projeto que disponibiliza consulta gratuíta via API que retorna arquivo JSON com tal conteúdo no link: http://www.cepaberto.com/api_key

O Script de criação do Banco de Dados com os dados para povoá-lo é muito grande para ser exibido atualmente pelo Github, aqui vai alguns exemplos de conteúdos que são inseridos:
<h3>Países</h3>
INSERT INTO `geografia`.`Paises` (`nome`, `iso_alpha2`, `iso_alpha3`, `iso_numero`) VALUES ('Chade', 'TD', ' TCD', ' 148');
INSERT INTO `geografia`.`Paises` (`nome`, `iso_alpha2`, `iso_alpha3`, `iso_numero`) VALUES ('Chile', 'CL', ' CHL', ' 152');
INSERT INTO `geografia`.`Paises` (`nome`, `iso_alpha2`, `iso_alpha3`, `iso_numero`) VALUES ('China', 'CN', ' CHN', ' 156');
INSERT INTO `geografia`.`Paises` (`nome`, `iso_alpha2`, `iso_alpha3`, `iso_numero`) VALUES ('Ilha Christmas', 'CX', ' CXR', ' 162');

<h3>Estados</h3>
INSERT INTO `geografia`.`Estados` (`id_estado`, `nome`, `sigla_uf`, `fk_pais`) VALUES (﻿11, 'Rondônia', 'RO', 'BRA');
INSERT INTO `geografia`.`Estados` (`id_estado`, `nome`, `sigla_uf`, `fk_pais`) VALUES (12, 'Acre', 'AC', 'BRA');
INSERT INTO `geografia`.`Estados` (`id_estado`, `nome`, `sigla_uf`, `fk_pais`) VALUES (13, 'Amazonas', 'AM', 'BRA');
INSERT INTO `geografia`.`Estados` (`id_estado`, `nome`, `sigla_uf`, `fk_pais`) VALUES (14, 'Roraima', 'RR', 'BRA');
INSERT INTO `geografia`.`Estados` (`id_estado`, `nome`, `sigla_uf`, `fk_pais`) VALUES (15, 'Pará', 'PA', 'BRA');
INSERT INTO `geografia`.`Estados` (`id_estado`, `nome`, `sigla_uf`, `fk_pais`) VALUES (16, 'Amapá', 'AM', 'BRA');
INSERT INTO `geografia`.`Estados` (`id_estado`, `nome`, `sigla_uf`, `fk_pais`) VALUES (17, 'Tocantins', 'TO', 'BRA');

<h3>Regiões</h3>
INSERT INTO `geografia`.`Regioes` (`id_regiao`, `nome`) VALUES (1, 'SUL');
INSERT INTO `geografia`.`Regioes` (`id_regiao`, `nome`) VALUES (2, 'SUDESTE');
INSERT INTO `geografia`.`Regioes` (`id_regiao`, `nome`) VALUES (3, 'NORTE');
INSERT INTO `geografia`.`Regioes` (`id_regiao`, `nome`) VALUES (4, 'NORDESTE');
INSERT INTO `geografia`.`Regioes` (`id_regiao`, `nome`) VALUES (5, 'CENTRO-OESTE');

<h3>Mesorregiões</h3>
INSERT INTO `geografia`.`Mesorregioes` (`id_mesorregiao`, `nome`, `fk_id_regiao`) VALUES (86, 'Pelotas', 1);
INSERT INTO `geografia`.`Mesorregioes` (`id_mesorregiao`, `nome`, `fk_id_regiao`) VALUES (87, 'Petrolina', 4);
INSERT INTO `geografia`.`Mesorregioes` (`id_mesorregiao`, `nome`, `fk_id_regiao`) VALUES (88, 'Petrópolis', 2);
INSERT INTO `geografia`.`Mesorregioes` (`id_mesorregiao`, `nome`, `fk_id_regiao`) VALUES (89, 'Picos', 4);
INSERT INTO `geografia`.`Mesorregioes` (`id_mesorregiao`, `nome`, `fk_id_regiao`) VALUES (90, 'Ponta Grossa', 1);
INSERT INTO `geografia`.`Mesorregioes` (`id_mesorregiao`, `nome`, `fk_id_regiao`) VALUES (91, 'Porangatu - Uruaçu', 5);
INSERT INTO `geografia`.`Mesorregioes` (`id_mesorregiao`, `nome`, `fk_id_regiao`) VALUES (92, 'Porto Alegre', 1);
INSERT INTO `geografia`.`Mesorregioes` (`id_mesorregiao`, `nome`, `fk_id_regiao`) VALUES (93, 'Porto Velho', 3);
INSERT INTO `geografia`.`Mesorregioes` (`id_mesorregiao`, `nome`, `fk_id_regiao`) VALUES (94, 'Pouso Alegre', 2);

<h3>Microrregiões</h3>
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (37, 'Araguatins', 4);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (38, 'Arapiraca', 5);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (39, 'Araranguá', 34);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (40, 'Araraquara', 6);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (41, 'Araras', 21);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (42, 'Araripina', 87);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (43, 'Araxá', 127);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (44, 'Arcoverde', 24);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (45, 'Ariquemes', 93);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (46, 'Assis', 73);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (47, 'Atalaia', 70);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (48, 'Avaré', 122);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (49, 'Bacabal', 108);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (50, 'Bagé', 86);
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (51, 'Balsas', 53);

<h3>Cidades</h3>
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2321, 'Francisco Dumont', '-17.3199488056432', '-44.234206527764698', '670.03686600000003', 3126604, 289, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2322, 'Francisco Sá', '-16.332446418215', '-43.422648354033306', '668.01858300000004', 3126703, 289, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2323, 'Franciscópolis', '-17.928496567392198', '-41.913252197717696', '350.75756999999999', 3126752, 464, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2324, 'Frei Gaspar', '-18.071185028091499', '-41.4294207855596', '456.70423599999998', 3126802, 464, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2325, 'Frei Inocêncio', '-18.561789729772801', '-41.901216586517599', '194.934631', 3126901, 188, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2326, 'Frei Lagonegro', '-18.165080712066803', '-42.765295238553698', '664.78857300000004', 3126950, 190, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2327, 'Fronteira', '-20.288300557868499', '-49.204282025130297', '474.594718', 3127008, 182, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2328, 'Fronteira dos Vales', '-16.892015217449501', '-40.925078659448602', '314.79909900000001', 3127057, 13, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2329, 'Fruta de Leite', '-16.1164184229985', '-42.5322219360174', '902.69444499999997', 3127073, 388, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2330, 'Frutal', '-20.111519646719902', '-49.234844235272796', '465.96709600000003', 3127107, 182, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2331, 'Funilândia', '-19.369987332984', '-44.063085880358905', '689.38596600000005', 3127206, 441, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2332, 'Galiléia', '-19.005473642455499', '-41.536197168617704', '133.222498', 3127305, 188, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2333, 'Gameleiras', '-15.076822067506599', '-43.119480839154996', '532.05441399999995', 3127339, 167, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2334, 'Glaucilândia', '-16.850218691818199', '-43.696405897756996', '653.03132100000005', 3127354, 289, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2335, 'Goiabeira', '-18.981713337125498', '-41.2228216102869', '169.429847', 3127370, 188, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2336, 'Goianá', '-21.532417827654701', '-43.191482396977896', '407.61561499999999', 3127388, 251, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2337, 'Gonçalves', '-22.657619187118701', '-45.856592038467099', '1262.9240870000001', 3127404, 216, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2338, 'Gonzaga', '-18.870247123391497', '-42.476017788023498', '615.15249900000003', 3127503, 188, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2339, 'Gouveia', '', '', '', 3127602, 154, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2340, 'Governador Valadares', '-18.860390939848397', '-41.854044215088201', '146.93123199999999', 3127701, 188, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2341, 'Grão Mogol', '-16.406313478447', '-43.228984849719502', '932.16237100000001', 3127800, 289, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2342, 'Grupiara', '-18.4930238023097', '-47.724798435021498', '670.51733999999999', 3127909, 286, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2343, 'Guanhães', '-18.6702479509899', '-42.773425688034202', '774.83979499999998', 3128006, 190, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2344, 'Guapé', '-20.693596992590098', '-45.912458814197898', '791.51962100000003', 3128105, 324, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2345, 'Guaraciaba', '-20.571703500985901', '-43.011281647175196', '587.16985799999998', 3128204, 353, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2346, 'Guaraciama', '-17.0115274631445', '-43.668777705754898', '783.87720100000001', 3128253, 289, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2347, 'Guaranésia', '-21.305560370659897', '-46.795491220295901', '796.61921299999995', 3128303, 195, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2348, 'Guarani', '-21.362669185930102', '-43.046456684007801', '417.313804', 3128402, 482, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2349, 'Guarará', '-21.732720300845301', '-43.038952478112201', '563.05607899999995', 3128501, 419, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2350, 'Guarda-Mor', '-17.771299897784399', '-47.101075853497498', '610.39487999999994', 3128600, 327, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2351, 'Guaxupé', '-21.303781464747601', '-46.713537230976598', '847.13171299999999', 3128709, 195, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2352, 'Guidoval', '-21.144238503299999', '-42.800817312061', '341.15989200000001', 3128808, 482, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2353, 'Guimarânia', '-18.838019215062399', '-46.797265032321597', '899.69279100000006', 3128907, 328, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2354, 'Guiricema', '-21.0106733747952', '-42.718812469754496', '330.82869199999999', 3129004, 482, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2355, 'Gurinhatã', '-18.932425095862801', '-49.839466118064195', '535.83518700000002', 3129103, 225, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2356, 'Heliodora', '-22.064744440516098', '-45.544576634052703', '850.44317699999999', 3129202, 362, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2357, 'Iapu', '-19.440272449235497', '-42.214692514782399', '435.70469500000002', 3129301, 205, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2358, 'Ibertioga', '-21.429472482041202', '-43.968123835075303', '1020.912752', 3129400, 52, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2359, 'Ibiá', '-19.672772482298299', '-46.682262476134596', '910.85421399999996', 3129509, 43, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2360, 'Ibiaí', '-16.8598724483642', '-44.914106838717899', '483.85810300000003', 3129608, 344, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2361, 'Ibiracatu', '-15.7426253548433', '-44.234146733035104', '799.29075799999998', 3129657, 289, 31);
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2362, 'Ibiraci', '-20.470154879298001', '-47.130803490680101', '1072.3281890000001', 3129707, 324, 31);

Você pode contribuir com o projeto com sugestões de melhorias e atualizações, ou corrigindo eventuais erros. Para tanto abra uma Issue ou dê um Pull request.

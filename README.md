# Base-Geopolitica
Este projeto tem o objetivo de disponibilizar um banco de dados com informações geográficas para serem usadas em sistemas de informações que necessitam, para qualquer tarefa, fazer uso de informações como: País, Estado, Região e subrregiões, e Cidades.

Para tanto foi projetado um banco de dados otimizado de acordo com as normas de otimização de tabelas e relacionamentos, o qual é apresentado pela sua documentação, Diagrama Entidade-Relacionamento (DER) que pode ser acessado na pasta de Documentação deste projeto.

<h3>DER:</h3>
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
<h4>Países</h4>
<code>
INSERT INTO `geografia`.`Paises` (`nome`, `iso_alpha2`, `iso_alpha3`, `iso_numero`) VALUES ('Chile', 'CL', ' CHL', ' 152');
</code>

<h4>Estados</h4>
<code>
INSERT INTO `geografia`.`Estados` (`id_estado`, `nome`, `sigla_uf`, `fk_pais`) VALUES (13, 'Amazonas', 'AM', 'BRA');
</code>

<h4>Regiões</h4>
<code>
INSERT INTO `geografia`.`Regioes` (`id_regiao`, `nome`) VALUES (1, 'SUL');
</code>

<h4>Mesorregiões</h4>
<code>
INSERT INTO `geografia`.`Mesorregioes` (`id_mesorregiao`, `nome`, `fk_id_regiao`) VALUES (88, 'Petrópolis', 2);
</code>

<h4>Microrregiões</h4>
<code>
INSERT INTO `geografia`.`Microrregioes` (`id_micrroregiao`, `nome`, `fk_id_mesoregiao`) VALUES (43, 'Araxá', 127);
</code>

<h4>Cidades</h4>
<code>
INSERT INTO `geografia`.`Cidades` (`id_cidade`, `nome`, `geo_latitude`, `geo_longitude`, `geo_altitude`, `codigo_ibge`, `fk_id_microrregiao`, `fk_id_estado`) VALUES (2336, 'Goianá', '-21.532417827654701', '-43.191482396977896', '407.61561499999999', 3127388, 251, 31);
</code>

<h4>Download</h4>
<a href="https://github.com/izaquiellbessas/Base-Geopolitica/archive/master.zip"> Clique aqui para fazer download completo do projeto. </a>

<h4>Contribuir</h4>
<p>
Você pode contribuir com o projeto com sugestões de melhorias e atualizações, ou corrigindo eventuais erros. Para tanto abra uma Issue ou dê um Pull request.
</p>

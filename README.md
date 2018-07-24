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

: Entregando mercadorias

O Walmart esta desenvolvendo um novo sistema de log�stica e sua ajuda � muito importante neste momento. Sua tarefa ser� desenvolver o novo sistema de entregas visando sempre o menor custo. Para popular sua base de dados o sistema precisa expor um Webservices que aceite o formato de malha log�stica (exemplo abaixo), nesta mesma requisi��o o requisitante dever� informar um nome para este mapa. � importante que os mapas sejam persistidos para evitar que a cada novo deploy todas as informa��es desapare�am. O formato de malha log�stica � bastante simples, cada linha mostra uma rota: ponto de origem, ponto de destino e dist�ncia entre os pontos em quil�metros.

A B 10

B D 15

A C 20

C D 30

B E 50

D E 30

Com os mapas carregados o requisitante ir� procurar o menor valor de entrega e seu caminho, para isso ele passar� o mapa, nome do ponto de origem, nome do ponto de destino, autonomia do caminh�o (km/l) e o valor do litro do combust�vel, agora sua tarefa � criar este Webservices. Um exemplo de entrada seria, mapa SP, origem A, destino D, autonomia 10, valor do litro 2,50; a resposta seria a rota A B D com custo de 6,25.

Voc� est� livre para definir a melhor arquitetura e tecnologias para solucionar este desafio, mas n�o se esque�a de contar sua motiva��o no arquivo README que deve acompanhar sua solu��o, junto com os detalhes de como executar seu programa. Documenta��o e testes ser�o avaliados tamb�m

=) Lembre-se de que iremos executar seu c�digo com malhas bem mais complexas, por isso � importante pensar em requisitos n�o funcionais tamb�m!!

Tamb�m gostar�amos de acompanhar o desenvolvimento da sua aplica��o atrav�s do c�digo fonte. Por isso, solicitamos a cria��o de um reposit�rio que seja compartilhado com a gente. Para o desenvolvimento desse sistema, n�s solicitamos que voc� utilize a sua (ou as suas) linguagem de programa��o principal. Pode ser Java, JavaScript ou Ruby.

 
Solu��o
-------

**Arquitetura**

desenvolvimento usando a Plataforma JEE 7 - Java Enterprise Edition, 
Java Persistence API (JPA),
SOAP para Web Services, 
Simple Logging Facade for Java (SL4J), como facade para o Log4j. 
Testes unit�rios foi utilizado o JUnit, na versão 4.11.


**Softwares necess�rios**

  * Oracle JDK 8u25


**Execu��o**

  * Cadastrar Malha
  * Calcular Rota de Menor Custo
  


